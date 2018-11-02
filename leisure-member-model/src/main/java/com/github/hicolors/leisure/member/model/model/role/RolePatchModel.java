package com.github.hicolors.leisure.member.model.model.role;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * RoleModel
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/21
 */

@ApiModel("角色补丁 model")
@Data
public class RolePatchModel {

    @ApiModelProperty(notes = "名称", required = true)
    @Length(min = 1, max = 100, message = "名称长度不合法")
    private String name;

    @ApiModelProperty(notes = "状态[0:未启用;1:启用]", required = true)
    private Boolean status;

    @ApiModelProperty(notes = "说明", required = true)
    @Length(min = 1, max = 255, message = "说明长度不合法")
    private String description;

    @ApiModelProperty(notes = "备注")
    @Length(min = 1, max = 255, message = "备注长度不合法")
    private String comment;
}
