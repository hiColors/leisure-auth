package com.github.life.lab.leisure.member.application.repository;

import com.github.life.lab.leisure.common.utils.JsonUtils;
import com.github.life.lab.leisure.member.application.entity.EMember;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@ActiveProfiles("dev")
public class EMemberRepositoryTest {

    @Autowired
    private EMemberRepository repository;

    @Test
    public void test01() {
        EMember member = repository.findByUsername("liweichao");
        log.info(JsonUtils.serialize(member));
        Assert.assertEquals(member.getId(), Long.valueOf(100000L));
    }

    @Test
    public void test02() {
        EMember member = repository.findByMobile("18395202205");
        log.info(JsonUtils.serialize(member));
        Assert.assertEquals(member.getId(), Long.valueOf(100000));
    }

    @Test
    public void test03() {
        EMember member = repository.findByEmail("liweichao@life-lab.onaliyun.com");
        log.info(JsonUtils.serialize(member));
        Assert.assertEquals(member.getId(), Long.valueOf(100000));
    }
}