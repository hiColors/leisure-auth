package com.github.hicolors.leisure.member.authorization.token.impl;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * AuthToken
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/11/16
 */

@ApiModel("令牌信息")
@Data
public class AuthToken {

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("访问 token")
    private String accessToken;

    @ApiModelProperty("token 失效期")
    private Long tokenExpires;

    @ApiModelProperty("刷新 token ")
    private String refreshToken;

    @ApiModelProperty("刷新 token 失效期")
    private Long refreshTokenExpires;
}
