package com.github.life.lab.leisure.member.model.model.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import java.util.Date;

/**
 * MemberModel
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/24
 */
@ApiModel("人员信息补丁 model")
@Data
public class MemberPatchModel {


    @ApiModelProperty(notes = "昵称")
    @Length(max = 64, message = "昵称长度不合法")
    private String nickName;

    @ApiModelProperty(notes = "启用状态[0:未启用;1:启用]")
    private Boolean enabled;

    @ApiModelProperty(notes = "锁定状态[0:未锁定;1:锁定]")
    private Boolean lockStatus;

    @ApiModelProperty(notes = "过期时间")
    private Date expiredDate;

    @Column(name = "credentials_expired_date")
    @ApiModelProperty(notes = "凭证过期时间")
    private Date credentialsExpiredDate;

    @ApiModelProperty(notes = "姓名")
    @Length(max = 20, message = "姓名长度不合法")
    private String name;

    @ApiModelProperty(notes = "出生日期")
    private Date birthday;

    @ApiModelProperty(notes = "描述")
    @Length(max = 255, message = "描述长度不合法")
    private String description;

    @ApiModelProperty(notes = "主页")
    @Length(min = 10, max = 50, message = "主页长度不合法")
    private String website;

    @ApiModelProperty(notes = "头像")
    @Length(max = 255, message = "头像长度不合法")
    private String avatar;
}
