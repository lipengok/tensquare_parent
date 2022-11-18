package base.com.lp.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 职位表
 * @Author lipeng
 * @Date 2022/11/17 10:34
 * @Version 1.0
 */
@Data
@Entity
@Table(name = "tb_recruit")
public class Recruit {

    @Id
    private String id;

    // 招聘职位
    private String jobname;

    // 薪资范围
    private String salary;

    // 经验要求
    private String condition;

    // 学历要求
    private String education;

    // 办公地址
    private String  address;

    // 任职方式
    private String type;

    // 企业id
    private String  eid;

    // 状态：0：关闭 1:开启 2：推荐
    private String state;

    // 发布日期
    private Date createtime;

    // 原网址
    private String url;

    // 标签
    private String label;

    // 职位描述
    private String content1;

    // 职位要求
    private String content2;

}
