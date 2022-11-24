package com.lp.base.controller;

import com.lp.base.service.impl.RecruitServiceImpl;
import com.lp.common.entity.Result;
import com.lp.common.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author lipeng
 * @Date 2022/11/17 14:45
 * @Version 1.0
 */
@CrossOrigin // 防止跨域请求
@RestController
@RequestMapping("/recruit")
public class RecruitController {
    @Autowired
    private RecruitServiceImpl recruitService;

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public Result findAll(){
        return new Result(true, StatusCode.OK, "success", recruitService.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, value = "state/{state}")
    public Result findOpen(@PathVariable String state){
        return new Result(true, StatusCode.OK, "success", recruitService.findTop4ByStateOrderByCreatetimeDesc(state));
    }
}
