package com.github.hicolors.leisure.auth.application.repository;

import com.github.hicolors.leisure.common.utils.JsonUtils;
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
public class RoleRepositoryTest {

    @Autowired
    private RoleRepository repository;
    @Autowired
    private RolePermissionRepository permissionRepository;

    @Test
    public void test01() {
        log.info("[{}]", repository.count());

        log.info("{}", JsonUtils.serialize(repository.findById(1L).get()));

        log.info("{}", permissionRepository.findById(1L));
    }
}