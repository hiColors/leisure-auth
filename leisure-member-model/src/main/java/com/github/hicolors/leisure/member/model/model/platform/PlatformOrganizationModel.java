package com.github.hicolors.leisure.member.model.model.platform;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * PlatformOrganizationModel
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/21
 */

@ApiModel("平台组织架构创建 model")
@Data
public class PlatformOrganizationModel {

    @ApiModelProperty(notes = "父级节点 id ", required = true)
    @NotNull(message = "父级节点 id 不允许为空")
    @Range(min = 1, message = "父级节点 id 不合法")
    private Long parent;

    @ApiModelProperty(notes = "名称", required = true)
    @NotBlank(message = "名称不允许为空")
    @Length(min = 1, max = 100, message = "名称长度不合法")
    private String name;

    @ApiModelProperty(notes = "备注")
    @Length(min = 1, max = 255, message = "备注长度不合法")
    private String comment;

}
