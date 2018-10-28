package com.github.hicolors.leisure.member.application.rest;

import com.github.hicolors.leisure.member.api.PlatformApi;
import com.github.hicolors.leisure.member.model.model.platform.PlatformModel;
import com.github.hicolors.leisure.member.model.model.platform.PlatformPatchModel;
import com.github.hicolors.leisure.member.model.persistence.Platform;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * PlatformRest
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/28
 */
@RestController
public class PlatformRest implements PlatformApi {
    @Override
    public Platform create(@RequestBody PlatformModel model) {
        return null;
    }

    @Override
    public Platform modifyAll(@PathVariable("id") Long id, @RequestBody PlatformPatchModel model) {
        return null;
    }

    @Override
    public Platform modify(@PathVariable("id") Long id, @RequestBody PlatformPatchModel model) {
        return null;
    }
}
