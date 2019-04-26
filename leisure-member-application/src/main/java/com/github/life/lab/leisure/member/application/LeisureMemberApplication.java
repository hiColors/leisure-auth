package com.github.life.lab.leisure.member.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

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
        ApplicationContext applicationContext = null;
        boolean success = true;
        try {
            applicationContext = SpringApplication.run(LeisureMemberApplication.class, args);
        } catch (Exception e) {
            success = false;
            log.info("*****************************启动失败*******************************", e);
        }
        if (success) {
            log.info("*****************************启动成功*******************************");
        }
    }
}