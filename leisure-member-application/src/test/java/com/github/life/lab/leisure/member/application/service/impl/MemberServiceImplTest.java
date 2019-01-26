package com.github.life.lab.leisure.member.application.service.impl;

import com.github.life.lab.leisure.member.application.service.MemberService;
import lombok.extern.slf4j.Slf4j;
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
public class MemberServiceImplTest {

    @Autowired
    private MemberService memberService;

    @Test
    public void checkMobile() {
        memberService.checkMobile("18395202205", null);
    }

    @Test
    public void checkUsername() {
        memberService.checkUsername("18395202205", null);
    }

    @Test
    public void checkEmail() {
        memberService.checkEmail("18395202205", null);
    }
}