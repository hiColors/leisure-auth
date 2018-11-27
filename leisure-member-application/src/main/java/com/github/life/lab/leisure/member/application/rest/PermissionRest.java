package com.github.life.lab.leisure.member.application.rest;

import com.github.life.lab.leisure.common.exception.ResourceNotFoundException;
import com.github.life.lab.leisure.common.model.expression.ColorsExpression;
import com.github.life.lab.leisure.member.application.service.PermissionService;
import com.github.life.lab.leisure.member.intf.PermissionApi;
import com.github.life.lab.leisure.member.model.model.role.PermissionModel;
import com.github.life.lab.leisure.member.model.persistence.Permission;
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
import springfox.documentation.annotations.ApiIgnore;

import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;

;

/**
 * PermissionRest
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/22
 */
@RestController
public class PermissionRest implements PermissionApi {

    @Autowired
    private PermissionService service;

    @Override
    public Permission create(@Validated @RequestBody PermissionModel model) {
        return service.create(model);
    }

    @Override
    public Permission modify(@PathVariable("id") Long id, @Validated @RequestBody PermissionModel model) {
        return service.modify(get(id), model);
    }

    @Override
    public Permission query(@PathVariable("id") Long id) {
        return get(id);
    }

    @ApiOperation("[Pageable + ColorsExpression]")
    @GetMapping
    public Page<Permission> query(@PageableDefault @ApiIgnore Pageable pageable, @ApiIgnore List<ColorsExpression> filters) {
        return service.queryPage(pageable, filters);
    }

    @Override
    public void delete(@PathVariable("id") Long id) {
        service.delete(get(id));
    }

    private Permission get(Long id) {
        Permission permission = service.queryOne(id);
        if (Objects.isNull(permission)) {
            throw new ResourceNotFoundException(MessageFormat.format("该 id[{0}] 对应的权限不存在！", id));
        }
        return permission;
    }
}