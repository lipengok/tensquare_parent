package com.lp.base.dao;

import com.lp.base.pojo.Pl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/11/18 9:01
 * @Version 1.0
 */
public interface PlDao extends JpaRepository<Pl, String>, JpaSpecificationExecutor<Pl> {

    /**
     * 根据问题的id，关联出所有的标签id
     * @param problemid
     * @return
     */
    @Query(value = "select p.labelid from Pl p where problemid = ?1")
    List<String>  labelIds(String problemid);
}
