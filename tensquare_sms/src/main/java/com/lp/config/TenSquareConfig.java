package com.lp.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置sms任务队列
 * @Author lipeng
 * @Date 2022/11/30 11:10
 * @Version 1.0
 */
@Configuration
public class TenSquareConfig {
    @Bean
    public Queue WorkQueue() {
        return new Queue("smsQueue",true);
    }

    @Bean
    DirectExchange WorkExchange() {
        return new DirectExchange("smsExchange");
    }

    @Bean
    Binding bindingDirect() {
        return BindingBuilder.bind(WorkQueue()).to(WorkExchange()).with("smsRouting");
    }
}
