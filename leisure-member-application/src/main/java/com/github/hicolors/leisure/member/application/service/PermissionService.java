package com.github.hicolors.leisure.member.application.service;

import com.github.hicolors.leisure.common.model.expression.ColorsExpression;
import com.github.hicolors.leisure.member.model.model.role.PermissionModel;
import com.github.hicolors.leisure.member.model.persistence.Permission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PermissionService {

    Permission create(PermissionModel model);

    Permission modify(Permission Permission, PermissionModel model);

    Permission modifyAll(Permission Permission, PermissionModel model);

    Permission queryOne(Long id);

    Page<Permission> queryPage(Pageable pageable, List<ColorsExpression> filters);

    void delete(Permission Permission);
}
