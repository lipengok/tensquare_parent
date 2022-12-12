package com.lp.service.impl;

import com.lp.dao.NoFriendDao;
import com.lp.pojo.NoFriend;
import com.lp.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/12/12 9:00
 * @Version 1.0
 */
@Service
public class NoFriendServiceImpl implements FriendService {

    @Autowired
    private NoFriendDao noFriendDao;

    public List<NoFriend> findAll(){
        return noFriendDao.findAll();
    }
}
