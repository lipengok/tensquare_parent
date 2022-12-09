package com.lp.controller;

import com.lp.client.LabelClient;
import com.lp.common.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 标签服务调用-问答api
 * @Author lipeng
 * @Date 2022/12/8 14:20
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/problem")
public class ProblemController {

    @Autowired
    private LabelClient labelClient;

    @RequestMapping(value = "/label/{id}")
    public Result findLabelById(@PathVariable("id") String id){
        log.info("调用微服务TENSQUARE-BASE");
        Result result = labelClient.findById(id);
        return result;
    }
}
