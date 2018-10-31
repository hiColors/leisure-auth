package com.github.hicolors.leisure.member.application.exception;

/**
 * EnumCodeMessage
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/22
 */
public enum EnumCodeMessage {

    /**
     * member 服务全局错误异常码
     *
     * 异常码示例：  100 000 001
     *
     *
     * 100 -> 前三位，代表服务（应用），不可更改。
     *
     * 000 -> 中间三位，代表模块，公用，根据业务拆分模块。
     *
     * 001 -> 后三位，代表具体异常码。
     *
     */

    ROLE_NAME_EXIST(100001001L, "角色名称已存在"),

    PERMISSION_NAME_EXIST(100001002L, "权限名称已存在"),
    PERMISSION_STRATEGY_EXIST(100001003L, "权限策略已存在"),
    PERMISSION_STRATEGY_NON_EXIST(100001003L, "权限不存在"),

    PLATFORM_NAME_EXIST(100002001L,"平台信息名称已存在"),

    ;

    private final Long code;

    private final String message;

    EnumCodeMessage(Long code, String message) {
        this.code = code;
        this.message = message;
    }

    public Long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
