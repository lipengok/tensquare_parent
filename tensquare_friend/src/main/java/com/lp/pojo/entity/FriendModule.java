package com.lp.pojo.entity;

import lombok.Data;

/**
 * @Author lipeng
 * @Date 2022/12/12 14:54
 * @Version 1.0
 */
@Data
public class FriendModule {

    private String userId;

    private String friendId;

    // 关系：0不喜欢，1相互喜欢，2单向喜欢
    private String isLike;

    // user的态度：1不喜欢，2喜欢
    private String type;
}
