package com.github.hicolors.leisure.member.authorization.token;

import java.util.List;
import java.util.Map;

/**
 * 用户信息接口
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/11/16
 */
public interface UserInfo {

    /**
     * 用户 id
     */
    Long getId();

    /**
     * 昵称
     */
    String getNickName();

    /**
     * 用户自身的权限
     */
    List<String> getMemberRoles();

    /**
     * 用户在某平台下的权限
     */
    Map<Long, List<String>> getPlatformRoles();
}
