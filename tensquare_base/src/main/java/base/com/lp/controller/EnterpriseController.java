package base.com.lp.controller;

import base.com.lp.service.EnterpriseService;
import base.com.lp.service.impl.EnterpriseServiceImpl;
import common.com.lp.entity.Result;
import common.com.lp.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lipeng
 * @Date 2022/11/17 14:45
 * @Version 1.0
 */
@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {
    @Autowired
    private EnterpriseServiceImpl enterpriseService;

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public Result findAll(){
        return new Result(true, StatusCode.OK, "success", enterpriseService.findAll());
    }
}
