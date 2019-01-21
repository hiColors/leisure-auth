package com.github.life.lab.leisure.member.sdk;

import com.github.life.lab.leisure.common.model.expression.ColorsExpression;
import com.github.life.lab.leisure.member.intf.RoleApi;
import com.github.life.lab.leisure.member.model.resource.role.Role;
import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
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

    @GetMapping("/roles")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Page<Role> paging(@QueryMap Map<String,?> maps);
}