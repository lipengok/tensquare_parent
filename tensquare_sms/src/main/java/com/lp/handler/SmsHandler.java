package com.lp.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author lipeng
 * @Date 2022/11/30 14:28
 * @Version 1.0
 */
@Slf4j
@Component
@RabbitListener(queues = "smsQueue")
public class SmsHandler {

    @RabbitHandler
    public void sendSms(Map<String,String> message){
        log.info("从队列smsQueue取出任务");
        log.debug("手机号=>[{}]", message.get("mobile"));
        log.debug("验证码=>[{}]", message.get("code"));
    }
}
