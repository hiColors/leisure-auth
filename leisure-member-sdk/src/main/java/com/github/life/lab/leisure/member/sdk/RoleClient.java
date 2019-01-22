package com.github.life.lab.leisure.member.sdk;

import com.github.life.lab.leisure.common.model.BasePage;
import com.github.life.lab.leisure.member.intf.RoleApi;
import com.github.life.lab.leisure.member.model.resource.role.Role;
import feign.Headers;
import feign.QueryMap;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

import static com.github.life.lab.leisure.member.sdk.config.LeisureMemberSdkConfiguration.CONTEXT_PATH;
import static com.github.life.lab.leisure.member.sdk.config.LeisureMemberSdkConfiguration.SERVER_NAME;

/**
 * MemberClient
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/11/5
 */
@FeignClient(name = SERVER_NAME, path = CONTEXT_PATH)
public interface RoleClient extends RoleApi {

    @GetMapping
    @Headers("Content-Type: application/x-www-form-urlencoded")
    BasePage<Role> paging(@QueryMap Map<String, ?> maps);
}