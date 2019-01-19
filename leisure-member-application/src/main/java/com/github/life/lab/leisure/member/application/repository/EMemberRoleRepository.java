package com.github.life.lab.leisure.member.application.repository;

import com.github.life.lab.leisure.common.jpa.customiz.repository.ColorsRepository;
import com.github.life.lab.leisure.member.application.entity.EMemberRole;
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

}