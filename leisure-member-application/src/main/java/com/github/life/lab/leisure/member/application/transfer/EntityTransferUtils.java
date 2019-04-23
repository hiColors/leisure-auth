package com.github.life.lab.leisure.member.application.transfer;

import com.github.life.lab.leisure.member.application.entity.*;
import com.github.life.lab.leisure.member.model.resource.member.Member;
import com.github.life.lab.leisure.member.model.resource.platform.Platform;
import com.github.life.lab.leisure.member.model.resource.platform.PlatformJob;
import com.github.life.lab.leisure.member.model.resource.platform.PlatformMember;
import com.github.life.lab.leisure.member.model.resource.platform.PlatformOrganization;
import com.github.life.lab.leisure.member.model.resource.role.Role;
import com.github.lifelab.leisure.common.utils.ColorsBeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 数据库对象和业务对象转换工具
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2019-01-26
 */
public class EntityTransferUtils {

    public static Member transferEMember(EMember eMember) {
        if (Objects.isNull(eMember)) {
            return null;
        }
        Member member = new Member();
        ColorsBeanUtils.copyPropertiesNonNull(eMember, member);
        ColorsBeanUtils.copyPropertiesNonNull(eMember.getMemberDetail(), member);
        if (Objects.nonNull(eMember.getMemberDetail().getPlatform())) {
            member.setPlatformId(eMember.getMemberDetail().getPlatform().getId());
            member.setPlatformName(eMember.getMemberDetail().getPlatform().getName());
        }
        return member;
    }

    public static Role transferERole(ERole eRole) {
        if (Objects.isNull(eRole)) {
            return null;
        }
        Role role = new Role();
        ColorsBeanUtils.copyPropertiesNonNull(eRole, role);
        return role;
    }

    public static Platform transferEPlatform(EPlatform ePlatform) {
        if (Objects.isNull(ePlatform)) {
            return null;
        }
        Platform platform = new Platform();
        ColorsBeanUtils.copyPropertiesNonNull(ePlatform, platform);
        return platform;
    }

    public static PlatformOrganization transferEPlatformOrganization(EPlatformOrganization ePlatformOrganization) {
        if (Objects.isNull(ePlatformOrganization)) {
            return null;
        }
        PlatformOrganization po = new PlatformOrganization();
        ColorsBeanUtils.copyPropertiesNonNull(ePlatformOrganization, po);
        if (Objects.nonNull(ePlatformOrganization.getParent())) {
            po.setParentId(ePlatformOrganization.getParent().getId());
            po.setParentName(ePlatformOrganization.getParent().getName());
        }
        if (!CollectionUtils.isEmpty(ePlatformOrganization.getChildren())) {
            List<PlatformOrganization> lists = new ArrayList<>();
            ePlatformOrganization.getChildren().forEach(e -> {
                PlatformOrganization temp = new PlatformOrganization();
                ColorsBeanUtils.copyPropertiesNonNull(e, temp);
                temp.setParentId(e.getParent().getId());
                temp.setParentName(e.getParent().getName());
                lists.add(temp);
            });
            po.setChildren(lists);
        }
        return po;
    }

    public static PlatformJob transferEPlatformJob(EPlatformJob ePlatformJob) {
        if (Objects.isNull(ePlatformJob)) {
            return null;
        }
        PlatformJob pj = new PlatformJob();
        ColorsBeanUtils.copyPropertiesNonNull(ePlatformJob, pj);
        return pj;
    }

    public static PlatformMember transferEPlatformMember(EPlatformMember ePlatformMember) {
        if (Objects.isNull(ePlatformMember)) {
            return null;
        }
        PlatformMember pm = new PlatformMember();
        ColorsBeanUtils.copyPropertiesNonNull(ePlatformMember, pm);
        if (Objects.nonNull(ePlatformMember.getPlatformJob())) {
            pm.setJobId(ePlatformMember.getPlatformJob().getId());
            pm.setJobLevel(ePlatformMember.getPlatformJob().getLevel());
            pm.setJobTitle(ePlatformMember.getPlatformJob().getTitle());
        }
        if (Objects.nonNull(ePlatformMember.getPlatform())) {
            pm.setPlatformId(ePlatformMember.getPlatform().getId());
            pm.setPlatformName(ePlatformMember.getPlatform().getName());
        }
        if (Objects.nonNull(ePlatformMember.getPlatformOrganization())) {
            pm.setOrganizationId(ePlatformMember.getPlatformOrganization().getId());
            pm.setOrganizationName(ePlatformMember.getPlatformOrganization().getName());
        }
        if (Objects.nonNull(ePlatformMember.getMember())) {
            pm.setMobile(ePlatformMember.getMember().getMobile());
        }
        return pm;
    }
}
