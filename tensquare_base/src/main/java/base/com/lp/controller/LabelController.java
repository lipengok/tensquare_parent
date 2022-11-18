package base.com.lp.controller;

import base.com.lp.service.impl.LabelServiceImpl;
import common.com.lp.entity.Result;
import common.com.lp.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author lipeng
 * @Date 2022/11/15 15:50
 * @Version 1.0
 */
@RestController
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private LabelServiceImpl labelServiceImpl;

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
