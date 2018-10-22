package com.github.hicolors.leisure.member.application.exception;

import com.github.hicolors.leisure.common.exception.BusinessException;

/**
 * MemberServerException
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/22
 */
public class MemberServerException extends BusinessException {

    public MemberServerException(Long code, String message, Object data) {
        super(code, message, data);
    }

    public MemberServerException(EnumCodeMessage codeMessage) {
        super(codeMessage.getCode(), codeMessage.getMessage(), null);
    }
}
