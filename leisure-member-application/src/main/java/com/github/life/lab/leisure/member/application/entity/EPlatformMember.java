package com.github.life.lab.leisure.member.application.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.life.lab.leisure.common.jpa.customiz.model.BaseJpaModel;
import com.github.life.lab.leisure.common.model.validator.ValidatorGroup;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.Date;

/**
 * 组织关系
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2018/10/10
 */
@Entity
@Table(name = "platform_member", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"platform_id", "member_id"}),
        @UniqueConstraint(columnNames = {"platform_id", "mobile"}),
})
@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "delete_flag = 0")
@ToString(of = {"id", "employeeNumber"})
public class EPlatformMember extends BaseJpaModel {

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
    private EPlatform platform;

    /**
     * 平台组织架构 id
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "platform_organization_id", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    @JsonIgnoreProperties({"platform", "parent", "children"})
    private EPlatformOrganization platformOrganization;

    /**
     * 平台岗位 id
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "platform_job_id", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    @JsonIgnoreProperties({"platform"})
    private EPlatformJob platformJob;


    /**
     * 人员 id
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "member_id", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    private EMember member;

    /**
     * 员工 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String mobile;

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
