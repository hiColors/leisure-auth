package com.github.lifelab.leisure.member.application.service.impl;

import com.github.lifelab.leisure.common.utils.JsonUtils;
import com.github.lifelab.leisure.member.application.service.RoleService;
import com.github.lifelab.leisure.member.model.resource.role.Role;
import com.github.lifelab.leisure.member.model.resource.role.RoleModel;
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
public class RoleServiceImplTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void create() {
        RoleModel model = new RoleModel();
        model.setCode("xx");
        model.setName("xx");
        model.setDescription("xx");
        model.setComment("xx");
        Role role = roleService.create(model);

        log.info(JsonUtils.serialize(role));
    }

    @Test
    public void delete() {
        Long id = 1L;
        roleService.delete(id);
    }

    @Test
    public void modify() {
    }

    @Test
    public void query() {
    }
}