package com.github.life.lab.leisure.member.application.repository;

import com.github.life.lab.leisure.member.application.entity.EPlatformMemberRole;
import com.github.lifelab.leisure.common.jpa.customiz.repository.ColorsRepository;
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
     * 通过 platformMemberId 去查询 PlatformMemberRole
     * <p>
     * 一个员工可能拥有多种角色 故返回值为list
     *
     * @param platformMemberId 员工 id
     * @return 员工角色集合
     */
    List<EPlatformMemberRole> findByPlatformMemberId(Long platformMemberId);


    /**
     * 判断是否有员工赋值了指定角色
     *
     * @param roleId 角色 id
     * @return true or else
     */
    boolean existsByRoleId(Long roleId);
}