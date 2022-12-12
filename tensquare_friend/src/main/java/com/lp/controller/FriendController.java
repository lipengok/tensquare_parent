package com.lp.controller;

import com.lp.common.entity.Result;
import com.lp.common.entity.StatusCode;
import com.lp.pojo.Friend;
import com.lp.pojo.entity.FriendModule;
import com.lp.service.impl.FriendServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 交友 api
 *
 * @Author lipeng
 * @Date 2022/12/9 14:29
 * @Version 1.0
 */
@RestController
@RequestMapping("/friend")
public class FriendController {

    @Autowired
    private FriendServiceImpl friendService;

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public Result findAll(){
        try {
            List<Friend> list = friendService.findAll();
            return new Result(true, StatusCode.OK, "查询成功", list);
        }catch (Exception e){
            return new Result(false, StatusCode.ERROR, "查询失败", e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addFriend")
    public Result addFriend(@RequestBody FriendModule friendModule){
        try {
            friendService.addFriend(friendModule.getUserId(), friendModule.getFriendId(), friendModule.getType());
            return new Result(true, StatusCode.OK, "添加成功", friendModule);
        }catch (Exception e){
            return new Result(false, StatusCode.ERROR, "添加失败", e.getMessage());
        }
    }
}
