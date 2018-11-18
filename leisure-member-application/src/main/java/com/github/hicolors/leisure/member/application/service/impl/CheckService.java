package com.github.hicolors.leisure.member.application.service.impl;

import com.github.hicolors.leisure.member.application.exception.EnumMemberServerCodeMessage;
import com.github.hicolors.leisure.member.application.exception.MemberServerException;
import com.github.hicolors.leisure.member.application.repository.MemberDetailRepository;
import com.github.hicolors.leisure.member.application.repository.MemberRepository;
import com.github.hicolors.leisure.member.model.persistence.Member;
import com.github.hicolors.leisure.member.model.persistence.MemberDetail;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * CheckService
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/11/3
 */
@Service
public class CheckService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberDetailRepository memberDetailRepository;


    public void checkUsername(String username, Long id) {
        Member member = memberRepository.findByUsername(username);
        if (Objects.nonNull(member)) {
            id = ObjectUtils.defaultIfNull(id, 0L);
            if (!id.equals(member.getId())) {
                throw new MemberServerException(EnumMemberServerCodeMessage.MEMBER_USERNAME_EXIST);
            }
        }
    }

    public void checkMobile(String mobile, Long id) {
        MemberDetail md = memberDetailRepository.findByMobile(mobile);
        if (Objects.nonNull(md)) {
            id = ObjectUtils.defaultIfNull(id, 0L);
            if (!id.equals(md.getId())) {
                throw new MemberServerException(EnumMemberServerCodeMessage.MEMBER_MOBILE_EXIST);
            }
        }
    }

    public void checkEmail(String email, Long id) {
        MemberDetail md = memberDetailRepository.findByEmail(email);
        if (Objects.nonNull(md)) {
            id = ObjectUtils.defaultIfNull(id, 0L);
            if (!id.equals(md.getId())) {
                throw new MemberServerException(EnumMemberServerCodeMessage.MEMBER_EMAIL_EXIST);
            }
        }
    }
}
