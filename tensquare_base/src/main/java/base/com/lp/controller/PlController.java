package base.com.lp.controller;

import base.com.lp.service.impl.PlServiceImpl;
import common.com.lp.entity.Result;
import common.com.lp.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lipeng
 * @Date 2022/11/18 9:53
 * @Version 1.0
 */
@RestController
@RequestMapping("/pl")
public class PlController {

    @Autowired
    private PlServiceImpl plService;

    @RequestMapping(method = RequestMethod.GET, value = "/{problemid}")
    public Result labelIds(@PathVariable String problemid){
        return new Result(true, StatusCode.OK, "success", plService.labelIds(problemid));
    }
}
