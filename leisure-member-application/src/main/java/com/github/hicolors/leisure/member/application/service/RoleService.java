package com.github.hicolors.leisure.member.application.service;

import com.github.hicolors.leisure.common.model.expression.ColorsExpression;
import com.github.hicolors.leisure.member.model.model.role.RoleModel;
import com.github.hicolors.leisure.member.model.model.role.RolePatchModel;
import com.github.hicolors.leisure.member.model.persistence.Role;
import com.github.hicolors.leisure.member.model.persistence.RolePermission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * RoleService
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/22
 */
public interface RoleService {

    Role create(RoleModel model);

    Role modify(Role role, RolePatchModel model);

    Role modifyAll(Role role, RolePatchModel model);

    Role queryOne(Long id);

    Page<Role> queryPage(Pageable pageable, List<ColorsExpression> filters);

    void delete(Role role);

    RolePermission createRolePermission(Role role, Long permissionId);

    void deleteRolePermission(Role role, Long permissionId);
}
