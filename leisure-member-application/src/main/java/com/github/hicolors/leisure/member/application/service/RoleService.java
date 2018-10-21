package com.github.hicolors.leisure.member.application.service;

import com.github.hicolors.leisure.common.model.expression.ColorsExpression;
import com.github.hicolors.leisure.member.model.model.role.RoleModel;
import com.github.hicolors.leisure.member.model.persistence.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoleService {

    Role create(RoleModel model);

    Role modify(Role role, RoleModel model);

    Role modifyAll(Role role, RoleModel model);

    Role queryOne(Long id);

    Page<Role> queryPage(Pageable pageable, List<ColorsExpression> filters);
}
