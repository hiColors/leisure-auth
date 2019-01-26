package com.github.life.lab.leisure.member.application.entity.value;

import com.github.life.lab.leisure.common.utils.JsonUtils;
import com.github.life.lab.leisure.member.application.entity.EMember;
import com.github.life.lab.leisure.member.application.entity.EMemberDetail;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.MessageFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.UUID;

/**
 * MemberDefaultValue
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/11/3
 */
@Slf4j
public class EMemberDefaultValue {

    private static final String NAME = "";

    private static final Date BIRTHDAY = new Date();

    private static final String DESCRIPTION = "";

    private static final String WEBSITE = "";

    private static final String AVATAR = "";

    private static final String PASSWORD = "000000";

    private static final String DEFAULT_EXPIRED_DATE = "9999-12-31 23:59:59";

    private static final String EMAIL_PREFIX = "l_email_{0}";

    private static final String NICKNAME_PREFIX = "l_{0}";

    private static String generatorUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    private static String generatorString(Integer length) {
        return RandomStringUtils.randomAscii(length);
    }

    private static Date generatorDefaultExpiredDate() {
        try {
            return DateUtils.parseDate(DEFAULT_EXPIRED_DATE, "yyyy-MM-dd HH:mm:ss");
        } catch (ParseException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static String generatorDefaultNickName(String mobile) {
        return MessageFormat.format(NICKNAME_PREFIX, mobile);
    }

    private static String generatorDefaultUserName() {
        return generatorUUID();
    }

    private static String generatorDefaultEmail() {
        return MessageFormat.format(EMAIL_PREFIX, generatorUUID());
    }

    public static EMember generatorDefaultEMemberByMobile(String mobile) {
        EMember eMember = new EMember();
        eMember.setMobile(mobile);
        eMember.setEmail(EMemberDefaultValue.generatorDefaultEmail());
        eMember.setUsername(EMemberDefaultValue.generatorDefaultUserName());
        eMember.setPassword(EMemberDefaultValue.PASSWORD);
        eMember.setCredentialsExpiredDate(EMemberDefaultValue.generatorDefaultExpiredDate());
        eMember.setEnabled(true);
        eMember.setExpiredDate(eMember.getCredentialsExpiredDate());
        eMember.setLockStatus(false);
        log.info("generator default emember,value : [{}]", JsonUtils.serialize(eMember));
        return eMember;
    }

    public static EMemberDetail generatorDefaultEMemberDetailByEMember(EMember eMember) {
        EMemberDetail eMemberDetail = new EMemberDetail();
        eMemberDetail.setName(eMember.getMobile());
        eMemberDetail.setBirthday(new Date());
        eMemberDetail.setNickName(EMemberDefaultValue.generatorDefaultNickName(eMember.getMobile()));
        eMemberDetail.setDescription(EMemberDefaultValue.DESCRIPTION);
        eMemberDetail.setAvatar(EMemberDefaultValue.AVATAR);
        eMemberDetail.setWebsite(EMemberDefaultValue.WEBSITE);
        eMemberDetail.setId(eMember.getId());
        return eMemberDetail;
    }

}
