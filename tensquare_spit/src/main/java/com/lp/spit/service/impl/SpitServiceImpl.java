package com.lp.spit.service.impl;

import com.lp.spit.dao.SpitDao;
import com.lp.spit.pojo.Spit;
import com.lp.spit.service.SpitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/11/24 9:58
 * @Version 1.0
 */
@Service
public class SpitServiceImpl implements SpitService {

    @Autowired
    private SpitDao spitDao;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 查询全部记录
     * @return
     */
    public List<Spit> findAll() {
        return spitDao.findAll();
    }

    /**
     * 根据主键查询实体
     * @param id
     * @return
     */
    public Spit findById(String id) {
        Spit spit = spitDao.findOne(id);
        return spit;
    }

    /**
     * 增加
     * @param spit
     */
    public void add(Spit spit) {
        spitDao.save(spit);
    }

    /**
     * 修改
     * @param spit
     */
    public void update(Spit spit) {
        spitDao.save(spit);
    }

    /**
     * 删除
     * @param id
     */
    public void deleteById(String id) {
        spitDao.delete(id);
    }

    /**
     * 根据上级ID查询吐槽列表
     * @param parentid
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<Spit> findByParentid(String parentid,int page, int size){
        PageRequest pageRequest = new PageRequest(page, size);
        return spitDao.findByParentid(parentid, pageRequest);
    }

    /**
     * 点赞
     * @param id
     */
    @Override
    public void updateThumbup(String id){
        Spit spit = findById(id);
        spit.setThumbup(spit.getThumbup()+1);
        spitDao.save(spit);
    }

    /**
     * 点赞，执行效率更高
     * @param id
     */
    public void updateThumbupPlus(String id){
        Query query=new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Update update=new Update();
        update.inc("thumbup",1);
        mongoTemplate.updateFirst(query,update,"spit");
    }
}
