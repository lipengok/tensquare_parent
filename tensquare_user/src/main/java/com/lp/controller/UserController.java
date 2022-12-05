package com.lp.controller;

import com.lp.common.entity.Result;
import com.lp.common.entity.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lp.pojo.User;
import com.lp.server.impl.UserServiceImpl;

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
     * 用户注册
     * @param user
     */
    @RequestMapping(value="/register/{code}",method= RequestMethod.POST)
    public Result register(@RequestBody User user , @PathVariable String
            code){
        userService.add(user,code);
        return new Result(true, StatusCode.OK,"注册成功");
    }

    @RequestMapping(value="/sendSms",method= RequestMethod.POST)
    public Result sendSms(@RequestBody String mobile){
        log.info("向队列smsQueue发送验证码");
        userService.sendSms(mobile);
        return new Result(true, StatusCode.OK,"发送成功");
    }
}
