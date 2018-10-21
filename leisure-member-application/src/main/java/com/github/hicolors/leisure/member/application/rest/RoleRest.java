package com.github.hicolors.leisure.member.application.rest;

import com.github.hicolors.leisure.common.model.expression.ColorsExpression;
import com.github.hicolors.leisure.member.api.RoleApi;
import com.github.hicolors.leisure.member.application.service.RoleService;
import com.github.hicolors.leisure.member.model.model.role.RoleModel;
import com.github.hicolors.leisure.member.model.persistence.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleRest implements RoleApi {

    @Autowired
    private RoleService service;

    @Override
    public Role create(@RequestBody @Validated RoleModel model) {
        return service.create(model);
    }

    @Override
    public Role modifyAll(@PathVariable("id") Long id, @RequestBody RoleModel model) {
        return service.modifyAll(get(id), model);
    }

    @Override
    public Role modify(@PathVariable("id") Long id, @RequestBody RoleModel model) {
        return service.modify(get(id), model);
    }

    @Override
    public Role query(@PathVariable("id") Long id) {
        return get(id);
    }

    @Override
    public Page<Role> query(@PageableDefault(page = 0) Pageable pageable, List<ColorsExpression> filters) {
        return service.queryPage(pageable, filters);
    }

    private Role get(Long id) {
        return service.queryOne(id);
    }
}
