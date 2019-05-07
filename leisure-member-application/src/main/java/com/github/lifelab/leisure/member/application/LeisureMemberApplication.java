package com.github.lifelab.leisure.member.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 人员管理服务
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2018/10/2
 */
@SpringBootApplication
@Slf4j
public class LeisureMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeisureMemberApplication.class, args);
    }
}