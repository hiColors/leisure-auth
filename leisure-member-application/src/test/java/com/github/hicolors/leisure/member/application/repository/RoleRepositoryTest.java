package com.github.hicolors.leisure.member.application.repository;

import com.github.hicolors.leisure.member.model.persistence.Role;
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
    public void create() {
        Role role = new Role();
        role.setName("xxx");
        role.setStatus(true);
        role.setComment("");
        role.setDescription("");
        repository.save(role);
        log.info("{}", repository.findByName("xxx"));
    }

    @Test
    public void test01() {
        log.info("[{}]", repository.count());

        repository.findById(11L).ifPresent((e) -> {
            System.out.println(e.getName());
        });

        log.info("{}", permissionRepository.findById(1L));
    }

    @Test
    public void findByName() {
    }
}