package com.github.life.lab.leisure.member.application.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.life.lab.leisure.common.jpa.customiz.model.BaseJpaModel;
import lombok.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Table;
import java.util.Date;

/**
 * 成员详细信息
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2018/10/10
 */
@Entity
@Table(name = "member_detail")
@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "delete_flag = 0")
@ToString(of = {"id", "nickName", "name", "birthday"})
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class EMemberDetail extends BaseJpaModel {

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
    @JoinColumn(name = "default_platform_id", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    @JsonIgnoreProperties("organizations")
    @NotFound(action = NotFoundAction.IGNORE)
    private EPlatform platform;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;

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