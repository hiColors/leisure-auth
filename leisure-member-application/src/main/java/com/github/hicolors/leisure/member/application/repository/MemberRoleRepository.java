package com.github.hicolors.leisure.member.application.repository;

import com.github.hicolors.leisure.common.jpa.customiz.repository.ColorsRepository;
import com.github.hicolors.leisure.member.model.persistence.MemberRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MemberRoleRepository
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/2
 */
@Repository
public interface MemberRoleRepository extends ColorsRepository<MemberRole, Long> {

    /**
     * 通过 member id  获取 memberrole的数据集合
     * @param memberId
     * @return
     */
    List<MemberRole> findAllByMemberAndId(Long  memberId );

}