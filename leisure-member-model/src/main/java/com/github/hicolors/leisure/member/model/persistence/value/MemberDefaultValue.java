package com.github.hicolors.leisure.member.model.persistence.value;

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
public class MemberDefaultValue {

    public static final String NAME = "";
    public static final Date BIRTHDAY = new Date();
    public static final String DESCRIPTION = "";
    public static final String WEBSITE = "";
    public static final String AVATAR = "";
    private static final String DEFAULT_EXPIRED_DATE = "9999-12-31 23:59:59";
    private static final String EMAIL_PREFIX = "leisure_member_{0}";
    private static final String NICKNAME_PREFIX = "Leisure-{0}";

    private static String generatorUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    private static String generatorString(Integer length) {
        return RandomStringUtils.randomAscii(length);
    }

    public static Date generatorDefaultExpiredDate() {
        try {
            return DateUtils.parseDate(DEFAULT_EXPIRED_DATE, "yyyy-MM-dd HH:mm:ss");
        } catch (ParseException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static String generatorNickName() {
        return MessageFormat.format(NICKNAME_PREFIX, generatorString(8));
    }

    public static String generatorUserName() {
        return generatorUUID();
    }

    public static String generatorEmail() {
        return MessageFormat.format(EMAIL_PREFIX, generatorUUID());
    }

}
