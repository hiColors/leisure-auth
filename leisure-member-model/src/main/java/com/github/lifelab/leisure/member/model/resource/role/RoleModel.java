package com.github.lifelab.leisure.member.model.resource.role;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * RoleModel
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/21
 */

@ApiModel("角色创建 model")
@Data
public class RoleModel {

    @ApiModelProperty(notes = "唯一标识码", required = true)
    @NotBlank(message = "唯一标识码不允许为空")
    @Length(min = 1, max = 64, message = "唯一标识码长度不合法，长度规格为 1~64 个字符。")
    private String code;

    @ApiModelProperty(notes = "名称", required = true)
    @NotBlank(message = "名称不允许为空")
    @Length(min = 1, max = 100, message = "名称长度不合法，长度规格为 1~100 个字符。")
    private String name;

    @ApiModelProperty(notes = "说明", required = true)
    @NotBlank(message = "说明不允许为空")
    @Length(min = 1, max = 255, message = "说明长度不合法，长度规格为 1~255 个字符。")
    private String description;

    @ApiModelProperty(notes = "备注")
    @Length(min = 1, max = 255, message = "备注长度不合法，长度规格为 1~255 个字符。")
    private String comment;
}
