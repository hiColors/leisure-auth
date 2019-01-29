package com.github.life.lab.leisure.member.application.service.impl;

import com.github.life.lab.leisure.common.model.expression.ColorsExpression;
import com.github.life.lab.leisure.common.utils.ColorsBeanUtils;
import com.github.life.lab.leisure.member.application.entity.EMember;
import com.github.life.lab.leisure.member.application.entity.EMemberDetail;
import com.github.life.lab.leisure.member.application.entity.value.EMemberDefaultValue;
import com.github.life.lab.leisure.member.application.repository.EMemberDetailRepository;
import com.github.life.lab.leisure.member.application.repository.EMemberRepository;
import com.github.life.lab.leisure.member.application.service.MemberService;
import com.github.life.lab.leisure.member.application.service.PlatformService;
import com.github.life.lab.leisure.member.application.transfer.EntityTransferUtils;
import com.github.life.lab.leisure.member.authorization.token.impl.MemberAuthorization;
import com.github.life.lab.leisure.member.model.exception.EnumLeisureMemberCodeMessage;
import com.github.life.lab.leisure.member.model.exception.LeisureMemberException;
import com.github.life.lab.leisure.member.model.resource.member.*;
import com.github.life.lab.leisure.member.model.resource.platform.Platform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * MemberServiceImpl
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2019-01-20
 */
@Service
public class MemberServiceImpl implements MemberService {

    private final EMemberRepository memberRepository;

    private final EMemberDetailRepository memberDetailRepository;

    @Autowired
    private PlatformService platformService;

    @Autowired
    public MemberServiceImpl(EMemberDetailRepository memberDetailRepository, EMemberRepository memberRepository) {
        this.memberDetailRepository = memberDetailRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Member signUp(MemberSignUpModel model) {
        checkMobile(model.getMobile(), null);
        //根据手机号生成默认 EMember 对象
        EMember eMember = EMemberDefaultValue.generatorDefaultEMemberByMobile(model.getMobile());
        memberRepository.save(eMember);
        //根据 EMember 生成默认 EMemberDetail 对象
        EMemberDetail eMemberDetail = EMemberDefaultValue.generatorDefaultEMemberDetailByEMember(eMember);
        memberDetailRepository.save(eMemberDetail);
        //初次插入未关联对象
        eMember.setMemberDetail(eMemberDetail);
        return EntityTransferUtils.transferEMember(eMember);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Member modifyUsername(Long id, MemberUsernameModel model) {
        checkUsername(model.getUsername(), id);
        int i = memberRepository.updateUsernameById(id, model.getUsername());
        if (i != 1) {
            throw new LeisureMemberException(EnumLeisureMemberCodeMessage.MEMBER_MODIFY_FAIL);
        }
        return queryOneById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Member modify(Long id, MemberPatchModel model) {
        EMember eMember = getById(id);
        if (Objects.isNull(eMember)) {
            throw new LeisureMemberException(EnumLeisureMemberCodeMessage.MEMBER_NON_EXIST);
        }
        ColorsBeanUtils.copyPropertiesNonNull(model, eMember);
        ColorsBeanUtils.copyPropertiesNonNull(model, eMember.getMemberDetail());
        memberRepository.saveAndFlush(eMember);
        memberDetailRepository.saveAndFlush(eMember.getMemberDetail());
        return queryOneById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Member modifyMobile(Long id, MemberMobileModel model) {
        checkMobile(model.getMobile(), id);
        int i = memberRepository.updateMobileById(id, model.getMobile());
        if (i != 1) {
            throw new LeisureMemberException(EnumLeisureMemberCodeMessage.MEMBER_MODIFY_FAIL);
        }
        return queryOneById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Member modifyEmail(Long id, MemberEmailModel model) {
        checkEmail(model.getEmail(), id);
        int i = memberRepository.updateEmailById(id, model.getEmail());
        if (i != 1) {
            throw new LeisureMemberException(EnumLeisureMemberCodeMessage.MEMBER_MODIFY_FAIL);
        }
        return queryOneById(id);
    }

    @Override
    public Member queryOneById(Long id) {
        return EntityTransferUtils.transferEMember(getById(id));
    }

    @Override
    public Member queryOneByMobile(String mobile) {
        return EntityTransferUtils.transferEMember(memberRepository.findByMobile(mobile));
    }

    @Override
    public Member queryOneByEmail(String email) {
        return EntityTransferUtils.transferEMember(memberRepository.findByEmail(email));
    }

    @Override
    public Member queryOneByUsername(String username) {
        return EntityTransferUtils.transferEMember(memberRepository.findByUsername(username));
    }


    @Override
    public MemberAuthorization queryMemberAuthorization(Long id) {
        return null;
    }

    @Override
    public List<Platform> queryPlatformByMemberId(Long id) {
        return platformService.findPlatformByMemberId(id);
    }

    @Override
    public Member queryOne(String key, String keyType) {
        switch (keyType.toLowerCase()) {
            case "id":
                return queryOneById(Long.valueOf(key));
            case "username":
                return queryOneByUsername(key);
            case "mobile":
                return queryOneByMobile(key);
            case "email":
                return queryOneByEmail(key);
            default:
                throw new LeisureMemberException(EnumLeisureMemberCodeMessage.MEMBER_QUERY_NON_SUPPORT);
        }
    }

    @Override
    public Page<Member> paging(Pageable page, List<ColorsExpression> filters) {
        return memberRepository.findPage(page, filters).map(EntityTransferUtils::transferEMember);
    }

    @Override
    public void checkMobile(String mobile, Long id) {
        EMember eMember = memberRepository.findByMobile(mobile);
        if (Objects.nonNull(eMember) && !eMember.getId().equals(id)) {
            throw new LeisureMemberException(EnumLeisureMemberCodeMessage.MEMBER_MOBILE_EXIST);
        }
    }

    @Override
    public void checkUsername(String username, Long id) {
        EMember eMember = memberRepository.findByUsername(username);
        if (Objects.nonNull(eMember) && !eMember.getId().equals(id)) {
            throw new LeisureMemberException(EnumLeisureMemberCodeMessage.MEMBER_USERNAME_EXIST);
        }
    }

    @Override
    public void checkEmail(String email, Long id) {
        EMember eMember = memberRepository.findByEmail(email);
        if (Objects.nonNull(eMember) && !eMember.getId().equals(id)) {
            throw new LeisureMemberException(EnumLeisureMemberCodeMessage.MEMBER_EMAIL_EXIST);
        }
    }

    private EMember getById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

}