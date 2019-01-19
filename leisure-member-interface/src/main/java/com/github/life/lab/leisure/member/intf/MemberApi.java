package com.github.life.lab.leisure.member.intf;

import com.github.life.lab.leisure.member.authorization.token.impl.MemberAuthorization;
import com.github.life.lab.leisure.member.model.resource.member.*;
import com.github.life.lab.leisure.member.model.resource.platform.Platform;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * MemberApi
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/11/3
 */
@Api(tags = "member", description = "对人员的相关操作")
@RequestMapping("member")
public interface MemberApi {

    @ApiOperation("人员 - 注册")
    @PostMapping
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

    @ApiOperation("人员 - 获取人员信息通过 id")
    @GetMapping("/{id}")
    Member queryOneById(@PathVariable("id") Long id);

    @ApiOperation("人员 - 获取人员信息通过 mobile")
    @GetMapping("/mobile")
    Member queryOneByMobile(@RequestParam("mobile") String mobile);

    @ApiOperation("人员 - 获取人员信息通过 email")
    @GetMapping("/email")
    Member queryOneByEmail(@RequestParam("email") String email);

    @ApiOperation("人员 - 获取人员信息通过 uniquekey（包含用户名，手机号，邮箱） 和 password")
    @GetMapping("/unique-key/password")
    Member queryOneByUniqueKeyAndPassword(@RequestParam("unique-key") String uniqueKey, @RequestParam("password") String password);

    @ApiOperation("人员 - 获取人员所有的授权信息")
    @GetMapping("/{id}/authorization")
    MemberAuthorization queryMemberAuthorization(@PathVariable("id") Long id);

    @ApiOperation("人员 - 获取人员所属的平台信息")
    @GetMapping("/{id}/platform")
    List<Platform> queryPlatformByMemberId(@PathVariable("id") Long id);
}
