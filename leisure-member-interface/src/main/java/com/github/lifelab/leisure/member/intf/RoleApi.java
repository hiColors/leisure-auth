package com.github.lifelab.leisure.member.intf;

import com.github.lifelab.leisure.member.model.resource.role.Role;
import com.github.lifelab.leisure.member.model.resource.role.RoleModel;
import com.github.lifelab.leisure.member.model.resource.role.RolePatchModel;
import com.github.lifelab.leisure.member.model.resource.role.RoleStatusModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * RoleApi
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2018/10/21
 */
@Api(tags = "role", description = "对角色的相关操作")
@RequestMapping("/roles")
public interface RoleApi {

    @ApiOperation("角色 - 创建")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Role create(@RequestBody @Validated RoleModel model);

    @ApiOperation("角色 - 删除")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("id") Long id);

    @ApiOperation("角色 - 部分修改")
    @PatchMapping("/{id}")
    Role modify(@PathVariable("id") Long id, @RequestBody RolePatchModel model);

    @ApiOperation("角色 - 状态修改")
    @PatchMapping("/{id}/status")
    Role modifyStatus(@PathVariable("id") Long id, @RequestBody RoleStatusModel model);


    @ApiOperation(value = "角色 - 查询", notes = "当前支持的 keyType : 【id - 主键，默认值】;【code - 唯一标识码】")
    @GetMapping("/{key}")
    Role query(@PathVariable("key") String key, @RequestParam("key-type") String keyType);

}