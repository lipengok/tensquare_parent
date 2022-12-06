package com.lp.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @Author lipeng
 * @Date 2022/12/6 13:41
 * @Version 1.0
 */
@Component
public class RedisOpera {

    @Autowired
    private RedisTemplate redisTemplate;

    public void delete(String key) {
        redisTemplate.delete(key);
    }

    public void deletes(ArrayList<String> keys) {
        redisTemplate.delete(keys);
    }

    /**
     * 指定key的失效时间
     *
     * @param key
     * @param time 单位：分钟
     */
    public void expire(String key, long time) {
        redisTemplate.expire(key, time, TimeUnit.MINUTES);
    }

    /**
     * 根据key获取过期时间
     *
     * @param key
     * @return
     */
    public long getExpire(String key) {
        Long expire = redisTemplate.getExpire(key);
        return expire;
    }

    /**
     * 判断key是否存在
     *
     * @param key
     * @return
     */
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * string 设置键值对
     *
     * @param key
     * @param value
     */
    public void setStr(String key, String value) {
        redisTemplate.boundValueOps(key).set(value);
    }

    /**
     * string 设置键值对，设置过期时间
     *
     * @param key
     * @param value
     * @param time  单位：分钟
     */
    public void setStr(String key, String value, Long time) {
        redisTemplate.boundValueOps(key).set(value, time, TimeUnit.MINUTES);
    }

    /**
     * string 根据键获取值
     *
     * @param key
     * @return
     */
    public String getStr(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }

}
