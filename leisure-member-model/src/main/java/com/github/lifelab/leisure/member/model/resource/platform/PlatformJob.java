package com.github.lifelab.leisure.member.model.resource.platform;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * PlatformJob
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2019-01-09
 */
@Data
@ApiModel("平台岗位信息")
@AllArgsConstructor
@NoArgsConstructor
public class PlatformJob {

    @ApiModelProperty(notes = "岗位 id")
    private Long id;

    @ApiModelProperty(notes = "职级")
    private String level;

    @ApiModelProperty(notes = "职称")
    private String title;

    @ApiModelProperty(notes = "备注")
    private String comment;
}
