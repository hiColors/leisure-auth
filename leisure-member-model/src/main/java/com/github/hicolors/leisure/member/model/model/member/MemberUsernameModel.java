package com.github.hicolors.leisure.member.model.model.member;

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

@ApiModel("人员用户名 model")
@Data
public class MemberUsernameModel {

    @ApiModelProperty(notes = "用户名", required = true)
    @NotBlank(message = "用户名不允许为空")
    @Length(min = 6, max = 32, message = "用户名长度不合法")
    private String username;
}
