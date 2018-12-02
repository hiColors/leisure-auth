package com.github.life.lab.leisure.member.application.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName MemberDetailRepositoryTest
 * @Description TODO
 * @Author fhero
 * @Date 2018-12-01 20:30
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@ActiveProfiles("dev")
public class MemberDetailRepositoryTest {

//    @Autowired
//    private DataSource dataSource;
//
    @Autowired
    private MemberDetailRepository memberDetailRepository;
//
//    @Before
//    public void setUp() throws Exception {
//        Operation operation = Operations.sequenceOf(
//                Operations.deleteAllFrom("sys_organization"),
//                Operations.insertInto("sys_organization")
//                        .columns("name","priority","parent_id","parent_ids","available")
//                        .values("测试组", 10, 0, "0/", Boolean.TRUE)
//                        .build()
//        );
//        DbSetup dbSetup = new DbSetup(new DataSourceDestination(dataSource), operation);
//        dbSetupTracker.launchIfNecessary(dbSetup);
//    }


    @Test
    public void findByMobile(){
        log.info("通过联系方式获取人员详情:{}",memberDetailRepository.findByMobile("18395202205"));
    }

    @Test
    public void findByEmail(){
        log.info("通过邮箱获取人员详情:{}",memberDetailRepository.findByEmail("liweichao@life-lab.onaliyun.com"));
    }
}
