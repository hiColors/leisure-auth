package com.github.lifelab.leisure.member.model.resource.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Member
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2019-01-09
 */
@Data
@ApiModel("人员信息")
public class Member {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("启用状态[0:未启用;1:启用]")
    private Boolean enabled;

    @ApiModelProperty("锁定状态[0:未锁定;1:锁定]")
    private Boolean lockStatus;

    @ApiModelProperty("过期时间")
    private Date expiredDate;

    @ApiModelProperty("凭证过期时间")
    private Date credentialsExpiredDate;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("手机号")
    private String mobile;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("出生日期")
    private Date birthday;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("主页")
    private String website;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("默认所属平台 id，如没有则不存在该值")
    private Long platformId;

    @ApiModelProperty("默认所属名称，如没有则不存在该值")
    private String platformName;

}