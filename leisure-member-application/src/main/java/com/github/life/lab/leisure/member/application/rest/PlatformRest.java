package com.github.life.lab.leisure.member.application.rest;

import com.github.life.lab.leisure.member.application.service.PlatformService;
import com.github.life.lab.leisure.member.intf.PlatformApi;
import com.github.life.lab.leisure.member.model.resource.platform.*;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private PlatformService platformService;

    @Override
    public Platform create(@RequestBody @Validated PlatformModel model) {
        return platformService.create(model);
    }

    @Override
    public Platform modify(@PathVariable("id") Long id, @RequestBody @Validated PlatformPatchModel model) {
        return platformService.modify(id, model);
    }

    @Override
    public Platform query(@PathVariable("id") Long id) {
        return platformService.query(id);
    }

    @Override
    public PlatformOrganization createOrganization(@PathVariable("id") Long id, @RequestBody @Validated PlatformOrganizationModel model) {
        return platformService.createOrganization(id, model);
    }

    @Override
    public PlatformOrganization modifyOrganization(@PathVariable("id") Long id, @PathVariable("oid") Long oid, @RequestBody @Validated PlatformOrganizationPatchModel model) {
        return platformService.modifyOrganization(id, oid, model);
    }

    @Override
    public void deleteOrganization(@PathVariable("id") Long id, @PathVariable("oid") Long oid) {
        platformService.deleteOrganization(id, oid);
    }

    @Override
    public PlatformOrganization queryBaseOrganization(@PathVariable("id") Long id) {
        return platformService.queryBaseOrganization(id);
    }

    @Override
    public PlatformOrganization queryOrganization(@PathVariable("id") Long id, @PathVariable("oid") Long oid) {
        return platformService.queryOrganization(id, oid);
    }

    @Override
    public PlatformJob createJob(@PathVariable("id") Long id, @RequestBody @Validated PlatformJobModel model) {
        return platformService.createJob(id, model);
    }

    @Override
    public void deleteJob(@PathVariable("id") Long id, @PathVariable("jid") Long jid) {
        platformService.deleteJob(id, jid);
    }

    @Override
    public PlatformJob modifyJob(@PathVariable("id") Long id, @PathVariable("jid") Long jid, @RequestBody @Validated PlatformJobPatchModel model) {
        return platformService.modifyJob(id, jid, model);
    }

    @Override
    public PlatformJob queryJob(@PathVariable("id") Long id, @PathVariable("jid") Long jid) {
        return platformService.queryJob(id, jid);
    }

    @Override
    public PlatformMember createMember(@PathVariable("id") Long id, @RequestBody @Validated PlatformMemberModel model) {
        return platformService.createMember(id, model);
    }

    @Override
    public void deleteMember(@PathVariable("id") Long id, @PathVariable("pmid") Long pmid) {
        platformService.deleteMember(id, pmid);
    }

    @Override
    public PlatformMember modifyMember(@PathVariable("id") Long id, @PathVariable("pmid") Long pmid, @RequestBody @Validated PlatformMemberPatchModel model) {
        return platformService.modifyMember(id, pmid, model);
    }

    @Override
    public PlatformMember queryMember(@PathVariable("id") Long id, @PathVariable("pmid") Long pmid) {
        return platformService.queryMember(id, pmid);
    }
}
