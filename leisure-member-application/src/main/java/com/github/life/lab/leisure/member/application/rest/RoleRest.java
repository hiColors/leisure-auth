package com.github.life.lab.leisure.member.application.rest;

import com.github.life.lab.leisure.member.intf.RoleApi;
import com.github.life.lab.leisure.member.model.resource.role.Role;
import com.github.life.lab.leisure.member.model.resource.role.RoleModel;
import com.github.life.lab.leisure.member.model.resource.role.RolePatchModel;
import com.github.life.lab.leisure.member.model.resource.role.RolePermission;
import org.springframework.web.bind.annotation.RestController;

/**
 * RoleRest
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/22
 */
@RestController
public class RoleRest implements RoleApi {

    @Override
    public Role create(RoleModel model) {
        return null;
    }

    @Override
    public Role modify(Long id, RolePatchModel model) {
        return null;
    }

    @Override
    public Role query(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public RolePermission createRolePermission(Long roleId, Long permissionId) {
        return null;
    }

    @Override
    public void deleteRolePermission(Long roleId, Long permissionId) {

    }
}