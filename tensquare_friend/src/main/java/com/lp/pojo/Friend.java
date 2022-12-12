package com.lp.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 交友
 *
 * @Author lipeng
 * @Date 2022/12/9 14:30
 * @Version 1.0
 */
@Data
@Entity
@Table(name="tb_friend")
public class Friend implements Serializable {

    @Id
    private String id;

    // 用户id
    @Column(name = "user_id")
    private String userId;

    // 被关注id
    @Column(name = "friend_id")
    private String friendId;

    // 是否相互喜欢，0，不喜欢；1，相互喜欢；2，单方喜欢
    @Column(name = "is_like")
    private String isLike;
}
