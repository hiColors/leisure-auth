package com.github.life.lab.leisure.member.model.resource.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Role
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2019-01-09
 */
@ApiModel("角色信息")
@Data
public class Role {

    @ApiModelProperty(notes = "角色 id")
    private Long id;

    @ApiModelProperty(notes = " 唯一标识码")
    private String code;

    @ApiModelProperty(notes = "名称")
    private String name;

    @ApiModelProperty(notes = "说明")
    private String description;

    @ApiModelProperty(notes = "备注")
    private String comment;
}
