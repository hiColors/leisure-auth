package com.github.hicolors.leisure.member.application.service.impl;

import com.github.hicolors.leisure.common.utils.ColorsBeanUtils;
import com.github.hicolors.leisure.member.application.exception.EnumCodeMessage;
import com.github.hicolors.leisure.member.application.exception.MemberServerException;
import com.github.hicolors.leisure.member.application.repository.*;
import com.github.hicolors.leisure.member.application.service.PlatformService;
import com.github.hicolors.leisure.member.model.consts.EnumPlatformStatus;
import com.github.hicolors.leisure.member.model.model.platform.*;
import com.github.hicolors.leisure.member.model.persistence.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private PlatformOrganizationRepository organizationRepository;

    @Autowired
    private PlatformMemberRepository pmemberRepository;

    @Autowired
    private PlatformJobRepository jobRepository;

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
    @Transactional(rollbackFor = Exception.class)
    public Platform modifyAll(Platform platform, PlatformPatchModel model) {
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
    public PlatformOrganization queryOnePlatformOrganizationByPlatform(Platform platform) {
        return organizationRepository.findByPlatformAndLevelEquals0(platform.getId());
    }

    @Override
    public PlatformOrganization createOrganization(Platform platform, PlatformOrganizationModel model) {
        return null;
    }

    @Override
    public PlatformOrganization modifyOrganization(Platform platform, PlatformOrganizationPatchModel model) {
        return null;
    }

    @Override
    public PlatformOrganization queryOnePlatformOrganizationById(Long id) {
        return organizationRepository.findById(id).orElse(null);
    }

    @Override
    public PlatformJob createJob(Platform platform, PlatformJobModel model) {
        return null;
    }

    @Override
    public PlatformJob modifyJob(Platform platform, PlatformJobPatchModel model) {
        return null;
    }

    @Override
    public PlatformMember createMember(Platform platform, PlatformOrganization organization, PlatformMemberModel model) {
        return null;
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
}
