package com.lp.dao;

import com.lp.pojo.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 交友
 *
 * @Author lipeng
 * @Date 2022/12/9 14:56
 * @Version 1.0
 */
public interface FriendDao extends JpaRepository<Friend, String> {

    /**
     * 根据用户ID与被关注用户ID查询记录个数
     * 判断两人是否已经添加好友
     *
     * @param userId
     * @param friendId
     * @return
     */
    @Query("select count(f) from Friend f where f.userId=?1 and f.friendId=?2")
    int selectCount(String userId,String friendId);

    /**
     * 根据用户ID与被关注用户ID，修改两个用户的关系
     *
     * @param userId
     * @param friendId
     * @param isLike
     */
    @Query("update Friend f set f.isLike=?3 where f.userId=?1 and f.friendId=?2")
    void updateLike(String userId, String friendId, String isLike);

    /**
     * 根据用户ID与被关注用户ID，查询两人关系
     *
     * @param userId
     * @param friendId
     * @return
     */
    @Query("select f.isLike from Friend f where f.userId=?1 and f.friendId=?2")
    String isLike(String userId, String friendId);
}
