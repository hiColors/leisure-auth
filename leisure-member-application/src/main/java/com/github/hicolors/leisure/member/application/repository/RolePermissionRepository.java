package com.github.hicolors.leisure.member.application.repository;

import com.github.hicolors.leisure.common.jpa.customiz.repository.ColorsRepository;
import com.github.hicolors.leisure.member.model.persistence.RolePermission;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * RolePermissionRepository
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/2
 */
@Repository
public interface RolePermissionRepository extends ColorsRepository<RolePermission, Long> {

    RolePermission findByRoleIdAndPermissionId(Long roleId,Long permissionId);

    @Query(value = "delete from RolePermission where role.id = :role_id")
    @Modifying
    Integer deleteByRoleId(@Param("role_id") Long roleId);

    @Query(value = "delete from RolePermission where permission.id = :permission_id")
    @Modifying
    Integer deleteByPermissionId(@Param("permission_id") Long permissionId);

    @Query(value = "delete from RolePermission where role.id = :role_id and permission.id = :permission_id")
    @Modifying
    Integer deleteByRoleIdAndPermissionId(@Param("role_id") Long roleId, @Param("permission_id") Long permissionId);
}