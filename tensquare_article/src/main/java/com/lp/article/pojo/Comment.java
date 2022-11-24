package com.lp.article.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author lipeng
 * @Date 2022/11/24 14:19
 * @Version 1.0
 */
@Data
public class Comment implements Serializable {

    @Id
    private String _id;

    // 文章ID
    private String articleid;

    // 评论内容
    private String content;

    // 评论人ID
    private String userid;

    // 评论id
    private String parentid;

    // 评论日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date publishdate;
}
