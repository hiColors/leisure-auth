package com.github.life.lab.leisure.member.application.service.impl;

import com.github.life.lab.leisure.member.application.service.PlatformService;
import com.github.life.lab.leisure.member.model.resource.platform.*;
import org.springframework.stereotype.Service;

/**
 * PlatformServiceImpl
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2019-01-20
 */
@Service
public class PlatformServiceImpl implements PlatformService {

    @Override
    public Platform create(PlatformModel model) {
        return null;
    }

    @Override
    public Platform modify(Long id, PlatformPatchModel model) {
        return null;
    }

    @Override
    public Platform query(Long id) {
        return null;
    }

    @Override
    public PlatformOrganization createOrganization(Long id, PlatformOrganizationModel model) {
        return null;
    }

    @Override
    public PlatformOrganization modifyOrganization(Long id, Long oid, PlatformOrganizationPatchModel model) {
        return null;
    }

    @Override
    public void deleteOrganization(Long id, Long oid) {

    }

    @Override
    public PlatformOrganization queryBaseOrganization(Long id) {
        return null;
    }

    @Override
    public PlatformOrganization queryOrganization(Long id, Long oid) {
        return null;
    }

    @Override
    public PlatformJob createJob(Long id, PlatformJobModel model) {
        return null;
    }

    @Override
    public void deleteJob(Long id, Long jid) {

    }

    @Override
    public PlatformJob modifyJob(Long id, Long jid, PlatformJobPatchModel model) {
        return null;
    }

    @Override
    public PlatformJob queryJob(Long id, Long jid) {
        return null;
    }

    @Override
    public PlatformMember createMember(Long id, PlatformMemberModel model) {
        return null;
    }

    @Override
    public void deleteMember(Long id, Long mid) {

    }

    @Override
    public PlatformMember modifyMember(Long id, Long mid, PlatformMemberPatchModel model) {
        return null;
    }

    @Override
    public PlatformMember queryMember(Long id, Long mid) {
        return null;
    }
}
