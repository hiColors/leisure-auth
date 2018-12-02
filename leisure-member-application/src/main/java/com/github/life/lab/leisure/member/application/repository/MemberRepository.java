package com.github.life.lab.leisure.member.application.repository;

import com.github.life.lab.leisure.common.jpa.customiz.repository.ColorsRepository;
import com.github.life.lab.leisure.member.model.persistence.Member;
import org.springframework.stereotype.Repository;

/**
 * MemberRepository
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/2
 */
@Repository
public interface MemberRepository extends ColorsRepository<Member, Long> {

    Member findByUsername(String username);
//TODO 密码加密了，通过用户民和密码查不太好吧
    Member findByUsernameAndPassword(String username, String password);

}