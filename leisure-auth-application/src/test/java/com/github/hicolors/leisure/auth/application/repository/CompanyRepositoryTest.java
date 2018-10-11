package com.github.hicolors.leisure.auth.application.repository;

import com.github.hicolors.leisure.auth.model.persistence.Company;
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
public class CompanyRepositoryTest {

    @Autowired
    private CompanyRepository companyRepository;


    @Test
    public void test01() {
        Company company = new Company();
        company.setName("中国");
        company.setStatus(2);
        company.setComment("中华人民共和国");
        companyRepository.save(company);
        log.info("{}", JsonUtils.serialize(company));
        log.info("{}", companyRepository.count());
    }

}