package com.github.life.lab.leisure.member.application.rest;

import com.github.life.lab.leisure.common.exception.ResourceNotFoundException;
import com.github.life.lab.leisure.common.framework.springmvc.json.annotation.JsonBeanFilter;
import com.github.life.lab.leisure.common.framework.springmvc.json.annotation.JsonResultFilter;
import com.github.life.lab.leisure.common.model.expression.ColorsExpression;
import com.github.life.lab.leisure.member.application.service.MemberService;
import com.github.life.lab.leisure.member.application.service.PlatformService;
import com.github.life.lab.leisure.member.authorization.token.impl.MemberAuthorization;
import com.github.life.lab.leisure.member.intf.MemberApi;
import com.github.life.lab.leisure.member.model.model.member.*;
import com.github.life.lab.leisure.member.model.persistence.Member;
import com.github.life.lab.leisure.member.model.persistence.Platform;
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

    @Autowired
    private PlatformService platformService;

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
    public MemberAuthorization queryMemberAuthorization(@PathVariable("id") Long id) {
        return service.queryMemberAuthorization(get(id));
    }

    @Override
    @JsonResultFilter(values = {
            @JsonBeanFilter(clazz = Platform.class,excludes = {"organizations"})
    })
    public List<Platform> queryPlatformByMemberId(@PathVariable("id") Long id) {
        return platformService.findPlatformByMemberId(get(id));
    }

    private Member get(Long id) {
        Member member = service.queryOneById(id);
        if (Objects.isNull(member)) {
            throw new ResourceNotFoundException(MessageFormat.format("该 id[{0}] 对应的人员不存在！", id));
        }
        return member;
    }
}