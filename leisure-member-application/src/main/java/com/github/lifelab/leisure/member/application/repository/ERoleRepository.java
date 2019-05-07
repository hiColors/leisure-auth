package com.github.lifelab.leisure.member.application.repository;

import com.github.lifelab.leisure.common.jpa.customiz.repository.ColorsRepository;
import com.github.lifelab.leisure.member.application.entity.ERole;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * RoleRepository
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2018/10/2
 */
@Repository
public interface ERoleRepository extends ColorsRepository<ERole, Long> {

    /**
     * 通过 名称 查询
     *
     * @param name 名称
     * @return 角色信息
     */
    ERole findByName(String name);

    /**
     * 通过 唯一标识码 查询
     *
     * @param code 唯一标识码
     * @return 角色信息
     */
    ERole findByCode(String code);

    /**
     * 判断是否存在
     * 此处 jpa 会解析 sql 为
     * <p>
     * select id from role where code = :code limit 1，如果 id 返回则true, 反之 false
     *
     * @param code 唯一标识码
     * @return 结果
     */
    Boolean existsByCode(String code);

    /**
     * 判断是否存在
     *
     * @param name 名称
     * @return 结果
     */
    Boolean existsByName(String name);

    /**
     * 通过主键删除
     *
     * @param id 主键
     * @return 影响条数
     */
    @Modifying
    @Query("DELETE FROM ERole WHERE id = :id")
    int deleteByPrimaryKey(@Param("id") Long id);
}