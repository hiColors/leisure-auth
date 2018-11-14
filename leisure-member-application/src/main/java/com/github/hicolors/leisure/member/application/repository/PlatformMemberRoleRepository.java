package com.github.hicolors.leisure.member.application.repository;

import com.github.hicolors.leisure.common.jpa.customiz.repository.ColorsRepository;
import com.github.hicolors.leisure.member.model.persistence.PlatformMemberRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * OrganizationRepository
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/2
 */
@Repository
public interface PlatformMemberRoleRepository extends ColorsRepository<PlatformMemberRole, Long> {

    /**
     * 通过 memberId 去查询 platformaemberrole  设想一个员工可能属于多个平台 故返回值为list
     * @param memberId
     * @return
     */
    List<PlatformMemberRole> findAllByPlatformMemberAndId(Long memberId) ;
}