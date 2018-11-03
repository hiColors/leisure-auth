package com.github.hicolors.leisure.member.application.exception;

import com.github.hicolors.leisure.common.exception.BusinessException;

/**
 * MemberServerException
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/22
 */
public class MemberServerException extends BusinessException {

    public MemberServerException(EnumCodeMessage codeMessage) {
        super(codeMessage.getCode(), codeMessage.getMessage(), null);
    }

    public MemberServerException(EnumCodeMessage codeMessage, Object data) {
        super(codeMessage.getCode(), codeMessage.getMessage(), data);
    }

    public MemberServerException(EnumCodeMessage codeMessage, String msg) {
        super(codeMessage.getCode(), msg, null);
    }
}