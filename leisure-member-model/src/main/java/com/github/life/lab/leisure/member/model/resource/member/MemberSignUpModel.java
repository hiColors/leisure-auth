package com.github.life.lab.leisure.member.model.resource.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * MemberSignUpModel
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/24
 */

@ApiModel("人员注册 model")
@Data
public class MemberSignUpModel {

    @ApiModelProperty(notes = "手机号", required = true)
    @NotBlank(message = "手机号不允许为空")
    @Length(min = 11, max = 11, message = "手机号长度不合法")
    private String mobile;
}
