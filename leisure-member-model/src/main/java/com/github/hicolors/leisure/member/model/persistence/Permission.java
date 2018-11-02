package com.github.hicolors.leisure.member.model.persistence;

import com.github.hicolors.leisure.common.model.BaseJpaModel;
import com.github.hicolors.leisure.common.model.validator.ValidatorGroup;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Null;

/**
 * 权限信息
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/2
 */
@Entity
@Table(name = "permission")
@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "delete_flag = 0")
@ToString(of = {"id", "name"})
public class Permission extends BaseJpaModel {

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
     * 路径匹配规则
     */
    @Column(name = "ant_path")
    private String antPath;

    /**
     * 策略[0: 拒绝;1:允许]
     */
    private Boolean strategy;

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