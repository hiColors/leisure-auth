package com.github.life.lab.leisure.member.authorization.validator.exception;


import com.github.life.lab.leisure.common.exception.BusinessException;

/**
 * exception
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/11/18
 */
public class MemberAuthorizationException extends BusinessException {


    public MemberAuthorizationException(EnumMemberAuthorizationCodeMessage codeMessage, Object data) {
        super(codeMessage.getCode(), codeMessage.getMessage(), data);
    }

    public MemberAuthorizationException(Long code, String message, Object data) {
        super(code, message, data);
    }
}