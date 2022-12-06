package com.lp.controller;

import com.lp.common.entity.Result;
import com.lp.common.entity.StatusCode;
import com.lp.pojo.entity.Login;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lp.pojo.User;
import com.lp.server.impl.UserServiceImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lipeng
 * @Date 2022/11/30 11:22
 * @Version 1.0
 */
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    /**
     * 发送验证码
     * @param mobile
     * @return
     */
    @RequestMapping(value="/sendSms",method= RequestMethod.POST)
    public Result sendSms(@RequestBody String mobile){
        log.info("向队列smsQueue发送验证码");
        String code = userService.sendSms(mobile);
        return new Result(true, StatusCode.OK,"发送成功", code);
    }

    /**
     * 用户注册
     * @param user
     */
    @RequestMapping(value="/register/{code}",method= RequestMethod.POST)
    public Result register(@RequestBody User user , @PathVariable String code){
        try {
            User resUser = userService.add(user,code);
            return new Result(true, StatusCode.OK,"注册成功", resUser);
        }catch (Exception e){
            Map map = new HashMap<String, Object>();
            map.put("error", e.getMessage());
            map.put("user", user);
            return new Result(false, StatusCode.ERROR,"注册失败", map);
        }

    }

    /**
     * 根据用户名登录
     *
     * @param login
     * @return
     */
    public Result loginByName(@RequestBody Login login){
        try {
            User user = userService.findByNameAndPassword(login.getName(), login.getPsw());
            return new Result(true, StatusCode.OK,"登录成功", user);
        }catch (Exception e){
            Map map = new HashMap<String, Object>();
            map.put("error", e.getMessage());
            map.put("login", login);
            return new Result(false, StatusCode.ERROR,"登录", map);
        }
    }

    /**
     * 根据手机号登录
     *
     * @param login
     * @return
     */
    public Result loginByMobile(@RequestBody Login login){
        try {
            User user = userService.findByMobileAndPassword(login.getMobile(), login.getPsw());
            return new Result(true, StatusCode.OK,"登录成功", user);
        }catch (Exception e){
            Map map = new HashMap<String, Object>();
            map.put("error", e.getMessage());
            map.put("login", login);
            return new Result(false, StatusCode.ERROR,"登录", map);
        }
    }
}
