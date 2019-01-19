package com.github.life.lab.leisure.member.application.repository;


import com.github.life.lab.leisure.common.jpa.customiz.repository.ColorsRepository;
import com.github.life.lab.leisure.member.application.entity.EPermission;
import org.springframework.stereotype.Repository;

/**
 * RoleRepository
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2018/10/2
 */
@Repository
public interface EPermissionRepository extends ColorsRepository<EPermission, Long> {

    /**
     * 通过名称查权限信息
     *
     * @param name 名称
     * @return 权限信息
     */
    EPermission findByName(String name);

    /**
     * 通过路径和策略查询权限信息
     *
     * @param antPath  路径
     * @param strategy 策略
     * @return 权限信息
     */
    EPermission findByAntPathAndStrategy(String antPath, Boolean strategy);
}