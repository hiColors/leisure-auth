package com.github.hicolors.leisure.member.api;

import com.github.hicolors.leisure.common.model.expression.ColorsExpression;
import com.github.hicolors.leisure.member.model.model.role.PermissionModel;
import com.github.hicolors.leisure.member.model.persistence.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * PermissionApi
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/21
 */
@Api(tags = "permission", description = "对权限的相关操作")
@RequestMapping("permission")
public interface PermissionApi {

    @ApiOperation("权限 - 创建")
    @PostMapping
    Permission create(@RequestBody @Validated PermissionModel model);

    @ApiOperation("权限 - 部分修改")
    @PatchMapping("/{id}")
    Permission modify(@PathVariable("id") Long id, @RequestBody PermissionModel model);

    @ApiOperation("权限 - 查询")
    @GetMapping("/{id}")
    Permission query(@PathVariable("id") Long id);

    @ApiOperation("权限 - 查询（分页筛选）")
    @GetMapping
    Page<Permission> query(@PageableDefault(page = 0, size = 10) Pageable pageable, List<ColorsExpression> filters);

    @ApiOperation("权限 - 删除")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("id") Long id);
}