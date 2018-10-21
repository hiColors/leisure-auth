package com.github.hicolors.leisure.member.application.exception;

import com.github.hicolors.leisure.common.exception.BusinessException;

public class MemberServerException extends BusinessException {

    public MemberServerException(Long code, String message, Object data) {
        super(code, message, data);
    }

    public MemberServerException(EnumCodeMessage codeMessage) {
        super(codeMessage.getCode(), codeMessage.getMessage(), null);
    }
}
