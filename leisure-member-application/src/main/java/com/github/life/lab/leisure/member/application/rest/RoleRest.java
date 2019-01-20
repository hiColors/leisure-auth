package com.github.life.lab.leisure.member.application.rest;

import com.github.life.lab.leisure.member.intf.RoleApi;
import com.github.life.lab.leisure.member.model.resource.role.Role;
import com.github.life.lab.leisure.member.model.resource.role.RoleModel;
import com.github.life.lab.leisure.member.model.resource.role.RolePatchModel;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * RoleRest
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/22
 */
@RestController
public class RoleRest implements RoleApi {
    @Override
    public Role create(@RequestBody @Validated RoleModel model) {
        return null;
    }

    @Override
    public void delete(@PathVariable("id") Long id) {

    }

    @Override
    public Role modify(@PathVariable("id") Long id, @RequestBody @Validated RolePatchModel model) {
        return null;
    }

    @Override
    public Role query(@PathVariable("id") Long id) {
        return null;
    }
}