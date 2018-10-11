package com.github.hicolors.leisure.auth.model.persistence;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.hicolors.leisure.common.model.BaseJpaModel;
import com.github.hicolors.leisure.common.model.validator.ValidatorGroup;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Null;

/**
 * 组织关系
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/10
 */
@Entity
@Table(name = "organization")
@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "delete_flag = 0")
@ToString(of = {"id", "name"})
public class Organization extends BaseJpaModel {

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
     * 集团 id
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "group_id", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    @JsonIgnoreProperties("group")
    private Group group;

    /**
     * 父级节点
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "parent_id", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    @JsonIgnoreProperties("parent")
    @NotFound(action = NotFoundAction.IGNORE)
    private Organization parent;

    /**
     * 名称
     */
    private String name;

    /**
     * 层级
     */
    private Integer level;

    /**
     * varchar ( 255 ) null comment 备注
     */
    private String comment;
}
