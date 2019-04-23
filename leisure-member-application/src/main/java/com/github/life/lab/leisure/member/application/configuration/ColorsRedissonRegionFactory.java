package com.github.life.lab.leisure.member.application.configuration;

import com.github.lifelab.leisure.common.framework.utils.SpringContextUtils;
import org.redisson.api.RedissonClient;
import org.redisson.hibernate.RedissonRegionFactory;

import java.util.Map;
import java.util.Objects;

/**
 * RedissonRegionFactory
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2019-01-25
 */
public class ColorsRedissonRegionFactory extends RedissonRegionFactory {

    @Override
    protected RedissonClient createRedissonClient(Map properties) {
        while (Objects.isNull(SpringContextUtils.getApplicationContext())) {
        }
        return SpringContextUtils.getBeanByType(RedissonClient.class);
    }
}