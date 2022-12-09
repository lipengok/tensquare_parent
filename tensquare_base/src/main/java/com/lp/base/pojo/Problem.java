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
import java.util.Date;

/**
 * @Author lipeng
 * @Date 2022/11/18 9:57
 * @Version 1.0
 */
@Data
@Entity
@Table(name = "tb_problem")
@EntityListeners(AuditingEntityListener.class)
public class Problem {

    @Id
    private String id;

    // 问题标题
    private String title;

    // 问题内容
    private String content;

    // 发布时间
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date createtime;

    // 更新时间
    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date updatetime;

    // 发布人id
    private String userid;

    // 发布人昵称
    private String nickname;

    // 浏览量
    private Integer visits;

    // 点赞数
    private Integer thumbup;

    // 回复数
    private Integer reply;

    // 是否解决：0解决，1未解决
    private String solve;

    // 最新回复人
    private String replyname;

    // 最新回复时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date replytime;

}
