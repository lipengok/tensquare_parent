package com.lp.controller;

import com.lp.common.entity.Result;
import com.lp.common.entity.StatusCode;
import com.lp.jwt.JwtOpera;
import com.lp.pojo.entity.Login;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lp.pojo.User;
import com.lp.server.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
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

    @Autowired
    private JwtOpera jwtOpera;

    @Autowired
    private HttpServletRequest request;

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
    @RequestMapping(value="/loginByName",method= RequestMethod.POST)
    public Result loginByName(@RequestBody Login login){
        try {
            User user = userService.findByNameAndPassword(login.getName(), login.getPsw());
            return new Result(true, StatusCode.OK,"登录成功", loginRes(user));
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
    @RequestMapping(value="/loginByMobile",method= RequestMethod.POST)
    public Result loginByMobile(@RequestBody Login login){
        try {
            User user = userService.findByMobileAndPassword(login.getMobile(), login.getPsw());
            return new Result(true, StatusCode.OK,"登录成功", loginRes(user));
        }catch (Exception e){
            Map map = new HashMap<String, Object>();
            map.put("error", e.getMessage());
            map.put("login", login);
            return new Result(false, StatusCode.ERROR,"登录失败", map);
        }
    }

    private Map<String, Object> loginRes(User user){
        String token = jwtOpera.createJWT(user.getId(), user.getName(), "user");
        Map map = new HashMap<String, Object>();
        map.put("name", user.getName());
        map.put("user", user);
        map.put("token", token);
        return map;
    }

    /**
     * 查询所有用户信息
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result findAll(){
        // 检查头信息
        if (jwtOpera.checkPower(request)){
            try {
                List<User> list = userService.findAll();
                return new Result(true, StatusCode.OK,"查询成功", list);
            }catch (Exception e){
                return new Result(false, StatusCode.ERROR,"查询失败", e.getMessage());
            }
        }else {
            return new Result(false, StatusCode.ACCESSERROR,"权限不足", null);
        }
    }
}
