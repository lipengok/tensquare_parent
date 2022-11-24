package com.lp.spit.service;

import com.lp.spit.pojo.Spit;
import org.springframework.data.domain.Page;

/**
 * @Author lipeng
 * @Date 2022/11/24 9:58
 * @Version 1.0
 */
public interface SpitService {

    Page<Spit> findByParentid(String parentid,int page, int size);

    void updateThumbup(String id);
}
