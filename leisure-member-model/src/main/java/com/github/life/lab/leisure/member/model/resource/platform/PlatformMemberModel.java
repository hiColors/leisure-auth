package com.github.life.lab.leisure.member.model.resource.platform;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * PlatformModel
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/21
 */

@ApiModel("平台员工创建 model")
@Data
public class PlatformMemberModel {

    @ApiModelProperty(notes = "手机号", required = true)
    @NotBlank(message = "手机号不允许为空")
    @Length(min = 10, max = 20, message = "手机号长度不合法")
    private String mobile;

    @ApiModelProperty(notes = "姓名")
    @Length(max = 20, message = "姓名长度不合法")
    private String name;

    @ApiModelProperty(notes = "出生日期")
    private Date birthday;

    @ApiModelProperty(notes = "描述")
    @Length(max = 255, message = "描述长度不合法")
    private String description;

    @ApiModelProperty(notes = "主页")
    @Length(min = 3, max = 50, message = "主页长度不合法")
    private String website;

    @ApiModelProperty(notes = "头像")
    @Length(max = 255, message = "头像长度不合法")
    private String avatar;

    @ApiModelProperty(notes = "岗位 id ", required = true)
    @NotNull(message = "岗位 id 不允许为空")
    @Range(min = 1, message = "岗位 id 不合法")
    private Long jobId;

}
