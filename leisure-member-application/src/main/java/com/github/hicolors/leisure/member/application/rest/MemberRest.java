package com.github.hicolors.leisure.member.application.rest;

import com.github.hicolors.leisure.common.model.expression.ColorsExpression;
import com.github.hicolors.leisure.member.api.MemberApi;
import com.github.hicolors.leisure.member.application.repository.MemberRepository;
import com.github.hicolors.leisure.member.model.model.member.*;
import com.github.hicolors.leisure.member.model.persistence.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Member signUp(@RequestBody MemberSignUpModel model) {
        return null;
    }

    @Override
    public Member modifyUsername(@PathVariable("id") Long id, @RequestBody MemberUsernameModel model) {
        return null;
    }

    @Override
    public Member modify(@PathVariable("id") Long id, @RequestBody MemberModel model) {
        return null;
    }

    @Override
    public Member modifyMobile(@PathVariable("id") Long id, @RequestBody MemberMobileModel model) {
        return null;
    }

    @Override
    public Member modifyEmail(@PathVariable("id") Long id, @RequestBody MemberEmailModel model) {
        return null;
    }

    @Override
    public Page<Member> query(@PageableDefault(page = 0) Pageable pageable, List<ColorsExpression> filters) {
        return null;
    }

    @Override
    public Member queryById(@PathVariable("id") Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    @Override
    public Member queryByMobile(@RequestParam("mobile") String mobile) {
        return null;
    }

    @Override
    public Member queryByEmail(@RequestParam("email") String email) {
        return null;
    }

    @Override
    public Member queryByUsernameAndPassword(@RequestParam("username") String username, @RequestParam("password") String password) {
        return null;
    }
}