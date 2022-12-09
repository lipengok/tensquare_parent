package com.lp.base.controller;

import com.lp.base.dao.LabelDao;
import com.lp.base.pojo.Label;
import com.lp.base.service.impl.LabelServiceImpl;
import com.lp.common.entity.Result;
import com.lp.common.entity.StatusCode;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 微服务-标签api
 *
 * @Author lipeng
 * @Date 2022/11/15 15:50
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private LabelServiceImpl labelServiceImpl;

    @Autowired
    private LabelDao labelDao;


    /**
     * 查询所有标签
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public Result findAll(){
        return new Result(true, StatusCode.OK, "success", labelServiceImpl.findAll());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/search")
    public Result search(@RequestBody Map searchMap) throws Exception {
        searchMapCheck(searchMap);
        Result result = null;
        try {
            result = new Result(true, StatusCode.OK, "success", labelServiceImpl.search(searchMap));
        }catch (Exception e){
            result = new Result(false, StatusCode.ERROR, e.getMessage(), e);
        }finally {
            return result;
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/search/{page}/{size}")
    public Result pageSearch(@RequestBody Map searchMap, @PathVariable int page, @PathVariable int size) throws Exception {
        searchMapCheck(searchMap);
        Result result = null;
        // 页数从1开始
        page--;
        try {
            result = new Result(true, StatusCode.OK, "success", labelServiceImpl.searchPage(searchMap, page, size));
        }catch (Exception e){
            result = new Result(false, StatusCode.ERROR, e.getMessage(), null);
        }finally {
            return result;
        }
    }

    /**
     * 根据标签id，查找标签
     *
     * @param id
     * @return
     */
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    Result findById(@PathVariable String id){
        log.info("根据label的id[{}]查找标签信息", id);
        try {
            Label label = labelDao.findOne(id);
            return new Result(true, StatusCode.OK, "查询成功", label);
        }catch (Exception e){
            return new Result(true, StatusCode.ERROR, "查询shi白", e.getMessage());
        }
    }

    private boolean searchMapCheck(Map searchMap) throws Exception {
        if (searchMap == null || searchMap.isEmpty() || searchMap.size() < 1){
            throw new Exception("查询条件不能为空");
        }
        if (searchMap.get("labelname") == null){
            throw new Exception("缺少labelname字段");
        }
        if (searchMap.get("state") == null){
            throw new Exception("缺少state字段");
        }
        if (searchMap.get("recommend") == null){
            throw new Exception("缺少recommend字段");
        }
        return true;
    }
}
