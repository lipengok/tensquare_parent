package com.lp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 消费者
 *
 * @Author lipeng
 * @Date 2022/11/24 9:46
 * @Version 1.0
 */
@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class QaApplication {

    public static void main(String[] args) {
        SpringApplication.run(QaApplication.class);
        log.info("项目初始化完成");
    }
}
