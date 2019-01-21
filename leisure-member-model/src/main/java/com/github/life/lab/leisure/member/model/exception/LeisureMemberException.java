package com.github.life.lab.leisure.member.model.exception;


import com.github.life.lab.leisure.common.exception.BusinessException;

/**
 * MemberServerException
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/22
 */
public class LeisureMemberException extends BusinessException {

    public LeisureMemberException(EnumLeisureMemberCodeMessage codeMessage) {
        super(codeMessage.getCode(), codeMessage.getMessage(), null);
    }

    public LeisureMemberException(EnumLeisureMemberCodeMessage codeMessage, Object data) {
        super(codeMessage.getCode(), codeMessage.getMessage(), data);
    }

    public LeisureMemberException(EnumLeisureMemberCodeMessage codeMessage, String msg) {
        super(codeMessage.getCode(), msg, null);
    }
}