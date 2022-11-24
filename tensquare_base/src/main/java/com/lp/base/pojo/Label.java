package com.lp.base.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 标签表
 * @Author lipeng
 * @Date 2022/11/15 14:55
 * @Version 1.0
 */
@Data
@Entity
@Table(name = "tb_label")
public class Label {

    @Id
    private String id;

    //标签名称
    private String labelname;

    //状态:0无效 ,1有效
    private String state;

    //是否推荐:0不推荐,1推荐
    private String recommend;

    //使用数量
    private Long count;

    //关注数
    private Long fans;
}
