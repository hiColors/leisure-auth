package com.github.life.lab.leisure.member.application.rest;

import com.github.life.lab.leisure.common.model.expression.ColorsExpression;
import com.github.life.lab.leisure.member.application.service.RoleService;
import com.github.life.lab.leisure.member.intf.RoleApi;
import com.github.life.lab.leisure.member.model.resource.role.Role;
import com.github.life.lab.leisure.member.model.resource.role.RoleModel;
import com.github.life.lab.leisure.member.model.resource.role.RolePatchModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RoleRest
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/22
 */
@RestController
public class RoleRest implements RoleApi {

    @Autowired
    private RoleService roleService;

    @Override
    public Role create(@RequestBody @Validated RoleModel model) {
        return roleService.create(model);
    }

    @Override
    public void delete(@PathVariable("id") Long id) {
        roleService.delete(id);
    }

    @Override
    public Role modify(@PathVariable("id") Long id, @RequestBody @Validated RolePatchModel model) {
        return roleService.modify(id, model);
    }

    @Override
    public Role query(@PathVariable("key") String key, @RequestParam(value = "key-type", defaultValue = "id") String keyType) {
        return roleService.queryByKey(key, keyType);
    }

    @GetMapping
    public Page<Role> paging(@PageableDefault Pageable pageable, List<ColorsExpression> filters) {
        return roleService.paging(pageable, filters);
    }
}