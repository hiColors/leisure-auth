package com.github.life.lab.leisure.member.application.rest;

import com.github.life.lab.leisure.common.framework.utils.SpringContextUtils;
import com.github.life.lab.leisure.member.application.entity.EMemberDetail;
import com.github.life.lab.leisure.member.application.repository.EMemberDetailRepository;
import com.github.life.lab.leisure.member.authorization.token.impl.MemberAuthorization;
import com.github.life.lab.leisure.member.intf.MemberApi;
import com.github.life.lab.leisure.member.model.resource.member.*;
import com.github.life.lab.leisure.member.model.resource.platform.Platform;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * MemberRest
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/28
 */
@RestController
public class MemberRest implements MemberApi {

    @Override
    public Member signUp(MemberSignUpModel model) {
        return null;
    }

    @Override
    public Member modifyUsername(Long id, MemberUsernameModel model) {
        return null;
    }

    @Override
    public Member modify(Long id, MemberPatchModel model) {
        return null;
    }

    @Override
    public Member modifyMobile(Long id, MemberMobileModel model) {
        return null;
    }

    @Override
    public Member modifyEmail(Long id, MemberEmailModel model) {
        return null;
    }

    @Override
    public Member queryOneById(Long id) {
        return null;
    }

    @Override
    public Member queryOneByMobile(String mobile) {
        return null;
    }

    @Override
    public Member queryOneByEmail(String email) {
        return null;
    }

    @Override
    public Member queryOneByUniqueKeyAndPassword(String uniquekey, String password) {
        return null;
    }

    @Override
    public MemberAuthorization queryMemberAuthorization(Long id) {
        return null;
    }

    @Override
    public List<Platform> queryPlatformByMemberId(Long id) {
        return null;
    }

    @GetMapping("/xxxx")
    public EMemberDetail memberDetail(@RequestParam("id")Long id){
        return SpringContextUtils.getBeanByType(EMemberDetailRepository.class).getOne(id);
    }
}