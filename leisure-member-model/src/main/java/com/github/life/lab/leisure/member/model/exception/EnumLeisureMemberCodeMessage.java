package com.github.life.lab.leisure.member.model.exception;

/**
 * EnumCodeMessage
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/22
 */
public enum EnumLeisureMemberCodeMessage {

    /**
     * member 服务全局错误异常码
     * <p>
     * 异常码示例：  100 000 001
     * <p>
     * <p>
     * 100 -> 前三位，代表服务（应用），不可更改。
     * <p>
     * 000 -> 中间三位，代表模块，公用，根据业务拆分模块。
     * <p>
     * 001 -> 后三位，代表具体异常码。
     */

    /********* 角色权限相关 *********/
    ROLE_NAME_EXIST(100001001L, "角色名称已存在"),
    ROLE_CODE_EXIST(100001002L, "角色唯一标识码已存在"),
    ROLE_NON_EXIST(100001003L, "角色不存在"),
    ROLE_QUERY_NON_SUPPORT(100001004L, "不支持的查询方式"),

    /********* 平台相关 *********/
    PLATFORM_NAME_EXIST(100002001L, "平台信息名称已存在"),
    PLATFORM_PARENT_ORGANIZATION_NON_EXIST(100002002L, "父级的平台组织架构信息不存在"),
    PLATFORM_ORGANIZATION_NAME_EXIST(100002003L, "该平台下已存在同名组织架构"),
    PLATFORM_ORGANIZATION_MISMATCHES(100002004L, "该平台和该组织架构信息不匹配"),
    PLATFORM_JOB_TITLE_EXIST(100002005L, "该平台下已存在该职称的岗位"),
    PLATFORM_JOB_MISMATCHES(100002006L, "该平台和该岗位信息不匹配"),
    PLATFORM_JOB_NON_EXIST(100002007L, "平台岗位信息不存在"),
    PLATFORM_MEMBER_MISMATCHES(100002008L, "该员工不属于该平台"),
    PLATFORM_ORGANIZATION_NON_EXIST(100002009L, "该组织机构不存在"),

    /********* 人员相关 *********/
    MEMBER_NON_EXIST(100003001L, "人员不存在"),
    MEMBER_MOBILE_EXIST(100003002L, "该手机号已存在"),
    MEMBER_EMAIL_EXIST(100003003L, "该邮箱已存在"),
    MEMBER_USERNAME_EXIST(100003004L, "该用户名已存在"),
    MEMBER_UNIQUE_KEY_NON_EXIST(100003005L, "该 [{0}] 对应的人员不存在"),

    MEMBER_USERNAME_PASSWORD_NON_EXIST(100003005L, "用户名密码不匹配"),


    /************* 100100xxx 认证模块占用请跳过此段异常码 *********/
    ;

    private final Long code;

    private final String message;

    EnumLeisureMemberCodeMessage(Long code, String message) {
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
