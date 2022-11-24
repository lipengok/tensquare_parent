package com.lp.spit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author lipeng
 * @Date 2022/11/24 9:46
 * @Version 1.0
 */
@SpringBootApplication
@Slf4j
public class SpitApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpitApplication.class);
        log.info("项目初始化完成");
    }
}
