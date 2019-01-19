package com.github.life.lab.leisure.member.application.repository;

import com.github.life.lab.leisure.common.utils.JsonUtils;
import com.github.life.lab.leisure.member.application.entity.EPermission;
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
public class EPermissionRepositoryTest {

    @Autowired
    private EPermissionRepository repository;

    @Test
    public void test01() {
        EPermission ePermission = repository.findByAntPathAndStrategy("/", false);
        log.info(JsonUtils.serialize(ePermission));
    }

    @Test
    public void test02() {
        EPermission ePermission = repository.findByName("");
        log.info(JsonUtils.serialize(ePermission));
    }
}