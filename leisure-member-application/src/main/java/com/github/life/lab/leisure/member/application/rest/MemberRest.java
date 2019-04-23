package com.github.life.lab.leisure.member.application.rest;

import com.github.life.lab.leisure.member.application.service.MemberService;
import com.github.life.lab.leisure.member.authorization.token.impl.MemberAuthorization;
import com.github.life.lab.leisure.member.intf.MemberApi;
import com.github.life.lab.leisure.member.model.resource.member.*;
import com.github.life.lab.leisure.member.model.resource.platform.Platform;
import com.github.lifelab.leisure.common.model.expression.ColorsExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * MemberRest
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/28
 */
@RestController
public class MemberRest implements MemberApi {

    @Autowired
    private MemberService memberService;

    @Override
    public Member signUp(@RequestBody @Validated MemberSignUpModel model) {
        return memberService.signUp(model);
    }

    @Override
    public Member modifyUsername(@PathVariable("id") Long id, @RequestBody @Validated MemberUsernameModel model) {
        return memberService.modifyUsername(id, model);
    }

    @Override
    public Member modify(@PathVariable("id") Long id, @RequestBody @Validated MemberPatchModel model) {
        return memberService.modify(id, model);
    }

    @Override
    public Member modifyMobile(@PathVariable("id") Long id, @RequestBody @Validated MemberMobileModel model) {
        return memberService.modifyMobile(id, model);
    }

    @Override
    public Member modifyEmail(@PathVariable("id") Long id, @RequestBody @Validated MemberEmailModel model) {
        return memberService.modifyEmail(id, model);
    }

    @Override
    public Member queryOne(@PathVariable("key") String key, @RequestParam(value = "key-type", defaultValue = "id") String keyType) {
        return memberService.queryOne(key, keyType);
    }

    @Override
    public MemberAuthorization queryMemberAuthorization(@PathVariable("id") Long id) {
        return memberService.queryMemberAuthorization(id);
    }

    @Override
    public List<Platform> queryPlatformByMemberId(@PathVariable("id") Long id) {
        return memberService.queryPlatformByMemberId(id);
    }

    @GetMapping
    public Page<Member> paging(@PageableDefault Pageable pageable, List<ColorsExpression> filters) {
        return memberService.paging(pageable, filters);
    }
}