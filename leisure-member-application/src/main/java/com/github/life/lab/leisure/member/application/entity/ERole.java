package com.github.life.lab.leisure.member.application.entity;

import com.github.life.lab.leisure.common.jpa.customiz.model.BaseJpaModel;
import com.github.life.lab.leisure.common.model.validator.ValidatorGroup;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Null;

/**
 * 角色信息
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2018/10/2
 */
@Entity
@Table(name = "role", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
})
@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(of = {"id", "name"})
@Where(clause = "delete_flag = 0")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ERole extends BaseJpaModel {

    @Null(
            message = "id 必须为空",
            groups = {ValidatorGroup.Post.class, ValidatorGroup.Put.class, ValidatorGroup.Patch.class}
    )
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    /**
     * 唯一标识码
     */
    private String code;

    /**
     * 名称
     */

    private String name;

    /**
     * 状态[0:未启用;1:启用]
     */
    private Boolean status;

    /**
     * 说明
     */
    private String description;

    /**
     * varchar ( 255 ) null comment 备注
     */
    private String comment;

}