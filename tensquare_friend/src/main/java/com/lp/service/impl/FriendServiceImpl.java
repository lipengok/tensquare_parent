package com.lp.service.impl;

import com.lp.dao.FriendDao;
import com.lp.pojo.Friend;
import com.lp.service.FriendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/12/12 9:00
 * @Version 1.0
 */
@Slf4j
@Service
public class FriendServiceImpl implements FriendService {

    @Autowired
    private FriendDao friendDao;

    public List<Friend> findAll(){
        return friendDao.findAll();
    }

    /**
     * 添加好友
     *
     * @param userId    用户自身id
     * @param friendId  要添加的朋友id
     * @param type      是否喜欢：1：不喜欢，2：喜欢（只有这两个值）
     * @return
     */
    @Transactional
    public int addFriend(String userId, String friendId, String type){
        // 判断如果用户已经添加了这个好友，则不进行任何操作,返回0
        if(friendDao.selectCount(userId, friendId)>0){
            return 0;
        }
        Friend friend=new Friend();
        friend.setUserId(userId);
        friend.setFriendId(friendId);
        switch (type){
            case "1":
                if(friendDao.selectCount(friendId, userId)>0){
                    if(friendDao.isLike(friendId, userId)!="0"){
                        log.info("单向喜欢");
                        friend.setIsLike("2");
                        friendDao.save(friend);
                        friendDao.updateLike(friendId, userId,"2");
                    }else {
                        log.info("不喜欢");
                        friend.setIsLike("0");
                        friendDao.save(friend);
                    }
                }
                break;
            case "2":
                if(friendDao.selectCount(friendId, userId)>0){
                    if(friendDao.isLike(friendId, userId)!="0"){
                        log.info("相互喜欢");
                        friend.setIsLike("1");
                        friendDao.save(friend);
                        friendDao.updateLike(friendId, userId,"1");
                    }else {
                        log.info("单向喜欢");
                        friend.setIsLike("2");
                        friendDao.save(friend);
                    }
                }
                break;
            default:
                log.error("type的类型只能是1或者2");
                break;
        }
        return 1;
    }
}
