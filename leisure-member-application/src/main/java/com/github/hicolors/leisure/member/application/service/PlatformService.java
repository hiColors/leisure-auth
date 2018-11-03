package com.github.hicolors.leisure.member.application.service;

import com.github.hicolors.leisure.member.model.model.platform.*;
import com.github.hicolors.leisure.member.model.persistence.Platform;
import com.github.hicolors.leisure.member.model.persistence.PlatformJob;
import com.github.hicolors.leisure.member.model.persistence.PlatformMember;
import com.github.hicolors.leisure.member.model.persistence.PlatformOrganization;

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

    PlatformOrganization queryOnePlatformOrganizationByPlatform(Platform platform);

    PlatformOrganization createOrganization(Platform platform, PlatformOrganizationModel model);

    PlatformOrganization modifyOrganization(Platform platform, PlatformOrganization organization, PlatformOrganizationPatchModel model);

    PlatformOrganization queryOnePlatformOrganizationById(Long id);

    PlatformJob createJob(Platform platform, PlatformJobModel model);

    PlatformJob modifyJob(Platform platform, PlatformJob job, PlatformJobPatchModel model);

    PlatformMember createMember(Platform platform, PlatformOrganization organization, PlatformMemberModel model);
}
