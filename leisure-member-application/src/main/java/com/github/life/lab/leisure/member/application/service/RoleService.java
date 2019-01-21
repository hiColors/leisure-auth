package com.github.life.lab.leisure.member.application.service;

import com.github.life.lab.leisure.common.model.expression.ColorsExpression;
import com.github.life.lab.leisure.member.model.resource.role.Role;
import com.github.life.lab.leisure.member.model.resource.role.RoleModel;
import com.github.life.lab.leisure.member.model.resource.role.RolePatchModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

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
     * 角色 - 删除
     *
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

    /**
     * 角色 - 查询通过唯一标识码
     *
     * @param code 唯一标识码
     * @return 角色信息
     */
    Role queryByCode(String code);

    /**
     * 分页查询
     *
     * @param pageable 分页对象
     * @param filters  过滤器
     * @return 查询结果
     */
    Page<Role> paging(Pageable pageable, List<ColorsExpression> filters);
}
