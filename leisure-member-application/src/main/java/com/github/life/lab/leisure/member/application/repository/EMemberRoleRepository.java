package com.github.life.lab.leisure.member.application.repository;

import com.github.life.lab.leisure.member.application.entity.EMemberRole;
import com.github.lifelab.leisure.common.jpa.customiz.repository.ColorsRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MemberRoleRepository
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2018/10/2
 */
@Repository
public interface EMemberRoleRepository extends ColorsRepository<EMemberRole, Long> {

    /**
     * 通过 member id  获取 memberRole的数据集合
     *
     * @param memberId 用户 id
     * @return 用户角色集合
     */
    List<EMemberRole> findByMemberId(Long memberId);

    /**
     * 判断是否有员工赋值了指定角色
     *
     * @param roleId 角色 id
     * @return true or else
     */
    boolean existsByRoleId(Long roleId);

}