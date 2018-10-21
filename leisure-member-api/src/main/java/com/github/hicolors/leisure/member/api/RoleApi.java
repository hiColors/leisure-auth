package com.github.hicolors.leisure.member.api;

import com.github.hicolors.leisure.common.model.expression.ColorsExpression;
import com.github.hicolors.leisure.member.model.model.role.RoleModel;
import com.github.hicolors.leisure.member.model.persistence.Role;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RoleApi
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/21
 */


@Api(tags = "role", description = "对角色的操作")
@RequestMapping("role")
public interface RoleApi {

    @ApiOperation("角色 - 创建")
    @PostMapping
    Role create(@RequestBody @Validated RoleModel model);

    @ApiOperation("角色 - 全部修改（不传字段修改为 null）")
    @PutMapping("/{id}")
    Role modifyAll(@PathVariable("id") Long id, @RequestBody RoleModel model);

    @ApiOperation("角色 - 部分修改")
    @PatchMapping("/{id}")
    Role modify(@PathVariable("id") Long id, @RequestBody RoleModel model);

    @ApiOperation("角色 - 查询")
    @GetMapping("/{id}")
    Role query(@PathVariable("id") Long id);

    @ApiOperation("角色 - 查询（分页筛选）")
    @GetMapping
    Page<Role> query(Pageable pageable, List<ColorsExpression> filters);
}