package com.github.hicolors.leisure.auth.application.configuration;


import com.github.hicolors.leisure.common.jpa.customiz.repository.ColorsComplexRepository;
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
        basePackages = "com.github.hicolors.leisure.auth",
        repositoryBaseClass = ColorsComplexRepository.class
)
@EntityScan(basePackages = "com.github.hicolors.leisure.auth")
public class JpaLeisureAuthConfiguration {
}