package com.github.life.lab.leisure.member.model.resource.role;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * RoleModel
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/21
 */

@ApiModel("角色状态补丁 model")
@Data
public class RoleStatusModel {

    @ApiModelProperty(notes = "状态[0:未启用;1:启用]", required = true)
    @NotNull(message = "状态值不能为空")
    private Boolean status;

}
