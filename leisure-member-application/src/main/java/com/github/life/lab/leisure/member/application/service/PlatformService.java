package com.github.life.lab.leisure.member.application.service;

import com.github.life.lab.leisure.member.model.resource.platform.*;

/**
 * PlatformService
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2019-01-20
 */
public interface PlatformService {

    /**
     * @param model 对应模型
     * @return
     */
    Platform create(PlatformModel model);

    /**
     * @param id    平台 id
     * @param model 对应模型
     * @return 平台信息
     */
    Platform modify(Long id, PlatformPatchModel model);

    /**
     * @param id 平台 id
     * @return 平台信息
     */
    Platform query(Long id);

    /**
     * @param id    平台 id
     * @param model 对应模型
     * @return 平台组织架构信息
     */
    PlatformOrganization createOrganization(Long id, PlatformOrganizationModel model);

    /**
     * @param id    平台 id
     * @param oid   组织架构 id
     * @param model 对应模型
     * @return 平台组织架构信息
     */
    PlatformOrganization modifyOrganization(Long id, Long oid, PlatformOrganizationPatchModel model);

    /**
     * @param id  平台 id
     * @param oid 组织架构 id
     */
    void deleteOrganization(Long id, Long oid);

    /**
     * @param id 平台 id
     * @return 平台组织架构信息
     */
    PlatformOrganization queryBaseOrganization(Long id);

    /**
     * @param id  平台 id
     * @param oid 组织架构 id
     * @return 平台组织架构信息
     */
    PlatformOrganization queryOrganization(Long id, Long oid);

    /**
     * @param id    平台 id
     * @param model 对应模型
     * @return 组织岗位信息
     */
    PlatformJob createJob(Long id, PlatformJobModel model);

    /**
     * @param id  平台 id
     * @param jid 组织岗位信息 id
     */
    void deleteJob(Long id, Long jid);

    /**
     * @param id    平台 id
     * @param jid   组织岗位信息 id
     * @param model 对应模型
     * @return 组织岗位信息
     */
    PlatformJob modifyJob(Long id, Long jid, PlatformJobPatchModel model);

    /**
     * @param id  平台 id
     * @param jid 组织岗位信息id
     * @return 组织岗位信息
     */
    PlatformJob queryJob(Long id, Long jid);

    /**
     * @param id    平台 id
     * @param model 对应模型
     * @return 组织员工信息
     */
    PlatformMember createMember(Long id, PlatformMemberModel model);

    /**
     * @param id  平台 id
     * @param mid 用户 id
     */
    void deleteMember(Long id, Long mid);

    /**
     * @param id    平台 id
     * @param mid   用户 ID
     * @param model 对应模型
     * @return 组织员工信息
     */
    PlatformMember modifyMember(Long id, Long mid, PlatformMemberPatchModel model);

    /**
     * @param id  平台 id
     * @param mid 用户 id
     * @return 组织员工信息
     */
    PlatformMember queryMember(Long id, Long mid);
}
