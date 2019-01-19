package com.github.life.lab.leisure.member.application.repository;

import com.github.life.lab.leisure.common.jpa.customiz.repository.ColorsRepository;
import com.github.life.lab.leisure.member.application.entity.EPlatformMemberRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * OrganizationRepository
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2018/10/2
 */
@Repository
public interface EPlatformMemberRoleRepository extends ColorsRepository<EPlatformMemberRole, Long> {

    /**
     * 通过 memberId 去查询 PlatformMemberRole
     * <p>
     * 设想一个员工可能属于多个平台 故返回值为list
     * TODO 这里应该通过platformMemberId去查
     *
     * @param memberId
     * @return
     */
    List<EPlatformMemberRole> findByPlatformMemberMemberId(Long memberId);
}