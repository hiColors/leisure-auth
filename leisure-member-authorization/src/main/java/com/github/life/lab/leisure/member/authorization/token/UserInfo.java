package com.github.life.lab.leisure.member.authorization.token;

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




}