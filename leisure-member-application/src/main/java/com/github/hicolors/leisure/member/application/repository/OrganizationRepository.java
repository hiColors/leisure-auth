package com.github.hicolors.leisure.member.application.repository;

import com.github.hicolors.leisure.member.model.persistence.Organization;
import com.github.hicolors.leisure.common.jpa.customiz.repository.ColorsRepository;
import org.springframework.stereotype.Repository;

/**
 * OrganizationRepository
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/2
 */
@Repository
public interface OrganizationRepository extends ColorsRepository<Organization, Long> {
}