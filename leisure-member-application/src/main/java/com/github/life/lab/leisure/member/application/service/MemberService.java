package com.github.life.lab.leisure.member.application.service;

import com.github.life.lab.leisure.member.authorization.token.impl.MemberAuthorization;
import com.github.life.lab.leisure.member.model.resource.member.*;
import com.github.life.lab.leisure.member.model.resource.platform.Platform;

import java.util.List;

/**
 * MemberService
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2019-01-20
 */
public interface MemberService {
    /**
     * 人员 - 注册
     *
     * @param model 对应模型
     * @return 人员基础信息
     */
    Member signUp(MemberSignUpModel model);

    /**
     * 人员 - 修改用户名
     *
     * @param id    人员 id
     * @param model 对应模型
     * @return 人员基础信息
     */
    Member modifyUsername(Long id, MemberUsernameModel model);

    /**
     * 人员 - 修改信息
     *
     * @param id    人员 id
     * @param model 对应模型
     * @return 人员基础信息
     */
    Member modify(Long id, MemberPatchModel model);

    /**
     * 人员 - 修改绑定手机号信息
     *
     * @param id    人员 id
     * @param model 对应模型
     * @return 人员基础信息
     */
    Member modifyMobile(Long id, MemberMobileModel model);

    /**
     * 人员 - 修改绑定邮箱信息
     *
     * @param id    人员 id
     * @param model 对应模型
     * @return 人员基础信息
     */
    Member modifyEmail(Long id, MemberEmailModel model);

    /**
     * 人员 - 获取人员信息通过 id
     *
     * @param id 人员 id
     * @return 人员基础信息
     */
    Member queryOneById(Long id);

    /**
     * 人员 - 获取人员信息通过 mobile
     *
     * @param mobile
     * @return 人员基础信息
     */
    Member queryOneByMobile(String mobile);

    /**
     * 人员 - 获取人员信息通过 email
     *
     * @param email
     * @return 人员基础信息
     */
    Member queryOneByEmail(String email);

    /**
     * 人员 - 获取人员信息通过 uniquekey（包含用户名，手机号，邮箱） 和 password
     *
     * @param uniqueKey 用户唯一标识 （包含用户名，手机号，邮箱）
     * @param password  用户密码
     * @return 人员基础信息
     */
    Member queryOneByUniqueKeyAndPassword(String uniqueKey, String password);

    /**
     * 人员 - 获取人员所有的授权信息
     *
     * @param id 人员 id
     * @return 人员基础信息
     */
    MemberAuthorization queryMemberAuthorization(Long id);

    /**
     * 人员 - 获取人员所属的平台信息
     *
     * @param id 人员 id
     * @return 人员基础信息
     */
    List<Platform> queryPlatformByMemberId(Long id);

    Member queryOne(String key, String keyType);
}