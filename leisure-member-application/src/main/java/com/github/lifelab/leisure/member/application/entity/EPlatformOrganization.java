package com.github.lifelab.leisure.member.application.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.lifelab.leisure.common.jpa.customiz.model.BaseJpaModel;
import com.github.lifelab.leisure.common.model.validator.ValidatorGroup;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.List;

/**
 * 组织关系
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2018/10/10
 */
@Entity
@Table(name = "platform_organization")
@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "delete_flag = 0")
@ToString(of = {"id", "name"})
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class EPlatformOrganization extends BaseJpaModel {

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
    @JoinColumn(name = "platform_id", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    @JsonIgnoreProperties("organizations")
    private EPlatform platform;

    /**
     * 父级节点
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "parent_id", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    @JsonIgnoreProperties("parent")
    @NotFound(action = NotFoundAction.IGNORE)
    private EPlatformOrganization parent;

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

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE})
    @JsonIgnoreProperties({"parent", "platform"})
    private List<EPlatformOrganization> children;


    public EPlatformOrganization(Long id) {
        this.id = id;
    }
}
