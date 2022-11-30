package com.lp.controller;

import com.lp.common.entity.Result;
import com.lp.common.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lp.pojo.User;
import com.lp.server.impl.UserServiceImpl;

/**
 * @Author lipeng
 * @Date 2022/11/30 11:22
 * @Version 1.0
 */
@RestController("/user")
@CrossOrigin
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
}
