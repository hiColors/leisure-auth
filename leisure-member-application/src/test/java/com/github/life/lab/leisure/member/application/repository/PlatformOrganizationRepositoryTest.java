package com.github.life.lab.leisure.member.application.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

/**
 * @ClassName PlatformOrganizationRepositoryTest
 * @Description TODO
 * @Author fhero
 * @Date 2018-12-02 16:49
 * @Version 1.0
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@ActiveProfiles("dev")
public class PlatformOrganizationRepositoryTest {
    @Autowired
    private PlatformOrganizationRepository platformOrganizationRepository;


    @Test
    public void findByPlatformAndLevelEquals0(){
        log.info("通过platformId获取所在组织机构:{}",platformOrganizationRepository.findByPlatformAndLevelEquals0(100000L));
    }

    @Transactional
    @Test
    public void updateNameByPlatformAndLevelEquals0(){
        log.info("根据平台ID和名称更新组织机构:{}",platformOrganizationRepository.updateNameByPlatformAndLevelEquals0("Life Lab",100000L));
        Assert.assertNotNull(platformOrganizationRepository.updateNameByPlatformAndLevelEquals0("Life Lab",100000L));
    }


    @Test
    public void findByPlatformIdAndName(){
        log.info("根据平台ID和组织机构名称获取组织机构信息:{}",platformOrganizationRepository.findByPlatformIdAndName(0l,"Life Lab"));
    }
}
