package com.github.lifelab.leisure.member.model.exception;


import com.github.lifelab.leisure.common.exception.BusinessException;

/**
 * MemberServerException
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/22
 */
public class LeisureMemberException extends BusinessException {

    public LeisureMemberException(EnumExceptionMessageLeisureMember codeMessage) {
        super(codeMessage.getCode(), codeMessage.getMessage(), null);
    }

    public LeisureMemberException(EnumExceptionMessageLeisureMember codeMessage, Object data) {
        super(codeMessage.getCode(), codeMessage.getMessage(), data);
    }

    public LeisureMemberException(EnumExceptionMessageLeisureMember codeMessage, String msg) {
        super(codeMessage.getCode(), msg, null);
    }
}