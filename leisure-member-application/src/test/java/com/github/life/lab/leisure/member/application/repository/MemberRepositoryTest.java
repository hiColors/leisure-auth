package com.github.life.lab.leisure.member.application.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName MemberRepositoryTest
 * @Description TODO
 * @Author fhero
 * @Date 2018-11-27 23:17
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@ActiveProfiles("dev")
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;


    @Test
    public void findByUsername(){
        log.info("成员信息:{}",memberRepository.findByUsername("liweichao"));
    }

    @Test
    public void findByUsernameAndPassword01(){
        Assert.assertEquals(null,memberRepository.findByUsernameAndPassword("fff","ff"));
    }

    @Test
    public void findByUsernameAndPassword02(){
        log.info("{}",memberRepository.findByUsernameAndPassword("liweichao","000000"));
        Assert.assertNotNull(memberRepository.findByUsernameAndPassword("liweichao","000000"));
    }




}
