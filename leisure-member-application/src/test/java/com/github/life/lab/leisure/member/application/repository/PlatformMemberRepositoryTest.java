package com.github.life.lab.leisure.member.application.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * @ClassName PlatformMemberRepositoryTest
 * @Description TODO
 * @Author fhero
 * @Date 2018-12-01 22:17
 * @Version 1.0
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@ActiveProfiles("dev")
public class PlatformMemberRepositoryTest {
    @Autowired
    private PlatformMemberRepository platformMemberRepository;


    @Test
    public void findPlatformByMemberId(){
        log.info("平台员工信息:{}", Arrays.asList(platformMemberRepository.findPlatformByMemberId(100000L)));
    }
}
