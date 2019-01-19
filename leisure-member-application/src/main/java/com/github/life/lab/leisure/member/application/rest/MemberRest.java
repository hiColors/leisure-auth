package com.github.life.lab.leisure.member.application.rest;

import com.github.life.lab.leisure.member.authorization.token.impl.MemberAuthorization;
import com.github.life.lab.leisure.member.intf.MemberApi;
import com.github.life.lab.leisure.member.model.resource.member.*;
import com.github.life.lab.leisure.member.model.resource.platform.Platform;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * MemberRest
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/28
 */
@RestController
public class MemberRest implements MemberApi {

    @Override
    public Member signUp(@RequestBody @Validated MemberSignUpModel model) {
        return null;
    }

    @Override
    public Member modifyUsername(@PathVariable("id") Long id, @RequestBody @Validated MemberUsernameModel model) {
        return null;
    }

    @Override
    public Member modify(@PathVariable("id") Long id, @RequestBody @Validated MemberPatchModel model) {
        return null;
    }

    @Override
    public Member modifyMobile(@PathVariable("id") Long id, @RequestBody @Validated MemberMobileModel model) {
        return null;
    }

    @Override
    public Member modifyEmail(@PathVariable("id") Long id, @RequestBody @Validated MemberEmailModel model) {
        return null;
    }

    @Override
    public Member queryOneById(@PathVariable("id") Long id) {
        return null;
    }

    @Override
    public Member queryOneByMobile(@RequestParam("mobile") String mobile) {
        return null;
    }

    @Override
    public Member queryOneByEmail(@RequestParam("email") String email) {
        return null;
    }

    @Override
    public Member queryOneByUniqueKeyAndPassword(@RequestParam("unique-key") String uniqueKey, @RequestParam("password") String password) {
        return null;
    }

    @Override
    public MemberAuthorization queryMemberAuthorization(@PathVariable("id") Long id) {
        return null;
    }

    @Override
    public List<Platform> queryPlatformByMemberId(@PathVariable("id") Long id) {
        return null;
    }

}