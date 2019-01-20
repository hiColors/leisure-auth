package com.github.life.lab.leisure.member.application.repository;

import com.github.life.lab.leisure.common.jpa.customiz.repository.ColorsRepository;
import com.github.life.lab.leisure.member.application.entity.ERole;
import com.github.life.lab.leisure.member.model.resource.role.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * RoleRepository
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2018/10/2
 */
@Repository
public interface ERoleRepository extends ColorsRepository<ERole, Long> {

    ERole findByName(String name);
}