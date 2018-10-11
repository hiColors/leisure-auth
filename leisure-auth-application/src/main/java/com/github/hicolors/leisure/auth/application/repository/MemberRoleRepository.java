package com.github.hicolors.leisure.auth.application.repository;

import com.github.hicolors.leisure.auth.model.persistence.MemberRole;
import com.github.hicolors.leisure.common.jpa.customiz.repository.ColorsRepository;
import org.springframework.stereotype.Repository;

/**
 * MemberRoleRepository
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/2
 */
@Repository
public interface MemberRoleRepository extends ColorsRepository<MemberRole, Long> {
}