package com.github.life.lab.leisure.member.application.repository;

import com.github.life.lab.leisure.common.jpa.customiz.repository.ColorsRepository;
import com.github.life.lab.leisure.member.application.entity.EMember;
import com.github.life.lab.leisure.member.application.entity.EMemberDetail;
import org.springframework.stereotype.Repository;


/**
 * EMemberRepository
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2018/10/2
 */
@Repository
public interface EMemberRepository extends ColorsRepository<EMember, Long> {

    /**
     * 通过用户名查询用户简要信息
     *
     * @param username 用户名
     * @return 用户简要信息
     */
    EMember findByUsername(String username);

    /**
     * 通过用户名和密码查询用户简要信息
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户简要信息
     */
    EMember findByUsernameAndPassword(String username, String password);

    /**
     * 通过手机号查询用户信息
     *
     * @param mobile 手机号
     * @return 用户详细信息 entity
     */
    EMember findByMobile(String mobile);


    /**
     * 通过邮箱查询用户信息
     *
     * @param email 邮箱
     * @return 用户详细信息 entity
     */
    EMember findByEmail(String email);


}