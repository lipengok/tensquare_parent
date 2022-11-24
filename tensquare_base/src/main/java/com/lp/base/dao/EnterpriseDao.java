package com.lp.base.dao;

import com.lp.base.pojo.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/11/17 10:41
 * @Version 1.0
 */
public interface EnterpriseDao extends JpaRepository<Enterprise, String>, JpaSpecificationExecutor<Enterprise> {

    /**
     * 根据热门状态获取企业列表
     *
     * @param ishot
     * @return
     */
    List<Enterprise> findByIshot(String ishot);
}
