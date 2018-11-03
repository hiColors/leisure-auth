package com.github.hicolors.leisure.member.model.persistence;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "platform_member")
@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "delete_flag = 0")
@ToString(of = {"id", "employeeNumber"})
public class PlatformMember extends BaseJpaModel {

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
     * 平台 id
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "platform_id", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    @JsonIgnoreProperties("organizations")
    private Platform platform;

    /**
     * 平台组织架构 id
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "platform_organization_id", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    @JsonIgnoreProperties({"platform", "parent", "children"})
    private PlatformOrganization platformOrganization;


    /**
     * 人员 id
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "member_id", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    private Member member;

    /**
     * 员工 姓名
     */
    private String name;

    /**
     * 工号
     */
    @Column(name = "employee_number")
    private String employeeNumber;

    /**
     * 入职日期
     */
    @Column(name = "entry_date")
    private Date entryDate;

    /**
     * varchar ( 255 ) null comment 备注
     */
    private String comment;
}
