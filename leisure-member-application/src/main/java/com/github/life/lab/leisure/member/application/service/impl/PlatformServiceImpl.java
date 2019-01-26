package com.github.life.lab.leisure.member.application.service.impl;

import com.github.life.lab.leisure.common.utils.ColorsBeanUtils;
import com.github.life.lab.leisure.member.application.entity.EPlatform;
import com.github.life.lab.leisure.member.application.entity.EPlatformJob;
import com.github.life.lab.leisure.member.application.entity.EPlatformMember;
import com.github.life.lab.leisure.member.application.entity.EPlatformOrganization;
import com.github.life.lab.leisure.member.application.entity.enums.EnumPlatformStatus;
import com.github.life.lab.leisure.member.application.repository.EPlatformJobRepository;
import com.github.life.lab.leisure.member.application.repository.EPlatformMemberRepository;
import com.github.life.lab.leisure.member.application.repository.EPlatformOrganizationRepository;
import com.github.life.lab.leisure.member.application.repository.EPlatformRepository;
import com.github.life.lab.leisure.member.application.service.MemberService;
import com.github.life.lab.leisure.member.application.service.PlatformService;
import com.github.life.lab.leisure.member.application.transfer.EntityTransferUtils;
import com.github.life.lab.leisure.member.model.exception.EnumLeisureMemberCodeMessage;
import com.github.life.lab.leisure.member.model.exception.LeisureMemberException;
import com.github.life.lab.leisure.member.model.resource.member.Member;
import com.github.life.lab.leisure.member.model.resource.platform.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Objects;

/**
 * PlatformServiceImpl
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2019-01-20
 */
@Service
public class PlatformServiceImpl implements PlatformService {

    @Autowired
    private EPlatformRepository platformRepository;

    @Autowired
    private EPlatformOrganizationRepository organizationRepository;

    @Autowired
    private EPlatformJobRepository jobRepository;

    @Autowired
    private EPlatformMemberRepository memberRepository;

    @Autowired
    private MemberService memberService;

    @Override
    public Platform create(PlatformModel model) {
        Member member = memberService.queryOneById(model.getOriginator());
        if (Objects.isNull(member)) {
            throw new LeisureMemberException(EnumLeisureMemberCodeMessage.MEMBER_NON_EXIST, "发起人通过 id 查询不存在");
        }
        checkPlatformName(model.getName(), null);
        EPlatform ePlatform = new EPlatform();
        ColorsBeanUtils.copyPropertiesNonNull(model, ePlatform);
        ePlatform.setOriginator(member.getId());
        ePlatform.setOriginatorName(member.getName());
        ePlatform.setStatus(EnumPlatformStatus.REVIEW);
        platformRepository.save(ePlatform);
        return EntityTransferUtils.transferEPlatform(ePlatform);
    }

    @Override
    public Platform modify(Long id, PlatformPatchModel model) {
        EPlatform ePlatform = getPlatformById(id);
        if (Objects.isNull(ePlatform)) {
            throw new LeisureMemberException(EnumLeisureMemberCodeMessage.PLATFORM_NON_EXIST);
        }
        if (Objects.nonNull(model.getName())) {
            checkPlatformName(model.getName(), id);
        }
        ColorsBeanUtils.copyPropertiesNonNull(model, ePlatform);
        if (Objects.nonNull(model.getStatus())) {
            ePlatform.setStatus(EnumPlatformStatus.valueOfValue(model.getStatus()));
        }
        platformRepository.saveAndFlush(ePlatform);
        return EntityTransferUtils.transferEPlatform(ePlatform);
    }

    @Override
    public Platform query(Long id) {
        return EntityTransferUtils.transferEPlatform(getPlatformById(id));
    }

    @Override
    public PlatformOrganization createOrganization(Long id, PlatformOrganizationModel model) {
        EPlatform ePlatform = getPlatformById(id);
        if (Objects.isNull(ePlatform)) {
            throw new LeisureMemberException(EnumLeisureMemberCodeMessage.PLATFORM_NON_EXIST);
        }
        checkOrganizationAssociation(id, model.getParent());
        EPlatformOrganization parent = getOrganizationById(model.getParent());
        EPlatformOrganization epo = new EPlatformOrganization();
        ColorsBeanUtils.copyPropertiesNonNull(model, epo);
        epo.setParent(parent);
        epo.setPlatform(parent.getPlatform());
        epo.setLevel(parent.getLevel() + 1);
        organizationRepository.save(epo);
        return EntityTransferUtils.transferEPlatformOrganization(epo);
    }

    @Override
    public PlatformOrganization modifyOrganization(Long id, Long oid, PlatformOrganizationPatchModel model) {
        checkOrganizationAssociation(id, oid);
        EPlatformOrganization epo = getOrganizationById(oid);
        ColorsBeanUtils.copyPropertiesNonNull(model, epo);
        if (Objects.nonNull(model.getParent())) {
            EPlatformOrganization parent = getOrganizationById(model.getParent());
            epo.setParent(parent);
            epo.setLevel(parent.getLevel() + 1);
        }
        organizationRepository.saveAndFlush(epo);
        return EntityTransferUtils.transferEPlatformOrganization(epo);
    }

    @Override
    public void deleteOrganization(Long id, Long oid) {
        checkOrganizationAssociation(id, oid);
        EPlatformOrganization epo = getOrganizationById(id);
        if (epo.getLevel().equals(0)) {
            throw new LeisureMemberException(EnumLeisureMemberCodeMessage.PLATFORM_ORGANIZATION_ROOT_DENY_DELETE);
        } else if (!CollectionUtils.isEmpty(epo.getChildren())) {
            throw new LeisureMemberException(EnumLeisureMemberCodeMessage.PLATFORM_ORGANIZATION_CHILDREN_EXIST);
        } else if (memberRepository.existsByPlatformOrganizationIdAndPlatformId(oid, id)) {
            throw new LeisureMemberException(EnumLeisureMemberCodeMessage.PLATFORM_ORGANIZATION_MEMBER_EXIST);
        } else {
            organizationRepository.delete(epo);
        }
    }

    @Override
    public PlatformOrganization queryBaseOrganization(Long id) {
        return EntityTransferUtils.transferEPlatformOrganization(organizationRepository.findByPlatformAndLevelEquals0(id));
    }

    @Override
    public PlatformOrganization queryOrganization(Long id, Long oid) {
        checkOrganizationAssociation(id, oid);
        return EntityTransferUtils.transferEPlatformOrganization(getOrganizationById(oid));
    }

    @Override
    public PlatformJob createJob(Long id, PlatformJobModel model) {
        EPlatform ePlatform = getPlatformById(id);
        if (Objects.isNull(ePlatform)) {
            throw new LeisureMemberException(EnumLeisureMemberCodeMessage.PLATFORM_NON_EXIST);
        }
        return null;
    }

    @Override
    public void deleteJob(Long id, Long jid) {

    }

    @Override
    public PlatformJob modifyJob(Long id, Long jid, PlatformJobPatchModel model) {
        return null;
    }

    @Override
    public PlatformJob queryJob(Long id, Long jid) {


        return null;
    }

    @Override
    public PlatformMember createMember(Long id, PlatformMemberModel model) {
        return null;
    }

    @Override
    public void deleteMember(Long id, Long mid) {

    }

    @Override
    public PlatformMember modifyMember(Long id, Long mid, PlatformMemberPatchModel model) {
        return null;
    }

    @Override
    public PlatformMember queryMember(Long id, Long mid) {
        return null;
    }

    @Override
    public void checkPlatformName(String platformName, Long id) {
        EPlatform ePlatform = platformRepository.findByName(platformName);
        if (Objects.nonNull(ePlatform) && !ePlatform.getId().equals(id)) {
            throw new LeisureMemberException(EnumLeisureMemberCodeMessage.PLATFORM_NAME_EXIST);
        }
    }

    @Override
    public void checkOrganizationAssociation(Long id, Long oid) {
        if (!organizationRepository.existsByIdAndPlatformId(oid, id)) {
            throw new LeisureMemberException(EnumLeisureMemberCodeMessage.PLATFORM_ORGANIZATION_MISMATCHES);
        }
    }

    @Override
    public void checkJobAssociation(Long id, Long jid) {
        if (!jobRepository.existsByIdAndPlatformId(jid, id)) {
            throw new LeisureMemberException(EnumLeisureMemberCodeMessage.PLATFORM_JOB_MISMATCHES);
        }
    }

    private EPlatform getPlatformById(Long id) {
        return platformRepository.findById(id).orElse(null);
    }

    private EPlatformOrganization getOrganizationById(Long id) {
        return organizationRepository.findById(id).orElse(null);
    }

    private EPlatformJob getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    private EPlatformMember getMemberById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

}