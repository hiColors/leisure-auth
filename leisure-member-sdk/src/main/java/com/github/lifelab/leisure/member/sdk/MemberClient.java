package com.github.lifelab.leisure.member.sdk;

import com.github.lifelab.leisure.member.intf.MemberApi;
import com.github.lifelab.leisure.member.sdk.config.LeisureMemberSdkConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * MemberClient
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/11/5
 */
@FeignClient(name = LeisureMemberSdkConfiguration.SERVER_NAME, path = LeisureMemberSdkConfiguration.CONTEXT_PATH)
public interface MemberClient extends MemberApi {
}