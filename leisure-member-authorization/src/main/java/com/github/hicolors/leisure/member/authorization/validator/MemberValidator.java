package com.github.hicolors.leisure.member.authorization.validator;

import com.github.hicolors.leisure.member.authorization.validator.exception.EnumMemberAuthorizationCodeMessage;
import com.github.hicolors.leisure.member.authorization.validator.exception.MemberAuthorizationException;
import com.github.hicolors.leisure.member.model.persistence.Member;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * MemberValidator
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/11/18
 */
@Validated
public class MemberValidator {

    public void validator(@NotNull Member member) {
        if (!member.getEnabled()) {
            throw new MemberAuthorizationException(EnumMemberAuthorizationCodeMessage.MEMBER_DISABLED, member);
        }
        if (member.getLockStatus()) {
            throw new MemberAuthorizationException(EnumMemberAuthorizationCodeMessage.MEMBER_LOCKED, member);
        }
        if (System.currentTimeMillis() > member.getExpiredDate().getTime()) {
            throw new MemberAuthorizationException(EnumMemberAuthorizationCodeMessage.MEMBER_EXPIRED, member);
        }
        if (System.currentTimeMillis() > member.getCredentialsExpiredDate().getTime()) {
            throw new MemberAuthorizationException(EnumMemberAuthorizationCodeMessage.MEMBER_CREDENTIALS_EXPIRED, member);
        }
    }
}
