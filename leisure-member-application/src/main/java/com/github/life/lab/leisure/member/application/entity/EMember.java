package com.github.life.lab.leisure.member.application.entity;

import com.github.life.lab.leisure.common.jpa.customiz.model.BaseJpaModel;
import com.github.life.lab.leisure.common.model.validator.ValidatorGroup;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.Date;

/**
 * 成员信息
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2018/10/2
 */
@Entity
@Table(name = "member")
@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "delete_flag = 0")
@ToString(of = {"id", "username", "enabled"})
public class EMember extends BaseJpaModel {

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
     * 用户名
     */
    @Column(name = "username", unique = true)
    private String username;

    /**
     * 邮箱
     */
    @Column(name = "email", unique = true)
    private String email;

    /**
     * 手机号
     */
    @Column(name = "mobile", unique = true)
    private String mobile;

    /**
     * 密码
     */
    private String password;

    /**
     * 启用状态[0:未启用;1:启用]
     */
    private Boolean enabled;

    /**
     * 锁定状态[0:未锁定;1:锁定]
     */
    @Column(name = "lock_status")
    private Boolean lockStatus;

    /**
     * 过期时间
     */
    @Column(name = "expired_date")
    private Date expiredDate;

    /**
     * 凭证过期时间
     */
    @Column(name = "credentials_expired_date")
    private Date credentialsExpiredDate;

    @OneToOne
    @JoinColumn(name = "id", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    private EMemberDetail memberDetail;
}