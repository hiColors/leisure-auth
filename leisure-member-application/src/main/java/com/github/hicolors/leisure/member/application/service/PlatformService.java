package com.github.hicolors.leisure.member.application.service;

import com.github.hicolors.leisure.member.model.model.platform.PlatformModel;
import com.github.hicolors.leisure.member.model.model.platform.PlatformPatchModel;
import com.github.hicolors.leisure.member.model.persistence.Platform;

/**
 * PlatformService
 *
 * @author zyf
 * @date 2018/10/31
 */
public interface PlatformService {

    Platform create(PlatformModel model);

    Platform modify(Platform platform, PlatformPatchModel model);

    Platform modifyAll(Platform platform, PlatformPatchModel model);

    Platform queryOne(Long id);
}
