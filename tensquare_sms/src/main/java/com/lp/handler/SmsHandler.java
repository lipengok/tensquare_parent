package com.lp.handler;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author lipeng
 * @Date 2022/11/30 14:28
 * @Version 1.0
 */
@Component
@RabbitListener(queues = "smsQueue")
public class SmsHandler {

    @RabbitHandler
    public void sendSms(Map<String,String> message){
        System.out.println("手机号："+message.get("mobile"));
        System.out.println("验证码："+message.get("code"));
    }
}
