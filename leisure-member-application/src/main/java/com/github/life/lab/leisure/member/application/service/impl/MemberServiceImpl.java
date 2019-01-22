package com.github.life.lab.leisure.member.application.service.impl;

import com.github.life.lab.leisure.member.application.service.MemberService;
import com.github.life.lab.leisure.member.authorization.token.impl.MemberAuthorization;
import com.github.life.lab.leisure.member.model.resource.member.*;
import com.github.life.lab.leisure.member.model.resource.platform.Platform;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * MemberServiceImpl
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2019-01-20
 */
@Service
public class MemberServiceImpl implements MemberService {
    @Override
    public Member signUp(MemberSignUpModel model) {
        return null;
    }

    @Override
    public Member modifyUsername(Long id, MemberUsernameModel model) {
        return null;
    }

    @Override
    public Member modify(Long id, MemberPatchModel model) {
        return null;
    }

    @Override
    public Member modifyMobile(Long id, MemberMobileModel model) {
        return null;
    }

    @Override
    public Member modifyEmail(Long id, MemberEmailModel model) {
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
    public Member queryOneByUniqueKeyAndPassword(String uniqueKey, String password) {
        return null;
    }

    @Override
    public MemberAuthorization queryMemberAuthorization(Long id) {
        return null;
    }

    @Override
    public List<Platform> queryPlatformByMemberId(Long id) {
        return null;
    }

    @Override
    public Member queryOne(String key, String keyType) {
        return null;
    }
}