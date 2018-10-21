package com.github.hicolors.leisure.member.model.persistence;

import com.github.hicolors.leisure.common.model.BaseJpaModel;
import com.github.hicolors.leisure.common.model.validator.ValidatorGroup;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.Date;

/**
 * 组织关系
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/10
 */
@Entity
@Table(name = "platform_member_role")
@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "delete_flag = 0")
@ToString(of = {"id"})
public class PlatformMemberRole extends BaseJpaModel {

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
     * 平台员工 id
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "platform_member_id", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    private PlatformMember platformMember;


    /**
     * 平台 id
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    private  Role role;
}
