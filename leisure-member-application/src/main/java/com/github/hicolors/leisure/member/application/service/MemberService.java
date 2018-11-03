package com.github.hicolors.leisure.member.application.service;

import com.github.hicolors.leisure.common.model.expression.ColorsExpression;
import com.github.hicolors.leisure.member.model.model.member.*;
import com.github.hicolors.leisure.member.model.persistence.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * MemberService
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/11/3
 */
public interface MemberService {

    Member signUp(MemberSignUpModel model);

    Member modifyUsername(Member member, MemberUsernameModel model);

    Member modify(Member member, MemberPatchModel model);

    Member modifyMobile(Member member, MemberMobileModel model);

    Member modifyEmail(Member member, MemberEmailModel model);

    Page<Member> query(Pageable pageable, List<ColorsExpression> filters);

    Member queryOneById(Long id);

    Member queryOneByMobile(String mobile);

    Member queryOneByEmail(String email);

    Member queryOneByUniqueKeyAndPassword(String username, String password);

}