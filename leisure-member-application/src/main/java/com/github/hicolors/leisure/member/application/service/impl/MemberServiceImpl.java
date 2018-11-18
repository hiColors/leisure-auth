package com.github.hicolors.leisure.member.application.service.impl;

import com.github.hicolors.leisure.common.model.expression.ColorsExpression;
import com.github.hicolors.leisure.common.utils.ColorsBeanUtils;
import com.github.hicolors.leisure.member.application.exception.EnumMemberServerCodeMessage;
import com.github.hicolors.leisure.member.application.exception.MemberServerException;
import com.github.hicolors.leisure.member.application.repository.MemberDetailRepository;
import com.github.hicolors.leisure.member.application.repository.MemberRepository;
import com.github.hicolors.leisure.member.application.repository.MemberRoleRepository;
import com.github.hicolors.leisure.member.application.repository.PlatformMemberRoleRepository;
import com.github.hicolors.leisure.member.application.service.MemberService;
import com.github.hicolors.leisure.member.authorization.token.impl.MemberAuthorization;
import com.github.hicolors.leisure.member.model.model.member.*;
import com.github.hicolors.leisure.member.model.persistence.*;
import com.github.hicolors.leisure.member.model.persistence.value.MemberDefaultValue;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.*;

/**
 * MemberServiceImpl
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/11/3
 */

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberDetailRepository memberDetailRepository;

    @Autowired
    private CheckService checkService;

    @Autowired
    private MemberRoleRepository memberRoleRepository;

    @Autowired
    private PlatformMemberRoleRepository platformMemberRoleRepository;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Member signUp(MemberSignUpModel model) {
        checkService.checkMobile(model.getMobile(), null);

        Member member = new Member();
        MemberDetail memberDetail = new MemberDetail();
        member.setUsername(MemberDefaultValue.generatorUserName());
        member.setCredentialsExpiredDate(MemberDefaultValue.generatorDefaultExpiredDate());
        member.setEnabled(true);
        member.setExpiredDate(MemberDefaultValue.generatorDefaultExpiredDate());
        member.setLockStatus(false);
        member.setNickName(MemberDefaultValue.generatorNickName());
        member.setPassword(model.getMobile());
        memberRepository.save(member);

        memberDetail.setId(member.getId());
        memberDetail.setMobile(model.getMobile());
        memberDetail.setEmail(MemberDefaultValue.generatorEmail());
        memberDetail.setName(MemberDefaultValue.NAME);
        memberDetail.setAvatar(MemberDefaultValue.AVATAR);
        memberDetail.setBirthday(MemberDefaultValue.BIRTHDAY);
        memberDetail.setDescription(MemberDefaultValue.DESCRIPTION);
        memberDetail.setWebsite(MemberDefaultValue.WEBSITE);
        memberDetailRepository.save(memberDetail);

        member.setMemberDetail(memberDetail);
        return member;
    }

    @Override
    public Member modifyUsername(Member member, MemberUsernameModel model) {
        checkService.checkUsername(model.getUsername(), member.getId());
        member.setUsername(model.getUsername());
        return memberRepository.saveAndFlush(member);
    }

    @Override
    public Member modify(Member member, MemberPatchModel model) {
        ColorsBeanUtils.copyPropertiesNonNull(model, member);
        ColorsBeanUtils.copyPropertiesNonNull(model, member.getMemberDetail());
        memberDetailRepository.saveAndFlush(member.getMemberDetail());
        memberRepository.saveAndFlush(member);
        return member;
    }

    @Override
    public Member modifyMobile(Member member, MemberMobileModel model) {
        checkService.checkMobile(model.getMobile(), member.getId());
        member.getMemberDetail().setMobile(model.getMobile());
        memberDetailRepository.save(member.getMemberDetail());
        return member;
    }

    @Override
    public Member modifyEmail(Member member, MemberEmailModel model) {
        checkService.checkEmail(model.getEmail(), member.getId());
        member.getMemberDetail().setEmail(model.getEmail());
        memberDetailRepository.save(member.getMemberDetail());
        return member;
    }

    @Override
    public Page<Member> query(Pageable pageable, List<ColorsExpression> filters) {
        return memberRepository.findPage(pageable, filters);
    }

    @Override
    public Member queryOneById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    @Override
    public Member queryOneByMobile(String mobile) {
        MemberDetail md = memberDetailRepository.findByMobile(mobile);
        if (Objects.isNull(md)) {
            throw new MemberServerException(
                    EnumMemberServerCodeMessage.MEMBER_UNIQUE_KEY_NON_EXIST,
                    MessageFormat.format(EnumMemberServerCodeMessage.MEMBER_UNIQUE_KEY_NON_EXIST.getMessage(), mobile));
        }
        return queryOneById(md.getId());
    }

    @Override
    public Member queryOneByEmail(String email) {
        MemberDetail md = memberDetailRepository.findByEmail(email);
        if (Objects.isNull(md)) {
            throw new MemberServerException(
                    EnumMemberServerCodeMessage.MEMBER_UNIQUE_KEY_NON_EXIST,
                    MessageFormat.format(EnumMemberServerCodeMessage.MEMBER_UNIQUE_KEY_NON_EXIST.getMessage(), email));
        }
        return queryOneById(md.getId());
    }

    @Override
    public Member queryOneByUniqueKeyAndPassword(String username, String password) {
        Member member = memberRepository.findByUsernameAndPassword(username, password);
        if (Objects.isNull(member)) {
            throw new MemberServerException(EnumMemberServerCodeMessage.MEMBER_USERNAME_PASSWORD_NON_EXIST);
        }
        return member;
    }

    @Override
    public MemberAuthorization queryMemberAuthorization(Member member) {

        MemberAuthorization memberAuthorization = new MemberAuthorization();
        memberAuthorization.setId(member.getId());
        memberAuthorization.setNickName(member.getNickName());
        if(Objects.nonNull(member.getMemberDetail().getPlatform())){
            memberAuthorization.setPlatformId(member.getMemberDetail().getPlatform().getId());
            memberAuthorization.setPlatformName(member.getMemberDetail().getPlatform().getName());
        }

        //用户的权限
        List<String> memberRoles = new ArrayList<>();
        List<MemberRole> memberRoleList = memberRoleRepository.findByMemberId(member.getId());
        if (CollectionUtils.isNotEmpty(memberRoleList)) {
            memberRoleList.forEach(e -> memberRoles.add(e.getRole().getName()));
        }
        memberAuthorization.setMemberRoles(memberRoles);

        //处理用户在平台的权限
        List<PlatformMemberRole> platformMemberRoleList = platformMemberRoleRepository.findByPlatformMemberMemberId(member.getId());
        Map<Long, List<String>> platformRoleMap = new HashMap<>();
        platformMemberRoleList.parallelStream().forEach(e -> platformRoleMap.compute(e.getPlatformMember().getPlatform().getId(), (item, values) -> {
            if (Objects.isNull(values)) {
                values = new ArrayList<>();
            }
            values.add(e.getRole().getName());
            return values;
        }));

        memberAuthorization.setPlatformRoles(platformRoleMap);
        return memberAuthorization;
    }

}
