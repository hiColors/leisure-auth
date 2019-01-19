package com.github.life.lab.leisure.member.application.entity.enums;

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

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
