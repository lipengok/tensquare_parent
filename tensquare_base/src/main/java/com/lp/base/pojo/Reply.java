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
 * 回答
 * @Author lipeng
 * @Date 2022/11/18 14:16
 * @Version 1.0
 */
@Data
@Entity
@Table(name = "tb_reply")
@EntityListeners(AuditingEntityListener.class)
public class Reply {

    @Id
    private String id;

    // 问题id
    private String problemid;

    // 回答内容
    private String content;

    // 回复时间
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date createtime;

    // 更新时间
    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date updatetime;

    // 回复人id
    private String userid;

    // 回复人昵称
    private String nickname;

}
