package com.github.hicolors.leisure.member.api;

import com.github.hicolors.leisure.member.model.model.platform.PlatformModel;
import com.github.hicolors.leisure.member.model.model.platform.PlatformPatchModel;
import com.github.hicolors.leisure.member.model.persistence.Platform;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * PlatformApi
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/28
 */

@Api(tags = "platform", description = "对平台的相关操作")
@RequestMapping("platform")
public interface PlatformApi {

    @ApiOperation("平台 - 创建")
    @PostMapping
    Platform create(@RequestBody PlatformModel model);

    @ApiOperation("平台 - 全部修改（不传字段修改为 null）")
    @PutMapping("/{id}")
    Platform modifyAll(@PathVariable("id") Long id, @RequestBody PlatformPatchModel model);

    @ApiOperation("平台 - 部分修改")
    @PatchMapping("/{id}")
    Platform modify(@PathVariable("id") Long id, @RequestBody PlatformPatchModel model);

}