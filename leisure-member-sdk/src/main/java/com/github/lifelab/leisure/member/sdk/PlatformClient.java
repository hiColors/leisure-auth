package com.github.lifelab.leisure.member.sdk;

import com.github.lifelab.leisure.member.intf.PlatformApi;
import org.springframework.cloud.openfeign.FeignClient;

import static com.github.lifelab.leisure.member.sdk.config.LeisureMemberSdkConfiguration.CONTEXT_PATH;
import static com.github.lifelab.leisure.member.sdk.config.LeisureMemberSdkConfiguration.SERVER_NAME;

/**
 * PlatformClient
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/11/5
 */
@FeignClient(name = SERVER_NAME, path = CONTEXT_PATH)
public interface PlatformClient extends PlatformApi {
}