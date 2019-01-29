package com.github.life.lab.leisure.member.application.repository;

import com.github.life.lab.leisure.common.jpa.customiz.repository.ColorsRepository;
import com.github.life.lab.leisure.member.application.entity.EPlatformMember;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * OrganizationRepository
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2018/10/2
 */
@Repository
public interface EPlatformMemberRepository extends ColorsRepository<EPlatformMember, Long> {

    /**
     * 获取{x}用户所有的员工信息
     * 员工信息是指在和平台关联有记录
     *
     * @param memberId 用户 id
     * @return 用户所有的员工信息集合
     */
    @Query("from EPlatformMember where member_id = :memberId")
    List<EPlatformMember> findPlatformByMemberId(@Param("memberId") Long memberId);

    /**
     * 根据 员工 id 和 平台 id 判断是否存在
     *
     * @param pmid 员工 id
     * @param pid  平台 id
     * @return if exist true,else false
     */
    boolean existsByIdAndPlatformId(Long pmid, Long pid);

    /**
     * 根据 岗位 id 和 平台 id 判断是否存在
     *
     * @param jid 岗位 id
     * @param pid 平台 id
     * @return if exist true,else false
     */
    boolean existsByPlatformJobIdAndPlatformId(Long jid, Long pid);

    /**
     * 根据 组织 id 和 平台 id 判断是否存在
     *
     * @param oid 组织 id
     * @param pid 平台 id
     * @return if exist true,else false
     */
    boolean existsByPlatformOrganizationIdAndPlatformId(Long oid, Long pid);
}