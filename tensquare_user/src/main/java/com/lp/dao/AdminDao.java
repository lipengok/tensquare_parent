package com.lp.dao;

import com.lp.pojo.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author lipeng
 * @Date 2022/12/5 10:51
 * @Version 1.0
 */
public interface AdminDao  extends JpaRepository<Admin, String>, JpaSpecificationExecutor<Admin> {

    Admin findByName(String name);
}
