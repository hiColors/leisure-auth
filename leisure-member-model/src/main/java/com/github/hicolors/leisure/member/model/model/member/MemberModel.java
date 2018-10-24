package com.github.hicolors.leisure.member.model.model.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

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

    @ApiModelProperty(notes = "昵称", required = true)
    @Length(max = 64, message = "昵称长度不合法")
    private String nickName;

    @ApiModelProperty(notes = "姓名", required = true)
    @Length(max = 20, message = "姓名长度不合法")
    private String name;

    @ApiModelProperty(notes = "出生日期", required = true)
    private Date birthday;

    @ApiModelProperty(notes = "描述", required = true)
    @Length(max = 255, message = "描述长度不合法")
    private String description;

    @ApiModelProperty(notes = "主页", required = true)
    @Length(min = 10, max = 50, message = "主页长度不合法")
    private String website;

    @ApiModelProperty(notes = "头像", required = true)
    @Length(max = 255, message = "头像长度不合法")
    private String avatar;
}
