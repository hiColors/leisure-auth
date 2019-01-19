package com.github.life.lab.leisure.member.application.rest;

import com.github.life.lab.leisure.member.intf.PermissionApi;
import com.github.life.lab.leisure.member.model.resource.role.Permission;
import com.github.life.lab.leisure.member.model.resource.role.PermissionModel;
import org.springframework.web.bind.annotation.RestController;

;

/**
 * PermissionRest
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/22
 */
@RestController
public class PermissionRest implements PermissionApi {

    @Override
    public Permission create(PermissionModel model) {
        return null;
    }

    @Override
    public Permission modify(Long id, PermissionModel model) {
        return null;
    }

    @Override
    public Permission query(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}