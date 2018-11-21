package com.github.life.lab.leisure.member.application.repository;

import com.github.life.lab.leisure.common.utils.JsonUtils;
import com.github.life.lab.leisure.member.model.consts.EnumPlatformStatus;
import com.github.life.lab.leisure.member.model.persistence.Platform;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
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

}