package com.github.life.lab.leisure.member.application.rest;

import com.github.life.lab.leisure.member.intf.PlatformApi;
import com.github.life.lab.leisure.member.model.resource.platform.*;
import org.springframework.web.bind.annotation.RestController;

/**
 * PlatformRest
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/28
 */
//@RestController
public class PlatformRest implements PlatformApi {

    @Override
    public Platform create(PlatformModel model) {
        return null;
    }

    @Override
    public Platform query(Long id) {
        return null;
    }

    @Override
    public Platform modify(Long id, PlatformPatchModel model) {
        return null;
    }

    @Override
    public PlatformOrganization queryOrganization(Long id) {
        return null;
    }

    @Override
    public PlatformOrganization createOrganization(Long id, PlatformOrganizationModel model) {
        return null;
    }

    @Override
    public PlatformOrganization modifyOrganization(Long pid, Long oid, PlatformOrganizationPatchModel model) {
        return null;
    }

    @Override
    public PlatformJob createJob(Long id, PlatformJobModel model) {
        return null;
    }

    @Override
    public PlatformJob modifyJob(Long pid, Long jid, PlatformJobPatchModel model) {
        return null;
    }

    @Override
    public PlatformMember createMember(Long pid, Long oid, PlatformMemberModel model) {
        return null;
    }

    @Override
    public PlatformMember modifyMember(Long pid, Long oid, Long pmid, PlatformMemberPatchModel model) {
        return null;
    }
}
