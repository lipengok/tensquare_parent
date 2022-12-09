package com.lp.base.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author lipeng
 * @Date 2022/11/18 14:54
 * @Version 1.0
 */
@Data
@Entity
@Table(name = "tb_article")
@EntityListeners(AuditingEntityListener.class)
public class Article {

    @Id
    private String id;

    // 专栏id
    private String columnid;

    // 用户id
    private String userid;

    // 文章标题
    private String title;

    // 文章内容
    private String content;

    // 文章封面
    private String image;

    // 发表时间
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private String createtime;

    // 修改时间
    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private String updatetime;

    // 是否公开：0：不公开 1：公开
    private String ispublic;

    // 是否置顶：0：不置顶 1：置顶
    private String istop;

    // 浏览量
    private Integer visits;

    // 点赞量
    private Integer thumbup;

    // 评论量
    private Integer comment;

    // 0：未审核 1：已审核
    private String state;

    // 关联频道表ID
    private String channelid;

    // url地址
    private String url;

    // 文章类型：0：分享 1：专栏
    private String type;

}
