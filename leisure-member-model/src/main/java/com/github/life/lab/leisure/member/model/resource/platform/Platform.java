package com.github.life.lab.leisure.member.model.resource.platform;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Platform
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2019-01-09
 */
@Data
@ApiModel("平台信息")
@AllArgsConstructor
@NoArgsConstructor
public class Platform {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("发起人")
    private Long originator;

    @ApiModelProperty("发起人名称")
    private Long originatorName;

    @ApiModelProperty("状态[0:禁用;1:审核中;2:启用]")
    private Integer status;

    @ApiModelProperty("备注")
    private String comment;
}
