package com.github.life.lab.leisure.member.authorization.token.impl;

import com.github.life.lab.leisure.member.authorization.token.TokenStore;
import com.github.life.lab.leisure.member.authorization.token.UserInfo;
import com.github.lifelab.leisure.common.utils.JsonUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * RedisTokenStore
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/11/16
 */
public class RedisTokenStore implements TokenStore {

    /**
     * 最大登录设备
     */
    private static final Integer MAX_SIGN_IN_DEVICE = 10;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    /**
     * access token 过期时间
     */
    @Value("${auth.accessTokenValidateSeconds:86400}")
    private Long accessTokenValidateSeconds;
    /**
     * refresh token 过期时间
     */
    @Value("${auth.refreshTokenValidateSeconds:2592000}")
    private Long refreshTokenValidateSeconds;
    /**
     * refresh token 小于当前时间间隔时候自动生成
     */
    @Value("${auth.newRefreshTokenIntervalSeconds:604800}")
    private Long newRefreshTokenIntervalSeconds;
    /**
     * 生成时使用的加密密钥
     */
    @Value("${auth.secret:leisure-backend-gateway-application}")
    private String secret;

    /**
     * 生成一个新的 refresh token
     *
     * @param member
     * @return
     */
    @Override
    public String storeRefreshToken(UserInfo member) {
        //根据 userid 和 来源，获取 refresh token
        String refreshToken = stringRedisTemplate.opsForValue().get(generateUserRefreshTokenKey(member.getId()));
        //如果为空 生成一个
        if (StringUtils.isNotBlank((refreshToken))) {
            if (ObjectUtils.defaultIfNull(stringRedisTemplate.getExpire(generateRefreshTokenKey(refreshToken), TimeUnit.SECONDS), 0L) > newRefreshTokenIntervalSeconds) {
                return refreshToken;
            } else {
                //清除过期的 refresh token
                stringRedisTemplate.delete(generateRefreshTokenKey(refreshToken));
            }
        }
        //清除历史数据
        stringRedisTemplate.delete(generateUserRefreshTokenKey(member.getId()));

        //创建用户基础信息缓存
        storeUserInfo(member);

        //创建用户 refresh token 关联信息
        String userRefreshTokenKey = generateUserRefreshTokenKey(member.getId());
        refreshToken = randomStringByUserId(member.getId());
        stringRedisTemplate.opsForValue().set(userRefreshTokenKey, refreshToken, refreshTokenValidateSeconds, TimeUnit.SECONDS);

        //创建用户 refresh token
        stringRedisTemplate.opsForValue().set(generateRefreshTokenKey(refreshToken), String.valueOf(member.getId()), refreshTokenValidateSeconds, TimeUnit.SECONDS);
        return refreshToken;
    }

    @Override
    public AuthToken storeAccessToken(UserInfo member) {
        //创建用户 token
        AuthToken authToken = new AuthToken();
        String accessToken = randomStringByUserId(member.getId());
        authToken.setAccessToken(accessToken);
        authToken.setNickname(member.getNickName());
//        authToken.setPlatformId(member.getPlatformId());
//        authToken.setPlatformName(member.getPlatformName());
        authToken.setTokenExpires(accessTokenValidateSeconds);
        stringRedisTemplate.opsForValue().set(generateAccessTokenKey(accessToken), String.valueOf(member.getId()), accessTokenValidateSeconds, TimeUnit.SECONDS);
        //更新用户token信息列表
        String userAccessTokenKey = generateUserAccessTokenKey(member.getId());
        long size = ObjectUtils.defaultIfNull(stringRedisTemplate.opsForList().size(userAccessTokenKey), 0L);
        //超出最大数量,pop最早进入的token
        if (size >= MAX_SIGN_IN_DEVICE) {
            String oldAccessToken = stringRedisTemplate.opsForList().rightPop(userAccessTokenKey);
            stringRedisTemplate.delete(generateAccessTokenKey(oldAccessToken));
        }
        stringRedisTemplate.opsForList().leftPush(userAccessTokenKey, accessToken);
        stringRedisTemplate.expire(userAccessTokenKey, refreshTokenValidateSeconds, TimeUnit.SECONDS);
        String refreshToken = storeRefreshToken(member);
        authToken.setRefreshTokenExpires(stringRedisTemplate.getExpire(generateRefreshTokenKey(refreshToken)));
        authToken.setRefreshToken(refreshToken);
//        authToken.setRoles(member.getPlatformRoles().get(authToken.getPlatformId()));
        return authToken;
    }

    @Override
    public void clearAllToken(Long id) {
        //删 refresh token
        stringRedisTemplate.delete(generateRefreshTokenKey(ObjectUtils.defaultIfNull(stringRedisTemplate.opsForValue().get(generateUserRefreshTokenKey(id)), "")));
        stringRedisTemplate.delete(generateUserRefreshTokenKey(id));
        //删 access token
        ObjectUtils.defaultIfNull(stringRedisTemplate.opsForList().range(generateUserAccessTokenKey(id), 0, -1), new ArrayList<String>()).forEach(e -> stringRedisTemplate.delete(generateAccessTokenKey(e)));
        stringRedisTemplate.delete(generateUserAccessTokenKey(id));
        //删 user-info
        stringRedisTemplate.delete(generateUserInfoKey(id));
    }

    @Override
    public Long findUserIdByAccessToken(String accessToken) {
        return Long.valueOf(ObjectUtils.defaultIfNull(stringRedisTemplate.opsForValue().get(generateAccessTokenKey(accessToken)), "0"));
    }

    @Override
    public Long findUserIdByRefreshToken(String accessToken) {
        return Long.valueOf(ObjectUtils.defaultIfNull(stringRedisTemplate.opsForValue().get(generateRefreshTokenKey(accessToken)), "0"));
    }

    @Override
    public String findUserInfoByUserId(Long userId) {
        return stringRedisTemplate.opsForValue().get(generateUserInfoKey(userId));
    }

    @Override
    public void storeUserInfo(UserInfo userInfo) {
        //创建用户基础信息缓存
        String userInfoJson = JsonUtils.serialize(userInfo);
        String userInfoKey = generateUserInfoKey(userInfo.getId());
        stringRedisTemplate.opsForValue().set(userInfoKey, userInfoJson, refreshTokenValidateSeconds, TimeUnit.SECONDS);

    }

    @Override
    public void clearOneToken(String accessToken) {
        //删除 auth:access-token:user: 中的
        stringRedisTemplate.opsForList().remove(generateUserAccessTokenKey(findUserIdByAccessToken(accessToken)), 0L, accessToken);
        //删除 auth:access-token:
        stringRedisTemplate.delete(generateAccessTokenKey(accessToken));

    }

    @Override
    public String encode(Long id) {
        return id + "MD5" + System.currentTimeMillis() + secret;
    }
}
