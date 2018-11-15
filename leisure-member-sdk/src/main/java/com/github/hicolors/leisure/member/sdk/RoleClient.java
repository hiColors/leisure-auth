package com.github.hicolors.leisure.member.sdk;

import com.github.hicolors.leisure.member.intf.RoleApi;
import com.github.hicolors.leisure.member.sdk.config.LeisureMemberSdkConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * PermissionClient
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/11/5
 */
@FeignClient(name = LeisureMemberSdkConfiguration.SERVER_NAME, url = "${url.leisure-member}")
public interface RoleClient extends RoleApi {
}