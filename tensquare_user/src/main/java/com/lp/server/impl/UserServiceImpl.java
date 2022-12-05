package com.lp.server.impl;

import com.lp.dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.lp.pojo.User;
import com.lp.server.UserService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Author lipeng
 * @Date 2022/11/30 11:06
 * @Version 1.0
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private UserDao userDao;

    /**
     * 发送短信验证码
     * @param mobile 手机号
     */
    public void sendSms(String mobile) {
        //生成6位短信验证码
        Random random = new Random();
        int max = 999999;//最大数
        int min = 100000;//最小数
        int code = random.nextInt(max);//随机生成
        if (code < min) {
            code = code + min;
        }
        log.debug("向手机尾号为=>[{}]的用户发送验证码[{}]", mobile, code);
        //将验证码放入redis
        redisTemplate.opsForValue().set("smscode_" + mobile, code + "", 5, TimeUnit.MINUTES);//五分钟过期
        //将验证码和手机号发动到rabbitMQ中
        Map<String, String> map = new HashMap();
        map.put("mobile", mobile);
        map.put("code", code + "");
        rabbitTemplate.convertAndSend("smsExchange", "smsRouting", map);
    }

    /**
     * 增加
     * @param user 用户
     * @param code 用户填写的验证码
     */
    public void add(User user, String code) {
        //判断验证码是否正确
        String syscode = (String)redisTemplate.opsForValue().get("smscode_" + user.getMobile());
        //提取系统正确的验证码
        if(syscode==null){
            throw new RuntimeException("请点击获取短信验证码");
        }
        if(!syscode.equals(code)){
            throw new RuntimeException("验证码输入不正确");
        }
        user.setId( user.getId() );
        user.setFollowCount(0);
        user.setFansCount(0);
        user.setOnline(0L);
        user.setRegDate(new Date());
        user.setUpdDate(new Date());
        user.setLastDate(new Date());
        userDao.save(user);
    }
}
