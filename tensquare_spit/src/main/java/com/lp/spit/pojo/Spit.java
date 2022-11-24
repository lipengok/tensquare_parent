package com.lp.spit.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * 吐槽
 * @Author lipeng
 * @Date 2022/11/24 9:56
 * @Version 1.0
 */
@Data
public class Spit {

    @Id
    private String id;

    // 吐槽内容
    private String content;

    // 发布日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date publishtime;

    // 用户id
    private String userid;

    // 用户昵称
    private String nickname;

    // 浏览数
    private Integer visits;

    // 点赞数
    private Integer thumbup;

    // 分享数
    private Integer share;

    // 回复数
    private Integer comment;

    // 是否可见：0可见，1不可见
    private String state;

    // 上级id
    private String parentid;
}
