package base.com.lp.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 企业表
 * @Author lipeng
 * @Date 2022/11/17 10:27
 * @Version 1.0
 */
@Data
@Entity
@Table(name = "tb_enterprise")
public class Enterprise {
    @Id
    private String id;

    // 企业简介
    private String summary;

    // 企业名称
    private String name;

    // 企业地址
    private String address;

    // 企业标签：用逗号隔开
    private String labels;

    // 企业坐标：经度，纬度
    private String coordinate;

    // 企业是否是热门，0：不是，1：是。默认是0
    private String ishot;

    // 企业logo
    private String logo;

    // 职位数
    private Integer jobcount;

    // 企业网址
    private String url;
}
