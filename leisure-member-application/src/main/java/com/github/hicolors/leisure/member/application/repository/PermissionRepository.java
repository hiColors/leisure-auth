package com.github.hicolors.leisure.member.application.repository;

import com.github.hicolors.leisure.common.jpa.customiz.repository.ColorsRepository;
import com.github.hicolors.leisure.member.model.persistence.Permission;
import org.springframework.stereotype.Repository;

/**
 * RoleRepository
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/2
 */
@Repository
public interface PermissionRepository extends ColorsRepository<Permission, Long> {

    Permission findByName(String name);

    Permission findByAntPathAndStrategy(String antPath, Boolean strategy);
}