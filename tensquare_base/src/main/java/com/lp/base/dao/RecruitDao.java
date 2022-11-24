package com.lp.base.dao;

import com.lp.base.pojo.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/11/17 10:42
 * @Version 1.0
 */
public interface RecruitDao extends JpaRepository<Recruit,String>, JpaSpecificationExecutor<Recruit> {
    /**
     * 查询最新职位列表(按创建日期降序排序)
     * @return
     */
    @Query(value = "select r from Recruit r where r.state = ?1")
    List<Recruit> findTop4ByStateOrderByCreatetimeDesc(String state);
}
