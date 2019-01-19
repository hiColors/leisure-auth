package com.github.life.lab.leisure.member.authorization.token;

import java.util.List;
import java.util.Map;

/**
 * 用户信息接口
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2018/11/16
 */
public interface UserInfo {

    /**
     * 获取用户 id
     *
     * @return 用户 id
     */
    Long getId();

    /**
     * 获取昵称
     *
     * @return 昵称
     */
    String getNickName();

    /**
     * 获取主平台 id
     *
     * @return 主平台 id
     */
    Long getPlatformId();

    /**
     * 获取主平台 名称
     *
     * @return 主平台 名称
     */
    String getPlatformName();

    /**
     * 获取用户自身的权限
     *
     * @return 用户自身的权限
     */
    List<String> getMemberRoles();

    /**
     * 获取用户在某平台下的权限
     *
     * @return 用户在某平台下的权限
     */
    Map<Long, List<String>> getPlatformRoles();
}
