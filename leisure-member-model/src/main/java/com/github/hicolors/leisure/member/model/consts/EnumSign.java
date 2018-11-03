package com.github.hicolors.leisure.member.model.consts;

/**
 * EnumSign
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/11/3
 */
public enum EnumSign {

    /**
     * 用户行为
     */

    SIGN_IN(0, "登录"),
    SIGN_UP(1, "注册"),
    SIGN_OUT(2, "登出"),
    ;

    private final int value;

    private final String desc;


    EnumSign(int value, String desc) {
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
