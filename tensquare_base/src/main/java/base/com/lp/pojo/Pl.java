package base.com.lp.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 问题-标签关联表
 * @Author lipeng
 * @Date 2022/11/18 8:58
 * @Version 1.0
 */
@Data
@Entity
@Table(name = "tb_pl")
public class Pl {

    @Id
    private String id;

    private String problemid;
    private String labelid;

}
