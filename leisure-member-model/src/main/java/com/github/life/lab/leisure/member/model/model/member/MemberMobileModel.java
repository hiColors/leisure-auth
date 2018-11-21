package com.github.life.lab.leisure.member.model.model.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * MemberUsernameModel
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/24
 */

@ApiModel("人员手机号 model")
@Data
public class MemberMobileModel {

    @ApiModelProperty(notes = "新手机号", required = true)
    @NotBlank(message = "新手机号不允许为空")
    @Length(min = 10, max = 20, message = "新手机号长度不合法")
    private String mobile;

}
