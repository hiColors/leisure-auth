package com.github.lifelab.leisure.member.sdk.config;

import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * LeisureMemberSdkConfiguration
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/11/5
 */
@EnableFeignClients("com.github.lifelab.leisure.member.sdk")
public class LeisureMemberSdkConfiguration {

    public static final String SERVER_NAME = "leisure-member";

    public static final String CONTEXT_PATH = "/leisure-member";
}