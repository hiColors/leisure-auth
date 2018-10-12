package com.github.hicolors.leisure.auth.application.repository;

import com.github.hicolors.leisure.auth.model.consts.EnumCompanyStatus;
import com.github.hicolors.leisure.auth.model.persistence.Platform;
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
public class PlatformRepositoryTest {

    @Autowired
    private PlatformRepository companyRepository;


    @Test
    public void test01() {
        Platform company = new Platform();
        company.setName("中国1");
        company.setStatus(EnumCompanyStatus.DISABLE);
        company.setComment("中华人民共和国1");
        companyRepository.save(company);
        log.info("{}", JsonUtils.serialize(company));
        log.info("{}", companyRepository.count());
    }

}