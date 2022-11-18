package base.com.lp.dao;

import base.com.lp.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author lipeng
 * @Date 2022/11/15 15:44
 * @Version 1.0
 */
public interface LabelDao extends JpaRepository<Label,String>, JpaSpecificationExecutor<Label> {
}
