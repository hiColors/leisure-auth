package com.github.life.lab.leisure.member.intf;

import com.github.life.lab.leisure.member.model.resource.role.Role;
import com.github.life.lab.leisure.member.model.resource.role.RoleModel;
import com.github.life.lab.leisure.member.model.resource.role.RolePatchModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * RoleApi
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/21
 */
@Api(tags = "role", description = "对角色的相关操作")
@RequestMapping("role")
public interface RoleApi {

    @ApiOperation("角色 - 创建")
    @PostMapping
    Role create(@RequestBody @Validated RoleModel model);

    @ApiOperation("角色 - 删除")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("id") Long id);

    @ApiOperation("角色 - 部分修改")
    @PatchMapping("/{id}")
    Role modify(@PathVariable("id") Long id, @RequestBody RolePatchModel model);

    @ApiOperation("角色 - 查询")
    @GetMapping("/{id}")
    Role query(@PathVariable("id") Long id);

}