package com.github.life.lab.leisure.member.application.service;

import com.github.life.lab.leisure.common.model.expression.ColorsExpression;
import com.github.life.lab.leisure.member.model.model.platform.*;
import com.github.life.lab.leisure.member.model.persistence.Platform;
import com.github.life.lab.leisure.member.model.persistence.PlatformJob;
import com.github.life.lab.leisure.member.model.persistence.PlatformMember;
import com.github.life.lab.leisure.member.model.persistence.PlatformOrganization;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * PlatformService
 *
 * @author zyf
 * @date 2018/10/31
 */
public interface PlatformService {

    Platform create(PlatformModel model);

    Platform modify(Platform platform, PlatformPatchModel model);

    Platform queryOneById(Long id);

    PlatformJob queryOnePlatformJobById(Long id);

    PlatformOrganization queryOnePlatformOrganizationById(Long id);

    PlatformMember queryOnePlatformMemberById(Long id);

    PlatformOrganization queryOnePlatformOrganizationByPlatform(Platform platform);

    PlatformOrganization createOrganization(Platform platform, PlatformOrganizationModel model);

    PlatformOrganization modifyOrganization(Platform platform, PlatformOrganization organization, PlatformOrganizationPatchModel model);

    PlatformJob createJob(Platform platform, PlatformJobModel model);

    PlatformJob modifyJob(Platform platform, PlatformJob job, PlatformJobPatchModel model);

    Page<PlatformMember> queryPlatformMember(Platform platform, PlatformOrganization organization, Pageable pageable, List<ColorsExpression> filters);

    PlatformMember createMember(Platform platform, PlatformOrganization organization, PlatformMemberModel model);

    PlatformMember modifyMember(Platform platform, PlatformOrganization organization, PlatformMember platformMember, PlatformMemberPatchModel model);
}
