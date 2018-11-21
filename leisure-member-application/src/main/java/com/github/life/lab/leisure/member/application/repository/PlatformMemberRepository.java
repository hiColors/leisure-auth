package com.github.life.lab.leisure.member.application.repository;

import com.github.life.lab.leisure.common.jpa.customiz.repository.ColorsRepository;
import com.github.life.lab.leisure.member.model.persistence.PlatformMember;
import org.springframework.stereotype.Repository;

/**
 * OrganizationRepository
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/2
 */
@Repository
public interface PlatformMemberRepository extends ColorsRepository<PlatformMember, Long> {
}