package com.github.life.lab.leisure.member.model.model.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

/**
 * MemberModel
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/24
 */
@ApiModel("人员信息 model")
@Data
public class MemberModel {

    @ApiModelProperty(notes = "手机号", required = true)
    @NotBlank(message = "手机号不允许为空")
    @Length(min = 10, max = 20, message = "手机号长度不合法")
    private String mobile;

    @ApiModelProperty(notes = "邮箱", required = true)
    @NotBlank(message = "邮箱不允许为空")
    @Email(message = "新邮箱不合法")
    private String email;

    @ApiModelProperty(notes = "昵称")
    @Length(max = 64, message = "昵称长度不合法")
    private String nickName;

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
