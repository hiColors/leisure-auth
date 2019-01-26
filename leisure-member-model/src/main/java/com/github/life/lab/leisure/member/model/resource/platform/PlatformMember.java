package com.github.life.lab.leisure.member.model.resource.platform;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * PlatformMember
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2019-01-09
 */
@ApiModel("平台员工信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatformMember {

    @ApiModelProperty(notes = "员工 id")
    private Long id;

    @ApiModelProperty(notes = "手机号")
    private String mobile;

    @ApiModelProperty(notes = "姓名")
    private String name;

    @ApiModelProperty(notes = "工号")
    private String employeeNumber;

    @ApiModelProperty(notes = "入职日期")
    private Date entryDate;

    @ApiModelProperty(notes = "备注")
    private String comment;

    @ApiModelProperty(notes = "平台 id")
    private Long platformId;

    @ApiModelProperty(notes = "平台 名称")
    private String platformName;

    @ApiModelProperty(notes = "平台组织架构 id")
    private Long organizationId;

    @ApiModelProperty(notes = "平台组织架构 名称")
    private String organizationName;

    @ApiModelProperty(notes = "岗位 id", required = true)
    private Long jobId;

    @ApiModelProperty(notes = "岗位 职级", required = true)
    private String jobLevel;

    @ApiModelProperty(notes = "岗位 职称", required = true)
    private String jobTitle;


}