package com.github.lifelab.leisure.member.model.resource.platform;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * PlatformOrganization
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2019-01-09
 */
@Data
@ApiModel("平台组织架构信息")
@AllArgsConstructor
@NoArgsConstructor
public class PlatformOrganization {

    @ApiModelProperty(notes = "平台组织架构 id")
    private Long id;

    @ApiModelProperty(notes = "名称")
    private String name;

    @ApiModelProperty(notes = "层级")
    private Integer level;

    @ApiModelProperty(notes = "备注")
    private String comment;

    @ApiModelProperty(notes = "父节点 id")
    private Long parentId;

    @ApiModelProperty(notes = "父节点 名称")
    private String parentName;

    @ApiModelProperty(notes = "子节点 信息")
    private List<PlatformOrganization> children;
}