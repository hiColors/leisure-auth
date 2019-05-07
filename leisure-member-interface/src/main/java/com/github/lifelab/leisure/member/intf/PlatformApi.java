package com.github.lifelab.leisure.member.intf;

import com.github.lifelab.leisure.member.model.resource.platform.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * PlatformApi
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2018/10/28
 */

@Api(tags = "platform", description = "对平台的相关操作")
@RequestMapping("/platforms")
public interface PlatformApi {

    @ApiOperation("平台 - 创建")
    @PostMapping
    Platform create(@RequestBody PlatformModel model);

    @ApiOperation("平台 - 部分修改")
    @PatchMapping("/{id}")
    Platform modify(@PathVariable("id") Long id, @RequestBody PlatformPatchModel model);

    @ApiOperation("平台 - 查询")
    @GetMapping("/{id}")
    Platform query(@PathVariable("id") Long id);

    @ApiOperation("平台 - 创建组织架构")
    @PostMapping("/{id}/organizations")
    PlatformOrganization createOrganization(@PathVariable("id") Long id, @RequestBody PlatformOrganizationModel model);

    @ApiOperation("平台 - 修改组织架构信息")
    @PatchMapping("/{id}/organizations/{oid}")
    PlatformOrganization modifyOrganization(@PathVariable("id") Long id, @PathVariable("oid") Long oid, @RequestBody PlatformOrganizationPatchModel model);

    @ApiOperation("平台 - 删除组织架构信息")
    @DeleteMapping("/{id}/organizations/{oid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteOrganization(@PathVariable("id") Long id, @PathVariable("oid") Long oid);

    @ApiOperation("平台 - 查询顶级组织架构")
    @GetMapping("/{id}/organizations")
    PlatformOrganization queryBaseOrganization(@PathVariable("id") Long id);

    @ApiOperation("平台 - 查询具体组织架构")
    @GetMapping("/{id}/organizations/{oid}")
    PlatformOrganization queryOrganization(@PathVariable("id") Long id, @PathVariable("oid") Long oid);

    @ApiOperation("平台 - 创建岗位")
    @PostMapping("/{id}/jobs")
    PlatformJob createJob(@PathVariable("id") Long id, @RequestBody PlatformJobModel model);

    @ApiOperation("平台 - 删除岗位信息")
    @DeleteMapping("/{id}/jobs/{jid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteJob(@PathVariable("id") Long id, @PathVariable("jid") Long jid);

    @ApiOperation("平台 - 修改岗位信息")
    @PatchMapping("/{id}/jobs/{jid}")
    PlatformJob modifyJob(@PathVariable("id") Long id, @PathVariable("jid") Long jid, @RequestBody PlatformJobPatchModel model);

    @ApiOperation("平台 - 查询岗位")
    @GetMapping("/{id}/jobs/{jid}")
    PlatformJob queryJob(@PathVariable("id") Long id, @PathVariable("jid") Long jid);

    @ApiOperation("平台 - 创建员工")
    @PostMapping("/{id}/members")
    PlatformMember createMember(@PathVariable("id") Long id, @RequestBody PlatformMemberModel model);

    @ApiOperation("平台 - 删除员工")
    @DeleteMapping("/{id}/members/{pmid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteMember(@PathVariable("id") Long id, @PathVariable("pmid") Long pmid);

    @ApiOperation("平台 - 修改员工信息")
    @PatchMapping("/{id}/members/{pmid}")
    PlatformMember modifyMember(@PathVariable("id") Long id, @PathVariable("pmid") Long pmid, @RequestBody PlatformMemberPatchModel model);

    @ApiOperation("平台 - 查询员工信息")
    @GetMapping("/{id}/members/{pmid}")
    PlatformMember queryMember(@PathVariable("id") Long id, @PathVariable("pmid") Long pmid);

}