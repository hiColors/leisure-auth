package com.github.hicolors.leisure.auth.model.persistence;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.hicolors.leisure.common.model.BaseJpaModel;
import com.github.hicolors.leisure.common.model.validator.ValidatorGroup;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.List;

/**
 * 角色信息
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/2
 */
@Entity
@Table(name = "role")
@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(of = {"id", "name"})
@Where(clause = "delete_flag = 0")
public class Role extends BaseJpaModel {

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
     * 状态[0:未启用;1:启用]
     */
    private Boolean status;

    /**
     * 说明
     */
    private String explain;

    /**
     * varchar ( 255 ) null comment 备注
     */
    private String comment;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE})
    @JsonIgnoreProperties("role")
    private List<RolePermission> rolePermissions;
}