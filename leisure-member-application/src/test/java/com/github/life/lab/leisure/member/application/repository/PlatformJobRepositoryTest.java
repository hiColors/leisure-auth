package com.github.life.lab.leisure.member.application.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName PlatformJobRepositoryTest
 * @Description TODO
 * @Author fhero
 * @Date 2018-12-01 22:04
 * @Version 1.0
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@ActiveProfiles("dev")
public class PlatformJobRepositoryTest {

    @Autowired
    private PlatformJobRepository platformJobRepository;

    @Test
    public void findByPlatformIdAndTitle(){
        log.info("平台职称:{}",platformJobRepository.findByPlatformIdAndTitle(100000L,"Java 初级开发工程师"));
    }
}
