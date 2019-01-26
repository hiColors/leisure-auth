package com.github.life.lab.leisure.member.model.resource.platform;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

/**
 * PlatformModel
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/21
 */

@ApiModel("平台补丁 model")
@Data
public class PlatformPatchModel {

    @ApiModelProperty(notes = "名称", required = true)
    @Length(min = 1, max = 100, message = "非法的名称长度")
    private String name;

    @ApiModelProperty(notes = "状态[0:禁用;1:审核中;2:启用]", required = true)
    @Range(max = 2, message = "非法的状态值")
    private Integer status;

    @ApiModelProperty(notes = "备注")
    @Length(min = 1, max = 255, message = "非法的备注长度")
    private String comment;

}
