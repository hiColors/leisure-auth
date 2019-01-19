package com.github.life.lab.leisure.member.authorization.token.impl;

import com.github.life.lab.leisure.member.authorization.token.UserInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * MemberAuthorization
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/11/13
 */
@Data
@ApiModel("用户授权信息")
public class MemberAuthorization implements UserInfo {

    @ApiModelProperty("用户 id")
    private Long id;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("主平台 id")
    private Long platformId;

    @ApiModelProperty("主平台 名称")
    private String platformName;

    @ApiModelProperty("用户自身的角色信息")
    private List<String> memberRoles;

    @ApiModelProperty("用户在某平台下的角色信息")
    private Map<Long, List<String>> platformRoles;
}
