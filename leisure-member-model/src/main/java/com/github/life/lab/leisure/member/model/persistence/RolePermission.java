package com.github.life.lab.leisure.member.model.persistence;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.life.lab.leisure.common.model.BaseJpaModel;
import com.github.life.lab.leisure.common.model.validator.ValidatorGroup;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Null;

/**
 * 角色权限信息
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/2
 */
@Entity
@Table(name = "role_permission")
@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "delete_flag = 0")
@ToString(of = {"id"})
public class RolePermission extends BaseJpaModel {

    @Null(
            message = "id 必须为空",
            groups = {ValidatorGroup.Post.class, ValidatorGroup.Put.class, ValidatorGroup.Patch.class}
    )
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    @JsonIgnoreProperties("role_permissions")
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "permission_id", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    private Permission permission;

}