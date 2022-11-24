package com.lp.base.dao;

import com.lp.base.pojo.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author lipeng
 * @Date 2022/11/18 14:19
 * @Version 1.0
 */
public interface ReplyDao extends JpaRepository<Reply, String>, JpaSpecificationExecutor<Reply> {


}
