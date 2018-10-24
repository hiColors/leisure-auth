package com.github.hicolors.leisure.member.model.model.role;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * PermissionModel
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/21
 */

@ApiModel("权限创建 model")
@Data
public class PermissionModel {

    @ApiModelProperty(notes = "名称", required = true)
    @NotBlank(message = "名称不允许为空")
    @Length(min = 1, max = 100, message = "名称长度不合法")
    private String name;

    @ApiModelProperty(notes = "路径匹配规则", required = true)
    @NotBlank(message = "路径匹配规则不允许为空")
    @Length(min = 1, max = 100, message = "路径匹配规则长度不合法")
    private String antPath;

    @ApiModelProperty(notes = "策略[0: 拒绝;1:允许]", required = true)
    @NotNull(message = "策略不允许为空")
    private Boolean strategy;

    @ApiModelProperty(notes = "状态[0:未启用;1:启用]", required = true)
    @NotNull(message = "状态不允许为空")
    private Boolean status;

    @ApiModelProperty(notes = "说明", required = true)
    @NotBlank(message = "说明不允许为空")
    @Length(min = 1, max = 255, message = "说明长度不合法")
    private String description;

    @ApiModelProperty(notes = "备注", required = true)
    @Length(min = 1, max = 255, message = "备注长度不合法")
    private String comment;

}
