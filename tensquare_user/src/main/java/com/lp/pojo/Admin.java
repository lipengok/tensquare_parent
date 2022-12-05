package com.lp.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * 管理员
 *
 * @Author lipeng
 * @Date 2022/12/5 10:47
 * @Version 1.0
 */
@Data
@Entity
@Table(name = "tb_admin")
@EntityListeners(AuditingEntityListener.class)
public class Admin {

    @Id
    private String id;

    private String psw;

    private String name;

    // 注册日期
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "reg_date")
    private Date regDate;

    // 更新日期
    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "upd_date")
    private Date updDate;
}
