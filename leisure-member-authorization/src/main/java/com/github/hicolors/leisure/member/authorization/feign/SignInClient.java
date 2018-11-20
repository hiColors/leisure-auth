package com.github.hicolors.leisure.member.authorization.feign;

import com.github.hicolors.leisure.member.authorization.token.impl.MemberAuthorization;
import com.github.hicolors.leisure.member.model.persistence.Member;
import com.github.hicolors.leisure.member.model.persistence.Platform;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * MemberClient
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/11/16
 */
@Api(tags = "BackendGatewaySignIn", description = "后台网关登录的相关操作")
@FeignClient(name = "leisure-member", path = "/leisure-member")
public interface SignInClient {


    @ApiOperation("人员 - 获取人员信息通过 id")
    @GetMapping("/member/{id}")
    Member queryOneById(@PathVariable("id") Long id);

    @ApiOperation("人员 - 获取人员信息通过 mobile")
    @GetMapping("/member/mobile")
    Member queryOneByMobile(@RequestParam("mobile") String mobile);

    @ApiOperation("人员 - 获取人员信息通过 email")
    @GetMapping("/member/email")
    Member queryOneByEmail(@RequestParam("email") String email);

    @ApiOperation("人员 - 获取人员信息通过 uniquekey（包含用户名，手机号，邮箱） 和 password")
    @GetMapping("/member/unique-key/password")
    Member queryOneByUniqueKeyAndPassword(@RequestParam("uniquekey") String uniquekey,
                                          @RequestParam("password") String password);

    @ApiOperation("人员 - 获取人员所有的授权信息")
    @GetMapping("/member/{id}/authorization")
    MemberAuthorization queryMemberAuthorization(@PathVariable("id") Long id);

    @ApiOperation("平台 - 查询")
    @GetMapping("/platform/{id}")
    Platform queryPlatform(@PathVariable("id") Long id);
}
