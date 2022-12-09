package com.lp.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * 服务者
 *
 * @Author lipeng
 * @Date 2022/11/15 14:41
 * @Version 1.0
 */
@Slf4j
@EnableJpaAuditing
@SpringBootApplication
@EnableEurekaClient
public class BaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class);
        log.info("项目初始化完成");
    }
}
