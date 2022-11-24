package com.lp.base.service.impl;

import com.lp.base.dao.PlDao;
import com.lp.base.service.PlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/11/18 9:43
 * @Version 1.0
 */
@Service
@Slf4j
public class PlServiceImpl implements PlService {

    @Autowired
    private PlDao plDao;

    public List<String> labelIds(String problemid){
        List<String> labelIds = plDao.labelIds(problemid);
        log.debug("problemid=>[{}], labelids=>[{}]", problemid, labelIds);
        return labelIds;
    }
}
