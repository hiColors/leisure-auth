package com.github.life.lab.leisure.member.application.rest;

import com.github.life.lab.leisure.member.intf.PlatformApi;
import com.github.life.lab.leisure.member.model.resource.platform.*;
import org.springframework.validation.annotation.Validated;
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
    public Platform create(@RequestBody @Validated PlatformModel model) {
        return null;
    }

    @Override
    public Platform modify(@PathVariable("id") Long id, @RequestBody @Validated PlatformPatchModel model) {
        return null;
    }

    @Override
    public Platform query(@PathVariable("id") Long id) {
        return null;
    }

    @Override
    public PlatformOrganization createOrganization(@PathVariable("id") Long id, @RequestBody @Validated PlatformOrganizationModel model) {
        return null;
    }

    @Override
    public PlatformOrganization modifyOrganization(@PathVariable("id") Long id, @PathVariable("oid") Long oid, @RequestBody @Validated PlatformOrganizationPatchModel model) {
        return null;
    }

    @Override
    public void deleteOrganization(@PathVariable("id") Long id, @PathVariable("oid") Long oid) {

    }

    @Override
    public PlatformOrganization queryBaseOrganization(@PathVariable("id") Long id) {
        return null;
    }

    @Override
    public PlatformOrganization queryOrganization(@PathVariable("id") Long id, @PathVariable("oid") Long oid) {
        return null;
    }

    @Override
    public PlatformJob createJob(@PathVariable("id") Long id, @RequestBody @Validated PlatformJobModel model) {
        return null;
    }

    @Override
    public void deleteJob(@PathVariable("id") Long id, @PathVariable("jid") Long jid) {

    }

    @Override
    public PlatformJob modifyJob(@PathVariable("id") Long id, @PathVariable("jid") Long jid, @RequestBody @Validated PlatformJobPatchModel model) {
        return null;
    }

    @Override
    public PlatformJob queryJob(@PathVariable("id") Long id, @PathVariable("jid") Long jid) {
        return null;
    }

    @Override
    public PlatformMember createMember(@PathVariable("id") Long id, @PathVariable("oid") Long oid, @RequestBody @Validated PlatformMemberModel model) {
        return null;
    }

    @Override
    public void deleteMember(@PathVariable("id") Long id, @PathVariable("mid") Long mid) {

    }

    @Override
    public PlatformMember modifyMember(@PathVariable("id") Long id, @PathVariable("mid") Long mid, @RequestBody @Validated PlatformMemberPatchModel model) {
        return null;
    }

    @Override
    public PlatformMember queryMember(@PathVariable("id") Long id, @PathVariable("mid") Long mid) {
        return null;
    }
}
