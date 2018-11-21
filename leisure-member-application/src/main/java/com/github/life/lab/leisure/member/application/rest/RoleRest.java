package com.github.life.lab.leisure.member.application.rest;

import com.github.life.lab.leisure.common.exception.ResourceNotFoundException;
import com.github.life.lab.leisure.common.model.expression.ColorsExpression;
import com.github.life.lab.leisure.member.application.service.RoleService;
import com.github.life.lab.leisure.member.intf.RoleApi;
import com.github.life.lab.leisure.member.model.model.role.RoleModel;
import com.github.life.lab.leisure.member.model.model.role.RolePatchModel;
import com.github.life.lab.leisure.member.model.persistence.Role;
import com.github.life.lab.leisure.member.model.persistence.RolePermission;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;

/**
 * RoleRest
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/22
 */
@RestController
public class RoleRest implements RoleApi {

    @Autowired
    private RoleService service;

    @Override
    public Role create(@Validated @RequestBody RoleModel model) {
        return service.create(model);
    }

    @Override
    public Role modify(@PathVariable("id") Long id, @Validated @RequestBody RolePatchModel model) {
        return service.modify(get(id), model);
    }

    @Override
    public Role query(@PathVariable("id") Long id) {
        return get(id);
    }

    @ApiOperation("[Pageable + ColorsExpression]")
    @GetMapping
    public Page<Role> query(@PageableDefault Pageable pageable, List<ColorsExpression> filters) {
        return service.queryPage(pageable, filters);
    }

    @Override
    public void delete(@PathVariable("id") Long id) {
        service.delete(get(id));
    }

    @Override
    public RolePermission createRolePermission(@PathVariable("roleId") Long roleId, @PathVariable("permissionId") Long permissionId) {
        return service.createRolePermission(get(roleId), permissionId);
    }

    @Override
    public void deleteRolePermission(@PathVariable("roleId") Long roleId, @PathVariable("permissionId") Long permissionId) {
        service.deleteRolePermission(get(roleId), permissionId);
    }

    private Role get(Long id) {
        Role role = service.queryOne(id);
        if (Objects.isNull(role)) {
            throw new ResourceNotFoundException(MessageFormat.format("该 id[{0}] 对应的角色不存在！", id));
        }
        return role;
    }
}