package com.github.lifelab.leisure.member.application.entity.enums;

import com.github.lifelab.leisure.member.model.exception.EnumExceptionMessageLeisureMember;
import com.github.lifelab.leisure.member.model.exception.LeisureMemberException;

/**
 * EnumCompanyStatus
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2018/10/11
 */
public enum EnumPlatformStatus {

    /**
     * 状态[0:禁用;1:审核中;2:启用]
     */

    DISABLE(0, "禁用"),
    REVIEW(1, "审核中"),
    ENABLE(2, "启用"),
    ;

    private final int value;

    private final String desc;


    EnumPlatformStatus(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static EnumPlatformStatus valueOfValue(Integer value) {
        for (EnumPlatformStatus e : values()) {
            if (value.equals(e.getValue())) {
                return e;
            }
        }
        throw new LeisureMemberException(EnumExceptionMessageLeisureMember.ENUM_NOT_SUPPORT_VALUEOF);
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
