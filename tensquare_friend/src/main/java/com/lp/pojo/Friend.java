package com.lp.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
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

    @Column(name = "user_id")
    private String userId;

    @Column(name = "friend_id")
    private String friendId;

    @Column(name = "is_like")
    private String isLike;
}
