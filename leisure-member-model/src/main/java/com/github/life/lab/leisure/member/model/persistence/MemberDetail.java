package com.github.life.lab.leisure.member.model.persistence;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.life.lab.leisure.common.model.BaseJpaModel;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;

/**
 * 成员详细信息
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/10
 */
@Entity
@Table(name = "member_detail")
@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "delete_flag = 0")
@ToString(of = {"id", "email", "mobile", "name"})
public class MemberDetail extends BaseJpaModel {

    /**
     * 主键
     */

    @Column(name = "id")
    @Id
    @GeneratedValue(generator = "assigned")
    @GenericGenerator(name = "assigned", strategy = "assigned")
    private Long id;

    /**
     * 主平台 id
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "primary_platform_id", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    @JsonIgnoreProperties("organizations")
    @NotFound(action = NotFoundAction.IGNORE)
    private Platform platform;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 姓名
     */
    private String name;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 描述
     */
    private String description;

    /**
     * 主页
     */
    private String website;

    /**
     * 头像
     */
    private String avatar;
}