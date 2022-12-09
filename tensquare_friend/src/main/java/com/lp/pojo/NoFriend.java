package com.lp.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author lipeng
 * @Date 2022/12/9 14:45
 * @Version 1.0
 */
@Data
@Entity
@Table(name="tb_nofriend")
public class NoFriend {

    @Id
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "friend_id")
    private String friendId;
}
