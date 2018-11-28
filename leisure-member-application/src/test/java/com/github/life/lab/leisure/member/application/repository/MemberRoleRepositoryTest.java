package com.github.life.lab.leisure.member.application.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Cathay-ins.com.cn Inc. Copyright (c) 2014-2018 All Rights Reserved.
 *
 * @author fanchengbo
 * @version 1.0.0 2018/11/28 20:35
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@ActiveProfiles("dev")
public class MemberRoleRepositoryTest {


  @Autowired
  private MemberRoleRepository memberRoleRepository;


  @Test
  public void findByMemberId01() {
    log.info("{}",memberRoleRepository.findByMemberId(100014L));
  }


}
