package com.github.lifelab.leisure.member.authorization.token.impl;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * PlatformMemberInformation
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2019-01-29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("员工信息")
public class PlatformMemberInformation {

    @ApiModelProperty("平台 id")
    private Long platformId;

    @ApiModelProperty("平台 名称")
    private String platformName;

    @ApiModelProperty("该平台所拥有的角色列表")
    private List<String> roles;
}