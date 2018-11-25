package com.github.life.lab.leisure.member.application.repository;

import com.github.life.lab.leisure.common.jpa.customiz.repository.ColorsRepository;
import com.github.life.lab.leisure.member.model.persistence.Platform;
import com.github.life.lab.leisure.member.model.persistence.PlatformMember;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * OrganizationRepository
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/2
 */
@Repository
public interface PlatformMemberRepository extends ColorsRepository<PlatformMember, Long> {

    @Query("select platform from PlatformMember where member_id = :memberId")
    List<Platform> findPlatformByMemberId(@Param("memberId") Long memberId);

}