package com.github.hicolors.leisure.member.application.rest;

import com.github.hicolors.leisure.common.exception.ResourceNotFoundException;
import com.github.hicolors.leisure.member.api.PlatformApi;
import com.github.hicolors.leisure.member.application.service.PlatformService;
import com.github.hicolors.leisure.member.model.model.platform.PlatformModel;
import com.github.hicolors.leisure.member.model.model.platform.PlatformPatchModel;
import com.github.hicolors.leisure.member.model.persistence.Platform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.util.Objects;

/**
 * PlatformRest
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/28
 */
@RestController
public class PlatformRest implements PlatformApi {

    @Autowired
    private PlatformService service;

    @Override
    public Platform create(@RequestBody PlatformModel model) {
        return service.create(model);
    }

    @Override
    public Platform modifyAll(@PathVariable("id") Long id, @RequestBody PlatformPatchModel model) {
        return service.modifyAll(get(id),model);
    }

    @Override
    public Platform modify(@PathVariable("id") Long id, @RequestBody PlatformPatchModel model) {
        return service.modify(get(id),model);
    }

    private Platform get(Long id) {
        Platform role = service.queryOne(id);
        if (Objects.isNull(role)) {
            throw new ResourceNotFoundException(MessageFormat.format("该 id[{0}] 对应的平台信息不存在！", id));
        }
        return role;
    }
}
