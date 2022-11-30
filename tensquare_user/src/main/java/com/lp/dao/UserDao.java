package com.lp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.lp.pojo.User;

/**
 * @Author lipeng
 * @Date 2022/11/30 13:42
 * @Version 1.0
 */
public interface UserDao extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {
}
