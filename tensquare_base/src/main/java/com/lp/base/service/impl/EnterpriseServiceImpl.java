package com.lp.base.service.impl;

import com.lp.base.dao.EnterpriseDao;
import com.lp.base.pojo.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/11/17 10:40
 * @Version 1.0
 */
@Service
public class EnterpriseServiceImpl {

    @Autowired
    private EnterpriseDao enterpriseDao;

    /**
     * 企业列表
     * @return
     */
    public List<Enterprise> findAll(){
        return enterpriseDao.findAll();
    }

    /**
     * 热门企业列表
     * @return
     */
    public List<Enterprise> hotlist(){
        return enterpriseDao.findByIshot("1");
    }
}
