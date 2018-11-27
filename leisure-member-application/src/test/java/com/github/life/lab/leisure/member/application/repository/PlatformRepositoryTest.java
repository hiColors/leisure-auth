package com.github.life.lab.leisure.member.application.repository;

import com.github.life.lab.leisure.common.utils.JsonUtils;
import com.github.life.lab.leisure.member.model.consts.EnumPlatformStatus;
import com.github.life.lab.leisure.member.model.persistence.Platform;
import com.oracle.tools.packager.Log;
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
public class PlatformRepositoryTest {

    @Autowired
    private PlatformRepository platformRepository;


    @Test
    public void test01() {
        Platform platform = new Platform();
        platform.setName(" 北方民族大学");
        platform.setStatus(EnumPlatformStatus.ENABLE);
        platform.setComment(" Nun ");
        platformRepository.save(platform);
        log.info("{}", JsonUtils.serialize(platform));
        log.info("{}", platformRepository.count());
    }

    @Test
    public void findByName01(){
        String name = "";
        log.info("信息是:{}",platformRepository.findByName(name));
        Assert.assertNotNull(platformRepository.findByName(name));
    }

    @Test
    public void findByName02(){
        String name = "Life Lab";
        log.info("信息是:{}",platformRepository.findByName(name));
        Assert.assertNotNull(platformRepository.findByName(name));
    }

    @Test
    public void findByName03() {
        String name = " Lab";
        log.info("信息是:{}", platformRepository.findByName(name));
        Assert.assertNotNull(platformRepository.findByName(name));
    }



    }