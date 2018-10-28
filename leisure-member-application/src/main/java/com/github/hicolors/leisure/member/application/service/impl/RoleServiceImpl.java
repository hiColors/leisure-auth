package com.github.hicolors.leisure.member.application.service.impl;

import com.github.hicolors.leisure.common.model.expression.ColorsExpression;
import com.github.hicolors.leisure.common.utils.ColorsBeanUtils;
import com.github.hicolors.leisure.member.application.exception.EnumCodeMessage;
import com.github.hicolors.leisure.member.application.exception.MemberServerException;
import com.github.hicolors.leisure.member.application.repository.RolePermissionRepository;
import com.github.hicolors.leisure.member.application.repository.RoleRepository;
import com.github.hicolors.leisure.member.application.service.PermissionService;
import com.github.hicolors.leisure.member.application.service.RoleService;
import com.github.hicolors.leisure.member.model.model.role.RoleModel;
import com.github.hicolors.leisure.member.model.model.role.RolePatchModel;
import com.github.hicolors.leisure.member.model.persistence.Permission;
import com.github.hicolors.leisure.member.model.persistence.Role;
import com.github.hicolors.leisure.member.model.persistence.RolePermission;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * RoleServiceImpl
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/22
 */
@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository repository;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RolePermissionRepository rolePermissionRepository;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Role create(RoleModel model) {
        checkName(model.getName(), null);
        Role role = new Role();
        //刚添加的角色状态 默认开启
        role.setStatus(true);
        BeanUtils.copyProperties(model, role);
        return repository.save(role);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Role modify(Role role, RolePatchModel model) {
        checkName(model.getName(), role.getId());
        ColorsBeanUtils.copyPropertiesNonNull(model, role);
        return repository.saveAndFlush(role);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Role modifyAll(Role role, RolePatchModel model) {
        checkName(model.getName(), role.getId());
        BeanUtils.copyProperties(model, role);
        return repository.saveAndFlush(role);
    }

    @Override
    public Role queryOne(Long id) {
        Optional<Role> role = repository.findById(id);
        return role.orElse(null);
    }

    @Override
    public Page<Role> queryPage(Pageable pageable, List<ColorsExpression> filters) {
        return repository.findPage(pageable, filters);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Role role) {
        int count = rolePermissionRepository.deleteByRoleId(role.getId());
        log.info("删除了 [{}] 条角色[{}] 对应的角色权限关联信息", count, role.getName());
        repository.delete(role);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public RolePermission createRolePermission(Role role, Long permissionId) {
        Permission permission = permissionService.queryOne(permissionId);
        if (Objects.isNull(permission)) {
            throw new MemberServerException(EnumCodeMessage.PERMISSION_STRATEGY_NON_EXIST);
        }
        RolePermission rolePermission = rolePermissionRepository.findByRoleIdAndPermissionId(role.getId(), permission.getId());
        if (Objects.nonNull(rolePermission)) {
            return rolePermission;
        }
        rolePermission = new RolePermission();
        rolePermission.setRole(role);
        rolePermission.setPermission(permission);
        return rolePermissionRepository.save(rolePermission);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteRolePermission(Role role, Long permissionId) {
        Permission permission = permissionService.queryOne(permissionId);
        if (Objects.isNull(permission)) {
            throw new MemberServerException(EnumCodeMessage.PERMISSION_STRATEGY_NON_EXIST);
        }
        int count = rolePermissionRepository.deleteByRoleIdAndPermissionId(role.getId(), permission.getId());
        log.info("删除了 [{}] 条角色[{}] & 权限[{}] 对应的角色权限关联信息", count, role.getName(), permission.getName());
    }

    private void checkName(String name, Long id) {
        Role role = repository.findByName(name);
        if (Objects.nonNull(role)) {
            id = ObjectUtils.defaultIfNull(id, 0L);
            if (!id.equals(role.getId())) {
                throw new MemberServerException(EnumCodeMessage.ROLE_NAME_EXIST);
            }
        }
    }
}
