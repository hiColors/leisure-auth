package com.github.lifelab.leisure.member.application.repository;

import com.github.lifelab.leisure.common.jpa.customiz.repository.ColorsRepository;
import com.github.lifelab.leisure.member.application.entity.EMember;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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


    /**
     * 修改用户用户名
     *
     * @param id       主键
     * @param username 用户名
     * @return 影响行数
     */
    @Query("update EMember set username = :username where id = :id")
    @Modifying
    int updateUsernameById(@Param("id") Long id, @Param("username") String username);

    /**
     * 修改用户手机号
     *
     * @param id     主键
     * @param mobile 用户名
     * @return 影响行数
     */
    @Query("update EMember set mobile = :mobile where id = :id")
    @Modifying
    int updateMobileById(@Param("id") Long id, @Param("mobile") String mobile);

    /**
     * 修改用户邮箱
     *
     * @param id    主键
     * @param email 邮箱
     * @return 影响行数
     */
    @Query("update EMember set email = :email where id = :id")
    @Modifying
    int updateEmailById(@Param("id") Long id, @Param("email") String email);


}