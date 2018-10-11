package com.github.hicolors.leisure.auth.model.consts;

/**
 * EnumCompanyStatus
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/11
 */
public enum EnumCompanyStatus {

    /**
     * 状态[0:禁用;1:审核中;2:启用]
     */

    DISABLE(0, "禁用"),
    review(1, "审核中"),
    ENABLE(2, "启用"),
    ;

    private final int value;

    private final String desc;


    EnumCompanyStatus(int value, String desc) {
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
