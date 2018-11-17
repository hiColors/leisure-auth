package com.github.hicolors.leisure.member.authorization.token.impl;

import com.github.hicolors.leisure.member.authorization.token.UserInfo;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * MemberAuthorization
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/11/13
 */
@Data
public class MemberAuthorization implements UserInfo {

    /**
     * 用户 id
     */
    private Long id;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 主平台 id
     */
    private Long platformId;

    /**
     * 主平台 名称
     */
    private String platformName;

    /**
     * 用户自身的权限
     */
    private List<String> memberRoles;

    /**
     * 用户在某平台下的权限
     */
    private Map<Long, List<String>> platformRoles;
}
