package com.lp.controller;

import com.lp.common.entity.Result;
import com.lp.common.entity.StatusCode;
import com.lp.pojo.NoFriend;
import com.lp.service.impl.NoFriendServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 朋友 api
 *
 * @Author lipeng
 * @Date 2022/12/9 14:29
 * @Version 1.0
 */
@RestController
@RequestMapping("/no_friend")
public class NoFriendController {

    @Autowired
    private NoFriendServiceImpl noFriendService;

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public Result findAll(){
        try {
            List<NoFriend> list = noFriendService.findAll();
            return new Result(true, StatusCode.OK, "查询成功", list);
        }catch (Exception e){
            return new Result(false, StatusCode.ERROR, "查询失败", e.getMessage());
        }
    }
}
