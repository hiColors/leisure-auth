package com.github.lifelab.leisure.member.application.configuration;


import com.github.lifelab.leisure.common.jpa.customiz.repository.ColorsComplexRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * JpaConfiguration
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/2
 */
@Configuration
@EnableJpaRepositories(
        includeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ASSIGNABLE_TYPE,
                        value = {
                                JpaRepository.class
                        }
                )
        },
        basePackages = "com.github.lifelab.leisure.member.application.repository",
        repositoryBaseClass = ColorsComplexRepository.class
)
@EntityScan({"com.github.lifelab.leisure.member.application.entity"})
public class JpaLeisureAuthConfiguration {
}