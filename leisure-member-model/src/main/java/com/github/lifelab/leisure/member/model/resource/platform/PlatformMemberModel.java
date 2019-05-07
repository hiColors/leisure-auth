package com.github.lifelab.leisure.member.model.resource.platform;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
    @Pattern(
            regexp = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$",
            message = "手机号不合法")
    private String mobile;

    @ApiModelProperty(notes = "姓名")
    @Length(max = 20, message = "姓名长度不合法")
    private String name;

    @ApiModelProperty(notes = "工作邮箱", required = true)
    @NotBlank(message = "工作邮箱不允许为空")
    @Email(message = "工作邮箱不合法")
    private String email;

    @ApiModelProperty(notes = "工号")
    @Length(min = 1, max = 32, message = "工号不合法")
    private String employeeNumber;

    @ApiModelProperty(notes = "入职日期")
    private Date entryDate;

    @ApiModelProperty(notes = "备注")
    @Length(max = 255, message = "备注不合法")
    private String comment;

    @ApiModelProperty(notes = "岗位 id ", required = true)
    @NotNull(message = "岗位 id 不允许为空")
    @Range(min = 1, message = "岗位 id 不合法")
    private Long jobId;

    @ApiModelProperty(notes = "组织架构 id ")
    @NotNull(message = "组织架构 id 不允许为空")
    @Range(min = 1, message = "组织架构 id 不合法")
    private Long organizationId;


}
