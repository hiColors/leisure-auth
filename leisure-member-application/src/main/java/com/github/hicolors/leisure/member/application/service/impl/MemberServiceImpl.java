package com.github.hicolors.leisure.member.application.service.impl;

import com.github.hicolors.leisure.common.model.expression.ColorsExpression;
import com.github.hicolors.leisure.member.application.repository.MemberDetailRepository;
import com.github.hicolors.leisure.member.application.repository.MemberRepository;
import com.github.hicolors.leisure.member.application.service.MemberService;
import com.github.hicolors.leisure.member.model.model.member.*;
import com.github.hicolors.leisure.member.model.persistence.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * MemberServiceImpl
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/11/3
 */

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberDetailRepository memberDetailRepository;

    @Override
    public Member signUp(MemberSignUpModel model) {
        return null;
    }

    @Override
    public Member modifyUsername(Member member, MemberUsernameModel model) {
        return null;
    }

    @Override
    public Member modify(Member member, MemberPatchModel model) {
        return null;
    }

    @Override
    public Member modifyMobile(Member member, MemberMobileModel model) {
        return null;
    }

    @Override
    public Member modifyEmail(Member member, MemberEmailModel model) {
        return null;
    }

    @Override
    public Page<Member> query(Pageable pageable, List<ColorsExpression> filters) {
        return null;
    }

    @Override
    public Member queryOneById(Long id) {
        return null;
    }

    @Override
    public Member queryOneByMobile(String mobile) {
        return null;
    }

    @Override
    public Member queryOneByEmail(String email) {
        return null;
    }

    @Override
    public Member queryOneByUniqueKeyAndPassword(String username, String password) {
        return null;
    }
}
