package com.github.life.lab.leisure.member.application.service;

import com.github.life.lab.leisure.common.model.expression.ColorsExpression;
import com.github.life.lab.leisure.member.model.model.role.PermissionModel;
import com.github.life.lab.leisure.member.model.persistence.Permission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * PermissionService
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/22
 */
public interface PermissionService {

    Permission create(PermissionModel model);

    Permission modify(Permission permission, PermissionModel model);

    Permission queryOne(Long id);

    Page<Permission> queryPage(Pageable pageable, List<ColorsExpression> filters);

    void delete(Permission permission);
}
