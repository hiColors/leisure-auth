package com.github.hicolors.leisure.member.application.rest;

import com.github.hicolors.leisure.common.exception.ResourceNotFoundException;
import com.github.hicolors.leisure.member.api.PlatformApi;
import com.github.hicolors.leisure.member.application.service.PlatformService;
import com.github.hicolors.leisure.member.model.model.platform.*;
import com.github.hicolors.leisure.member.model.persistence.Platform;
import com.github.hicolors.leisure.member.model.persistence.PlatformJob;
import com.github.hicolors.leisure.member.model.persistence.PlatformMember;
import com.github.hicolors.leisure.member.model.persistence.PlatformOrganization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
    public Platform create(@Validated @RequestBody PlatformModel model) {
        return service.create(model);
    }

    @Override
    public Platform query(@PathVariable("id") Long id) {
        return get(id);
    }

    @Override
    public Platform modifyAll(@PathVariable("id") Long id, @Validated @RequestBody PlatformPatchModel model) {
        return service.modifyAll(get(id), model);
    }

    @Override
    public Platform modify(@PathVariable("id") Long id, @Validated @RequestBody PlatformPatchModel model) {
        return service.modify(get(id), model);
    }

    @Override
    public PlatformOrganization queryOrganization(@PathVariable("id") Long id) {
        return service.queryOnePlatformOrganizationByPlatform(get(id));
    }

    @Override
    public PlatformOrganization createOrganization(@PathVariable("id") Long id, @Validated @RequestBody PlatformOrganizationModel model) {
        return service.createOrganization(get(id), model);
    }

    @Override
    public PlatformOrganization modifyOrganization(@PathVariable("id") Long id, @Validated @RequestBody PlatformOrganizationPatchModel model) {
        return service.modifyOrganization(get(id), model);
    }

    @Override
    public PlatformJob createJob(@PathVariable("id") Long id, @Validated @RequestBody PlatformJobModel model) {
        return service.createJob(get(id), model);
    }

    @Override
    public PlatformJob modifyJob(@PathVariable("id") Long id, @Validated @RequestBody PlatformJobPatchModel model) {
        return service.modifyJob(get(id), model);
    }

    @Override
    public PlatformMember createMember(@PathVariable("pid") Long pid, @PathVariable("oid") Long oid, @Validated @RequestBody PlatformMemberModel model) {
        return service.createMember(get(pid), getOrganization(oid), model);
    }

    private Platform get(Long id) {
        Platform platform = service.queryOneById(id);
        if (Objects.isNull(platform)) {
            throw new ResourceNotFoundException(MessageFormat.format("该 id[{0}] 对应的平台信息不存在！", id));
        }
        return platform;
    }

    private PlatformOrganization getOrganization(Long id) {
        PlatformOrganization organization = service.queryOnePlatformOrganizationById(id);
        if (Objects.isNull(organization)) {
            throw new ResourceNotFoundException(MessageFormat.format("该 id[{0}] 对应的平台组织架构信息不存在！", id));
        }
        return organization;
    }
}
