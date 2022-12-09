package com.lp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka 微服务管理，启动类
 *
 * @Author lipeng
 * @Date 2022/11/24 9:46
 * @Version 1.0
 */
@Slf4j
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class);
        log.info("项目初始化完成");
    }
}
