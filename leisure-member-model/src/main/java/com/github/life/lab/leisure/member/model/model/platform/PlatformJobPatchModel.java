package com.github.life.lab.leisure.member.model.model.platform;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * PlatformOrganizationModel
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/21
 */

@ApiModel("平台岗位补丁 model")
@Data
public class PlatformJobPatchModel {

    @ApiModelProperty(notes = "职级 ", required = true)
    @NotBlank(message = "职级 不允许为空")
    @Length(min = 1, max = 100, message = "职级 不合法")
    private String level;

    @ApiModelProperty(notes = "职称 ", required = true)
    @NotBlank(message = "职称 不允许为空")
    @Length(min = 1, max = 100, message = "职称 不合法")
    private String title;

    @ApiModelProperty(notes = "备注")
    @Length(min = 1, max = 255, message = "备注长度不合法")
    private String comment;

}