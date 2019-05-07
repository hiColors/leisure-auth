package com.github.lifelab.leisure.member.model.resource.platform;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import java.util.Date;

/**
 * PlatformMemberPatchModel
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/21
 */

@ApiModel("平台员工补丁 model")
@Data
public class PlatformMemberPatchModel {

    @ApiModelProperty(notes = "组织架构 id ")
    @Range(min = 1, message = "组织架构 id 不合法")
    private Long organizationId;

    @ApiModelProperty(notes = "岗位 id ")
    @Range(min = 1, message = "岗位 id 不合法")
    private Long jobId;

    @ApiModelProperty(notes = "姓名 ")
    @Length(min = 1, max = 20, message = "姓名不合法")
    private String name;

    @ApiModelProperty(notes = "工号")
    @Length(min = 1, max = 32, message = "工号不合法")
    private String employeeNumber;

    @ApiModelProperty(notes = "入职日期")
    private Date entryDate;

    @ApiModelProperty(notes = "备注")
    @Length(max = 255, message = "备注不合法")
    private String comment;

}
