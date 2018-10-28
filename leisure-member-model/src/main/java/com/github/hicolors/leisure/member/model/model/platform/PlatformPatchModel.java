package com.github.hicolors.leisure.member.model.model.platform;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * PlatformModel
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/21
 */

@ApiModel("平台创建 model")
@Data
public class PlatformPatchModel {

    @ApiModelProperty(notes = "名称", required = true)
    @NotBlank(message = "名称不允许为空")
    @Length(min = 1, max = 100, message = "名称长度不合法")
    private String name;

    @ApiModelProperty(notes = "状态[0:未启用;1:启用]", required = true)
    @NotNull(message = "状态不允许为空")
    private Boolean status;

    @ApiModelProperty(notes = "备注")
    @Length(min = 1, max = 255, message = "备注长度不合法")
    private String comment;

}
