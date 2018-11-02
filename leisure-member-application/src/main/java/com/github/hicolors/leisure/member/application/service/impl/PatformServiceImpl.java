package com.github.hicolors.leisure.member.application.service.impl;

import com.github.hicolors.leisure.common.utils.ColorsBeanUtils;
import com.github.hicolors.leisure.member.application.exception.EnumCodeMessage;
import com.github.hicolors.leisure.member.application.exception.MemberServerException;
import com.github.hicolors.leisure.member.application.repository.MemberRepository;
import com.github.hicolors.leisure.member.application.repository.PlatformMemberRepository;
import com.github.hicolors.leisure.member.application.repository.PlatformOrganizationRepository;
import com.github.hicolors.leisure.member.application.repository.PlatformRepository;
import com.github.hicolors.leisure.member.application.service.PlatformService;
import com.github.hicolors.leisure.member.model.consts.EnumPlatformStatus;
import com.github.hicolors.leisure.member.model.model.platform.PlatformModel;
import com.github.hicolors.leisure.member.model.model.platform.PlatformPatchModel;
import com.github.hicolors.leisure.member.model.persistence.Member;
import com.github.hicolors.leisure.member.model.persistence.Platform;
import com.github.hicolors.leisure.member.model.persistence.PlatformMember;
import com.github.hicolors.leisure.member.model.persistence.PlatformOrganization;
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
    private PlatformOrganizationRepository organizationRepository;

    @Autowired
    private PlatformMemberRepository platformMemberRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Platform create(PlatformModel model) {
        //创建平台需要同步创建平台下的 0 级组织架构
        Optional<Member> optional = memberRepository.findById(model.getMemberId());
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

        PlatformOrganization po = new PlatformOrganization();
        po.setPlatform(platform);
        po.setLevel(0);
        po.setParent(new PlatformOrganization(0L));
        po.setName(platform.getName());
        po.setComment("自动创建的全员群");
        organizationRepository.save(po);

        PlatformMember pm = new PlatformMember();
        pm.setPlatform(platform);
        pm.setPlatformOrganization(po);
        pm.setMember(member);
        pm.setEntryDate(new Date());
        pm.setName(member.getMemberDetail().getName());
        platformMemberRepository.save(pm);

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
    public Platform queryOne(Long id) {
        Optional<Platform> platform = repository.findById(id);
        return platform.orElse(null);
    }

    @Override
    public PlatformOrganization queryOnePlatformOrganization(Long id) {
        return organizationRepository.findByPlatformAndLevelEquals0(id);
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
