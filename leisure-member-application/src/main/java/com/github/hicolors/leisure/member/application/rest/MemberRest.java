package com.github.hicolors.leisure.member.application.rest;

import com.github.hicolors.leisure.common.exception.ResourceNotFoundException;
import com.github.hicolors.leisure.common.model.expression.ColorsExpression;
import com.github.hicolors.leisure.member.intf.MemberApi;
import com.github.hicolors.leisure.member.application.service.MemberService;
import com.github.hicolors.leisure.member.model.authorization.MemberAuthorization;
import com.github.hicolors.leisure.member.model.model.member.*;
import com.github.hicolors.leisure.member.model.persistence.Member;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;

/**
 * MemberRest
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/28
 */
@RestController
public class MemberRest implements MemberApi {

    @Autowired
    private MemberService service;

    @Override
    public Member signUp(@Validated @RequestBody MemberSignUpModel model) {
        return service.signUp(model);
    }

    @Override
    public Member modifyUsername(@PathVariable("id") Long id, @Validated @RequestBody MemberUsernameModel model) {
        return service.modifyUsername(get(id), model);
    }

    @Override
    public Member modify(@PathVariable("id") Long id, @Validated @RequestBody MemberPatchModel model) {
        return service.modify(get(id), model);
    }

    @Override
    public Member modifyMobile(@PathVariable("id") Long id, @Validated @RequestBody MemberMobileModel model) {
        return service.modifyMobile(get(id), model);
    }

    @Override
    public Member modifyEmail(@PathVariable("id") Long id, @Validated @RequestBody MemberEmailModel model) {
        return service.modifyEmail(get(id), model);
    }

    @ApiOperation("[Pageable + ColorsExpression]")
    @GetMapping
    public Page<Member> query(@PageableDefault Pageable pageable, List<ColorsExpression> filters) {
        return service.query(pageable, filters);
    }

    @Override
    public Member queryOneById(@PathVariable("id") Long id) {
        return get(id);
    }

    @Override
    public Member queryOneByMobile(@RequestParam("mobile") String mobile) {
        return service.queryOneByMobile(mobile);
    }

    @Override
    public Member queryOneByEmail(@RequestParam("email") String email) {
        return service.queryOneByEmail(email);
    }

    @Override
    public Member queryOneByUniqueKeyAndPassword(@RequestParam("uniquekey") String uniquekey, @RequestParam("password") String password) {
        return service.queryOneByUniqueKeyAndPassword(uniquekey, password);
    }

    @Override
    public MemberAuthorization queryMemberAuthorization(Long id) {
        return service.queryMemberAuthorization(get(id));
    }

    private Member get(Long id) {
        Member member = service.queryOneById(id);
        if (Objects.isNull(member)) {
            throw new ResourceNotFoundException(MessageFormat.format("该 id[{0}] 对应的人员不存在！", id));
        }
        return member;
    }
}