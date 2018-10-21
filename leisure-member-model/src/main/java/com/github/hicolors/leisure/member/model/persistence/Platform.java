package com.github.hicolors.leisure.member.model.persistence;

import com.github.hicolors.leisure.member.model.consts.EnumPlatformStatus;
import com.github.hicolors.leisure.common.model.BaseJpaModel;
import com.github.hicolors.leisure.common.model.validator.ValidatorGroup;
import com.github.hicolors.leisure.member.model.persistence.converter.PlatformStatusConverter;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Null;

/**
 * 集团信息
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/10
 */
@Entity
@Table(name = "platform")
@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "delete_flag = 0")
@ToString(of = {"id", "name", "status"})
public class Platform extends BaseJpaModel {

    /**
     * 主键
     */

    @Null(
            message = "id 必须为空",
            groups = {ValidatorGroup.Post.class, ValidatorGroup.Put.class, ValidatorGroup.Patch.class}
    )
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 状态[0:禁用;1:审核中;2:启用]
     */
    @Convert(converter = PlatformStatusConverter.class)
    private EnumPlatformStatus status;

    /**
     * varchar ( 255 ) null comment 备注
     */
    private String comment;
}
