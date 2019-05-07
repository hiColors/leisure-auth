package com.github.lifelab.leisure.member.model.resource.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

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
    @Length(min = 11, max = 11, message = "手机号长度不合法")
    @Pattern(
            regexp = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$",
            message = "手机号不合法")
    private String mobile;

}
