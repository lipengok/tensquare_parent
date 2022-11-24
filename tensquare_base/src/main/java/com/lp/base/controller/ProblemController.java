package com.lp.base.controller;

import com.lp.base.service.impl.ProblemServiceImpl;
import com.lp.common.entity.Result;
import com.lp.common.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lipeng
 * @Date 2022/11/18 10:12
 * @Version 1.0
 */
@RestController
@RequestMapping("/problem")
public class ProblemController {

    @Autowired
    private ProblemServiceImpl problemService;

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public Result findAll(){
        return new Result(true, StatusCode.OK, "success", problemService.findAll());
    }
}
