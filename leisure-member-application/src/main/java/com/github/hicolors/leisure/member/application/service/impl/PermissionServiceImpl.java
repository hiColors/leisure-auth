package com.github.hicolors.leisure.member.application.service.impl;

import com.github.hicolors.leisure.common.model.expression.ColorsExpression;
import com.github.hicolors.leisure.common.utils.ColorsBeanUtils;
import com.github.hicolors.leisure.member.application.exception.EnumCodeMessage;
import com.github.hicolors.leisure.member.application.exception.MemberServerException;
import com.github.hicolors.leisure.member.application.repository.PermissionRepository;
import com.github.hicolors.leisure.member.application.repository.RolePermissionRepository;
import com.github.hicolors.leisure.member.application.service.PermissionService;
import com.github.hicolors.leisure.member.model.model.role.PermissionModel;
import com.github.hicolors.leisure.member.model.persistence.Permission;
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
 * PermissionServiceImpl
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/22
 */
@Service
@Slf4j
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepository repository;

    @Autowired
    private RolePermissionRepository rolePermissionRepository;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Permission create(PermissionModel model) {
        checkName(model.getName(), null);
        checkStrategy(model.getAntPath(), model.getStrategy(), null);
        Permission permission = new Permission();
        BeanUtils.copyProperties(model, permission);
        return repository.save(permission);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Permission modify(Permission permission, PermissionModel model) {
        checkName(model.getName(), permission.getId());
        checkStrategy(model.getAntPath(), model.getStrategy(), permission.getId());
        ColorsBeanUtils.copyPropertiesNonNull(model, permission);
        return repository.saveAndFlush(permission);
    }

    @Override
    public Permission queryOne(Long id) {
        Optional<Permission> permission = repository.findById(id);
        return permission.orElse(null);
    }

    @Override
    public Page<Permission> queryPage(Pageable pageable, List<ColorsExpression> filters) {
        return repository.findPage(pageable, filters);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Permission permission) {
        int count = rolePermissionRepository.deleteByPermissionId(permission.getId());
        log.info("删除了 [{}] 条权限[{}] 对应的角色权限关联信息", count, permission.getName());
        repository.delete(permission);
    }

    private void checkName(String name, Long id) {
        Permission permission = repository.findByName(name);
        if (Objects.nonNull(permission)) {
            id = ObjectUtils.defaultIfNull(id, 0L);
            if (!id.equals(permission.getId())) {
                throw new MemberServerException(EnumCodeMessage.PERMISSION_NAME_EXIST);
            }
        }
    }

    private void checkStrategy(String antPath, Boolean strategy, Long id) {
        Permission permission = repository.findByAntPathAndStrategy(antPath, strategy);
        if (Objects.nonNull(permission)) {
            id = ObjectUtils.defaultIfNull(id, 0L);
            if (!id.equals(permission.getId())) {
                throw new MemberServerException(EnumCodeMessage.PERMISSION_STRATEGY_EXIST);
            }
        }
    }
}
