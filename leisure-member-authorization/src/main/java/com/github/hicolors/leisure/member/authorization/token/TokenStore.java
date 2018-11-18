package com.github.hicolors.leisure.member.authorization.token;

import com.github.hicolors.leisure.member.authorization.token.impl.AuthToken;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * token 接口规范
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/11/16
 */
public interface TokenStore {

    String USER_INFO_PREFIX = "auth:info:user:";

    String USER_ACCESS_TOKEN_PREFIX = "auth:access-token:user:";

    String USER_REFRESH_TOKEN_PREFIX = "auth:refresh-token:user:";

    String ACCESS_TOKEN_PREFIX = "auth:access-token:";

    String REFRESH_TOKEN_PREFIX = "auth:refresh-token:";

    String storeRefreshToken(UserInfo userInfo);

    AuthToken storeAccessToken(UserInfo member);

    void storeUserInfo(UserInfo userInfo);

    void clearToken(Long id);

    Long findUserIdByAccessToken(String accessToken);

    Long findUserIdByRefreshToken(String accessToken);

    String findUserInfoByUserId(Long userId);

    String encode(Long id);

    default String generateUserInfoKey(Long id) {
        return USER_INFO_PREFIX + id;
    }

    default String generateUserAccessTokenKey(Long id) {
        return USER_ACCESS_TOKEN_PREFIX + id;
    }

    default String generateUserRefreshTokenKey(Long id) {
        return USER_REFRESH_TOKEN_PREFIX + id;
    }

    default String generateAccessTokenKey(String accessToken) {
        return ACCESS_TOKEN_PREFIX + accessToken;
    }

    default String generateRefreshTokenKey(String refreshToken) {
        return REFRESH_TOKEN_PREFIX + refreshToken;
    }

    default String randomStringByUserId(Long userId) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
            //hash加密
            String code = encode(userId);
            byte[] bytes = digest.digest(code.getBytes(StandardCharsets.UTF_8));
            return String.format("%032x", new BigInteger(1, bytes));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("MD5 algorithm not available.  Fatal (should be in the JDK).", e);
        }
    }
}
