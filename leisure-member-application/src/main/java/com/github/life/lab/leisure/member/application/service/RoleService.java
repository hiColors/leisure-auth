package com.github.life.lab.leisure.member.application.service;

import com.github.life.lab.leisure.member.model.resource.role.Role;
import com.github.life.lab.leisure.member.model.resource.role.RoleModel;
import com.github.life.lab.leisure.member.model.resource.role.RolePatchModel;

/**
 * RoleService
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2019-01-20
 */
public interface RoleService {

    /**
     * 角色 - 创建
     *
     * @param model 对应模型
     * @return 角色信息
     */
    Role create(RoleModel model);

    /**
     * @param id 角色 id
     */
    void delete(Long id);

    /**
     * 角色 - 部分修改
     *
     * @param id    角色 id
     * @param model 对应模型
     * @return 角色信息
     */
    Role modify(Long id, RolePatchModel model);

    /**
     * 角色 - 查询
     *
     * @param id 角色 id
     * @return 角色信息
     */
    Role query(Long id);
}
