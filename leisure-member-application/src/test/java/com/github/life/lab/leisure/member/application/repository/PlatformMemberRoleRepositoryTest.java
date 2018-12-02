package com.github.life.lab.leisure.member.application.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName PlatformMemberRoleRepositoryTest
 * @Description TODO
 * @Author fhero
 * @Date 2018-12-01 22:24
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@ActiveProfiles("dev")
public class PlatformMemberRoleRepositoryTest {
    @Autowired
    private PlatformMemberRoleRepository platformMemberRoleRepository;


    @Test
    public void findByPlatformMemberMemberId(){
        log.info("{}",platformMemberRoleRepository.findByPlatformMemberMemberId(100000L));
    }
}
