package com.github.life.lab.leisure.member.intf;

import com.github.life.lab.leisure.member.authorization.token.impl.MemberAuthorization;
import com.github.life.lab.leisure.member.model.resource.member.*;
import com.github.life.lab.leisure.member.model.resource.platform.Platform;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * MemberApi
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2018/11/3
 */
@Api(tags = "member", description = "对人员的相关操作")
@RequestMapping("/members")
public interface MemberApi {

    @ApiOperation("人员 - 注册")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Member signUp(@RequestBody @Validated MemberSignUpModel model);

    @ApiOperation("人员 - 修改用户名")
    @PatchMapping("/{id}/username")
    Member modifyUsername(@PathVariable("id") Long id, @RequestBody @Validated MemberUsernameModel model);

    @ApiOperation("人员 - 修改信息")
    @PatchMapping("/{id}")
    Member modify(@PathVariable("id") Long id, @RequestBody @Validated MemberPatchModel model);

    @ApiOperation("人员 - 修改绑定手机号信息")
    @PatchMapping("/{id}/mobile")
    Member modifyMobile(@PathVariable("id") Long id, @RequestBody @Validated MemberMobileModel model);

    @ApiOperation("人员 - 修改绑定邮箱信息")
    @PatchMapping("/{id}/email")
    Member modifyEmail(@PathVariable("id") Long id, @RequestBody @Validated MemberEmailModel model);

    @ApiOperation(value = "人员 - 获取人员信息",
            notes = "当前支持的 keyType : 【id - 主键，默认值】;【username - 用户名;【mobile - 手机号】;【email - 邮箱】】")
    @GetMapping("/{key}")
    Member queryOne(@PathVariable("key") String key, @RequestParam(value = "key-type", defaultValue = "id") String keyType);

    @ApiOperation("人员 - 获取人员所有的授权信息")
    @GetMapping("/{id}/authorization")
    MemberAuthorization queryMemberAuthorization(@PathVariable("id") Long id);

    @ApiOperation("人员 - 获取人员所属的平台信息")
    @GetMapping("/{id}/platform")
    List<Platform> queryPlatformByMemberId(@PathVariable("id") Long id);
}
