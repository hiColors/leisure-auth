package com.github.lifelab.leisure.member.application.repository;

import org.apache.commons.lang3.RandomUtils;

/**
 * 并发测试
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2019-01-20
 */
public class Test {

    public static void main(String[] args) {

        String[] ss = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                log(ss[RandomUtils.nextInt(0, 10)]);
            }).start();
        }
    }

    private static void log(String xx) {
        synchronized (xx.intern()) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException ignore) {
            }
            System.out.println(xx + "\t" + System.currentTimeMillis());
        }
    }
}