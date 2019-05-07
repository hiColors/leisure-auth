package com.github.lifelab.leisure.member.model.resource.platform;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

/**
 * PlatformOrganizationModel
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/21
 */

@ApiModel("平台组织架构补丁 model")
@Data
public class PlatformOrganizationPatchModel {

    @ApiModelProperty(notes = "父级节点 id ", required = true)
    @Range(min = 1, message = "父级节点 id 不合法")
    private Long parent;

    @ApiModelProperty(notes = "名称", required = true)
    @Length(min = 1, max = 100, message = "名称长度不合法")
    private String name;

    @ApiModelProperty(notes = "备注")
    @Length(min = 1, max = 255, message = "备注长度不合法")
    private String comment;

}
