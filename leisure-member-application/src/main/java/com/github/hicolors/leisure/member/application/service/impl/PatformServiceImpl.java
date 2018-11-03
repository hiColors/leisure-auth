package com.github.hicolors.leisure.member.application.service.impl;

import com.github.hicolors.leisure.common.utils.ColorsBeanUtils;
import com.github.hicolors.leisure.member.application.exception.EnumCodeMessage;
import com.github.hicolors.leisure.member.application.exception.MemberServerException;
import com.github.hicolors.leisure.member.application.repository.*;
import com.github.hicolors.leisure.member.application.service.PlatformService;
import com.github.hicolors.leisure.member.model.consts.EnumPlatformStatus;
import com.github.hicolors.leisure.member.model.model.platform.*;
import com.github.hicolors.leisure.member.model.persistence.*;
import com.github.hicolors.leisure.member.model.persistence.value.MemberDefaultValue;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by zhaoyf on 2018/10/31
 */
@Service
@Slf4j
public class PatformServiceImpl implements PlatformService {

    @Autowired
    private PlatformRepository repository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberDetailRepository memberDetailRepository;

    @Autowired
    private PlatformOrganizationRepository organizationRepository;

    @Autowired
    private PlatformMemberRepository pmemberRepository;

    @Autowired
    private PlatformJobRepository jobRepository;

    @Autowired
    private CheckService checkService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Platform create(PlatformModel model) {
        //创建平台需要同步创建平台下的 0 级组织架构 (具体逻辑在 监听器中)
        Optional<Member> optional = memberRepository.findById(model.getOriginator());
        Member member = optional.orElse(null);
        if (Objects.isNull(member)) {
            throw new MemberServerException(EnumCodeMessage.MEMBER_NON_EXIST);
        }
        checkName(model.getName(), null);
        Platform platform = new Platform();
        //刚添加的平台信息状态 默认开启
        platform.setStatus(EnumPlatformStatus.ENABLE);
        BeanUtils.copyProperties(model, platform);
        repository.save(platform);
        return platform;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Platform modify(Platform platform, PlatformPatchModel model) {
        checkName(model.getName(), platform.getId());
        ColorsBeanUtils.copyPropertiesNonNull(model, platform);
        return repository.saveAndFlush(platform);
    }

    @Override
    public Platform queryOneById(Long id) {
        Optional<Platform> platform = repository.findById(id);
        return platform.orElse(null);
    }

    @Override
    public PlatformJob queryOnePlatformJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public PlatformOrganization queryOnePlatformOrganizationByPlatform(Platform platform) {
        return organizationRepository.findByPlatformAndLevelEquals0(platform.getId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PlatformOrganization createOrganization(Platform platform, PlatformOrganizationModel model) {
        checkOrganizationName(platform.getId(), model.getName(), null);
        PlatformOrganization parent = queryOnePlatformOrganizationById(model.getParent());
        if (Objects.isNull(parent)) {
            throw new MemberServerException(EnumCodeMessage.PLATFORM_PARENT_ORGANIZATION_NON_EXIST);
        }
        PlatformOrganization po = new PlatformOrganization();
        ColorsBeanUtils.copyPropertiesNonNull(model, po);
        po.setPlatform(platform);
        po.setParent(parent);
        po.setLevel(po.getParent().getLevel() + 1);
        return organizationRepository.save(po);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PlatformOrganization modifyOrganization(Platform platform, PlatformOrganization organization, PlatformOrganizationPatchModel model) {
        if (!organization.getPlatform().getId().equals(platform.getId())) {
            throw new MemberServerException(EnumCodeMessage.PLATFORM_ORGANIZATION_MISMATCHES);
        }
        if (Objects.nonNull(model.getParent())) {
            PlatformOrganization parent = queryOnePlatformOrganizationById(model.getParent());
            if (Objects.isNull(parent)) {
                throw new MemberServerException(EnumCodeMessage.PLATFORM_PARENT_ORGANIZATION_NON_EXIST);
            }
            organization.setParent(parent);
        }
        ColorsBeanUtils.copyPropertiesNonNull(model, organization);
        checkOrganizationName(platform.getId(), organization.getName(), organization.getId());
        organization.setLevel(organization.getParent().getLevel() + 1);
        return organizationRepository.saveAndFlush(organization);
    }


    @Override
    public PlatformOrganization queryOnePlatformOrganizationById(Long id) {
        return organizationRepository.findById(id).orElse(null);
    }

    @Override
    public PlatformJob createJob(Platform platform, PlatformJobModel model) {
        checkJobTitle(platform.getId(), model.getTitle(), null);
        PlatformJob pj = new PlatformJob();
        pj.setPlatform(platform);
        ColorsBeanUtils.copyPropertiesNonNull(model, pj);
        return jobRepository.save(pj);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PlatformJob modifyJob(Platform platform, PlatformJob job, PlatformJobPatchModel model) {
        if (!job.getPlatform().getId().equals(platform.getId())) {
            throw new MemberServerException(EnumCodeMessage.PLATFORM_JOB_MISMATCHES);
        }
        ColorsBeanUtils.copyPropertiesNonNull(model, job);
        checkJobTitle(platform.getId(), model.getTitle(), job.getId());
        return jobRepository.saveAndFlush(job);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PlatformMember createMember(Platform platform, PlatformOrganization organization, PlatformMemberModel model) {
        checkService.checkMobile(model.getMobile(), null);
        checkService.checkEmail(model.getEmail(), null);
        PlatformJob job = queryOnePlatformJobById(model.getJobId());
        if (Objects.isNull(job)) {
            throw new MemberServerException(EnumCodeMessage.PLATFORM_JOB_NON_EXIST);
        }
        if (!organization.getPlatform().getId().equals(platform.getId())) {
            throw new MemberServerException(EnumCodeMessage.PLATFORM_ORGANIZATION_MISMATCHES);
        }
        if (!job.getPlatform().getId().equals(platform.getId())) {
            throw new MemberServerException(EnumCodeMessage.PLATFORM_JOB_MISMATCHES);
        }
        //1. 创建人员信息
        Member member = new Member();
        member.setUsername(MemberDefaultValue.generatorUserName());
        member.setCredentialsExpiredDate(MemberDefaultValue.generatorDefaultExpiredDate());
        member.setEnabled(true);
        member.setExpiredDate(MemberDefaultValue.generatorDefaultExpiredDate());
        member.setLockStatus(false);
        member.setNickName(model.getName());
        member.setPassword(model.getMobile());
        memberRepository.save(member);
        MemberDetail memberDetail = new MemberDetail();
        memberDetail.setId(member.getId());
        ColorsBeanUtils.copyPropertiesNonNull(model, memberDetail);
        if (Objects.isNull(memberDetail.getAvatar())) {
            memberDetail.setAvatar(MemberDefaultValue.AVATAR);
        }
        if (Objects.isNull(memberDetail.getBirthday())) {
            memberDetail.setBirthday(MemberDefaultValue.BIRTHDAY);
        }
        if (Objects.isNull(memberDetail.getDescription())) {
            memberDetail.setDescription(MemberDefaultValue.DESCRIPTION);
        }
        if (Objects.isNull(memberDetail.getWebsite())) {
            memberDetail.setWebsite(MemberDefaultValue.WEBSITE);
        }
        memberDetailRepository.save(memberDetail);
        member.setMemberDetail(memberDetail);
        //创建平台员工信息
        PlatformMember pm = new PlatformMember();
        pm.setPlatform(platform);
        pm.setPlatformOrganization(organization);
        pm.setMember(member);
        pm.setName(memberDetail.getName());
        pm.setEntryDate(new Date());
        //返回结果
        return pmemberRepository.save(pm);
    }

    private void checkName(String name, Long id) {
        Platform platform = repository.findByName(name);
        if (Objects.nonNull(platform)) {
            id = ObjectUtils.defaultIfNull(id, 0L);
            if (!id.equals(platform.getId())) {
                throw new MemberServerException(EnumCodeMessage.PLATFORM_NAME_EXIST);
            }
        }
    }

    private void checkOrganizationName(Long pid, String name, Long id) {
        PlatformOrganization po = organizationRepository.findByPlatformIdAndName(pid, name);
        if (Objects.nonNull(po)) {
            id = ObjectUtils.defaultIfNull(id, 0L);
            if (!id.equals(po.getId())) {
                throw new MemberServerException(EnumCodeMessage.PLATFORM_ORGANIZATION_NAME_EXIST);
            }
        }
    }

    private void checkJobTitle(Long pid, String title, Long id) {
        PlatformJob pj = jobRepository.findByPlatformIdAndTitle(pid, title);
        if (Objects.nonNull(pj)) {
            id = ObjectUtils.defaultIfNull(id, 0L);
            if (!id.equals(pj.getId())) {
                throw new MemberServerException(EnumCodeMessage.PLATFORM_JOB_TITLE_EXIST);
            }
        }
    }

}
