package com.lp.controller;

import com.lp.common.entity.Login;
import com.lp.common.entity.Result;
import com.lp.common.entity.StatusCode;
import com.lp.jwt.JwtOpera;
import com.lp.pojo.Admin;
import com.lp.server.impl.AdminServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lipeng
 * @Date 2022/12/5 11:04
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;

    @Autowired
    private JwtOpera jwtOpera;

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public Result regAdmin(@RequestBody Admin admin){
        try {
            adminService.add(admin);
            log.debug("用户[{}]注册成功", admin.getName());
            return new Result(true, StatusCode.OK,"注册成功", admin);
        }catch (Exception e){
            Map map = new HashMap<String, Object>();
            map.put("error", e.getMessage());
            map.put("admin", admin);
            log.debug("用户[{}]注册失败，失败原因[{}]", admin.getName(), e.getMessage());
            return new Result(false, StatusCode.ERROR,"注册失败", map);
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody Login login){
        Admin admin = adminService.findByNameAndPsw(login.getName(), login.getPsw());
        if (null != admin){
            String token = jwtOpera.createJWT(admin.getId(), admin.getName(), "admin");
            Map map = new HashMap<String, Object>();
            map.put("name", login.getName());
            map.put("token", token);
            return new Result(true, StatusCode.OK,"登录成功", map);
        }else {
            return new Result(false, StatusCode.ERROR,"登录失败", null);
        }
    }
}
