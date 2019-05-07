package com.github.lifelab.leisure.member.authorization.validator.exception;

/**
 * EnumMemberAuthorizationCodeMessage
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/11/18
 */
public enum EnumMemberAuthorizationCodeMessage {

    /**
     * 不能登录的原因
     */

    MEMBER_DISABLED(100100001L, "您的账户被停用了，有疑问请联系客服！"),
    MEMBER_LOCKED(100100002L, "您的账户被锁定了，有疑问请联系客服！"),
    MEMBER_EXPIRED(100100003L, "您的账户已过期，有疑问请联系客服！"),
    MEMBER_CREDENTIALS_EXPIRED(100100004L, "您的账户凭证已过期，有疑问请联系客服！"),
    ;

    private final Long code;

    private final String message;

    EnumMemberAuthorizationCodeMessage(Long code, String message) {
        this.code = code;
        this.message = message;
    }

    public Long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}