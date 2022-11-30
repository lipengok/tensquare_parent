package com.lp.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author lipeng
 * @Date 2022/11/30 11:27
 * @Version 1.0
 */
@Data
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    private String id;

    // 手机号
    private String mobile;

    // 关注数
    private Integer followCount;

    // 粉丝数
    private Integer fansCount;

    // 在线时长
    private Long online;

    // 更新日期
    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updDate;

    // 注册日期
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date regDate;

    // 最后登录时间
    private Date lastDate;
}
