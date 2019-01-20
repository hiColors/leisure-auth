package com.github.life.lab.leisure.member.application.service.impl;

import com.github.life.lab.leisure.member.application.service.RoleService;
import com.github.life.lab.leisure.member.model.resource.role.Role;
import com.github.life.lab.leisure.member.model.resource.role.RoleModel;
import com.github.life.lab.leisure.member.model.resource.role.RolePatchModel;
import org.springframework.stereotype.Service;

/**
 * RoleServiceImpl
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2019-01-20
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Override
    public Role create(RoleModel model) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Role modify(Long id, RolePatchModel model) {
        return null;
    }

    @Override
    public Role query(Long id) {
        return null;
    }
}
