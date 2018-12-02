package com.github.life.lab.leisure.member.application.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

/**
 * @ClassName PlatformJobRepositoryTest
 * @Description TODO
 * @Author fhero
 * @Date 2018-12-01 22:04
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@ActiveProfiles("dev")
public class RolePermissionRepositoryTest {

    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    @Test
    public void findByRoleIdAndPermissionId(){
        log.info("通过角色ID和权限ID获取对应的角色权限:{}",rolePermissionRepository.findByRoleIdAndPermissionId(100001L,10000L));
    }

    //TODO 删除之前应该根据deleteFlag进行判断状态
    @Transactional
    @Test
    public void deleteByRoleId(){
        log.info("通过角色ID删除对应的角色权限:{}",rolePermissionRepository.deleteByRoleId(100001L));
    }

//TODO 删除之前应该根据deleteFlag进行判断状态
    @Transactional
    @Test
    public void deleteByPermissionId(){
        log.info("通过权限ID删除对应的角色权限{}",rolePermissionRepository.deleteByPermissionId(10000L));
    }

    @Transactional
    @Test
    public void deleteByRoleIdAndPermissionId(){
        log.info("通过角色ID和权限ID删除对应的角色权限{}",rolePermissionRepository.deleteByRoleIdAndPermissionId(100001L,10000L));
    }

}
