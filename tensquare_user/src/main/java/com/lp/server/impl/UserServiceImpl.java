package com.lp.server.impl;

import com.alibaba.fastjson2.JSON;
import com.lp.dao.UserDao;
import com.lp.pojo.entity.SmsCode;
import com.lp.redis.RedisOpera;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.lp.pojo.User;
import com.lp.server.UserService;

import java.util.*;
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
    private RedisOpera redisOpera;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private UserDao userDao;

    /**
     * 发送短信验证码
     *
     * @param mobile 手机号
     */
    public String sendSms(String mobile) {
        //生成6位短信验证码
        Random random = new Random();
        int max = 999999;//最大数
        int min = 100000;//最小数
        int code = random.nextInt(max);//随机生成
        if (code < min) {
            code = code + min;
        }
        String resCode = String.valueOf(code);
        log.debug("向手机尾号为=>[{}]的用户发送验证码[{}]", mobile, resCode);
        //将验证码放入redis
        //五分钟过期
        redisOpera.setStr("sms", resCode, 5L);
        //将验证码和手机号发动到rabbitMQ中
        Map<String, String> map = new HashMap();
        map.put("mobile", mobile);
        map.put("code", code + "");
        rabbitTemplate.convertAndSend("smsExchange", "smsRouting", map);
        return resCode;
    }

    /**
     * 增加
     *
     * @param user 用户
     * @param code 用户填写的验证码
     */
    public User add(User user, String code) {
        String key = "sms";
        //判断验证码是否正确
        String smsCode = redisOpera.getStr(key);
        log.info("从缓存中获取的键[{}]值[{}]", key, smsCode);
        //提取系统正确的验证码
        if (smsCode == null) {
            throw new RuntimeException("请点击获取短信验证码");
        }
        if (!smsCode.equals(code)) {
            throw new RuntimeException("验证码输入不正确");
        }
        user.setId(user.getId());
        user.setName(user.getName());
        user.setPsw(encoder.encode(user.getPsw()));
        user.setFollowCount(0);
        user.setFansCount(0);
        user.setOnline(0L);
        user.setRegDate(new Date());
        user.setUpdDate(new Date());
        user.setLastDate(new Date());
        userDao.save(user);
        return user;
    }

    /**
     * 根据手机号和密码查询用户
     *
     * @param mobile
     * @param password
     * @return
     */
    public User findByMobileAndPassword(String mobile,String password){
        User user = userDao.findByMobile(mobile);
        if(user!=null && encoder.matches(password,user.getPsw())){
            return user;
        }else{
            return null;
        }
    }

    /**
     * 根据用户名和密码查询用户
     *
     * @param name
     * @param password
     * @return
     */
    public User findByNameAndPassword(String name, String password){
        User user = userDao.findByName(name);
        if(user!=null && encoder.matches(password,user.getPsw())){
            return user;
        }else{
            return null;
        }
    }

    /**
     * 根据用户id删除用户
     *
     * @param id
     */
    public void deleteById(String id){
        userDao.delete(id);
    }

    /**
     * 查询所有的用户
     *
     * @return
     */
    public List<User> findAll(){
        return userDao.findAll();
    }
}
