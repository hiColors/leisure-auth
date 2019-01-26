package com.github.life.lab.leisure.member.application.service;

import com.github.life.lab.leisure.common.model.expression.ColorsExpression;
import com.github.life.lab.leisure.member.authorization.token.impl.MemberAuthorization;
import com.github.life.lab.leisure.member.model.resource.member.*;
import com.github.life.lab.leisure.member.model.resource.platform.Platform;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
     * 人员 - 获取人员信息通过 手机号
     *
     * @param mobile 手机号
     * @return 人员基础信息
     */
    Member queryOneByMobile(String mobile);

    /**
     * 人员 - 获取人员信息通过 邮箱
     *
     * @param email 邮箱
     * @return 人员基础信息
     */
    Member queryOneByEmail(String email);

    /**
     * 人员 - 获取人员信息通过 用户名
     *
     * @param username 用户名
     * @return 人员基础信息
     */
    Member queryOneByUsername(String username);

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

    /**
     * 人员 - 获取人员信息通过指定方式
     *
     * @param key     唯一键值
     * @param keyType 唯一键值的类型（当前支持 【id - 主键，默认值】;【username - 用户名;【mobile - 手机号】;【email - 邮箱】 ）
     * @return 人员基础信息
     */
    Member queryOne(String key, String keyType);

    /**
     * 人员 - 分页筛选 根据指定条件
     *
     * @param page    分页对象
     * @param filters 指定条件表达式
     * @return 分页结果
     */
    Page<Member> paging(Pageable page, List<ColorsExpression> filters);

    /**
     * 检查手机号指定账户是否可用
     *
     * @param mobile 手机号
     * @param id     指定人员 id
     */
    void checkMobile(String mobile, Long id);

    /**
     * 检查用户名指定账户是否可用
     *
     * @param username 用户名
     * @param id       指定人员 id
     */
    void checkUsername(String username, Long id);

    /**
     * 检查邮箱指定账户是否可用
     *
     * @param email 邮箱
     * @param id    指定人员 id
     */
    void checkEmail(String email, Long id);

}