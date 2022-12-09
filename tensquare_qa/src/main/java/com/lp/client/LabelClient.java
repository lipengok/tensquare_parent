package com.lp.client;

import com.lp.common.entity.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 调用 微服务tensquare-base API
 *
 * @Author lipeng
 * @Date 2022/12/8 14:16
 * @Version 1.0
 */
@FeignClient("TENSQUARE-BASE")
public interface LabelClient {

    /**
     * 根据标签id，查找标签
     *
     * @param id
     * @return
     */
    @RequestMapping(value="/label/{id}", method = RequestMethod.GET)
    Result findById(@PathVariable("id") String id);

    /**
     * 查找所有标签
     *
     * @return
     */
    @RequestMapping(value="/label/list", method = RequestMethod.GET)
    Result findByAll();
}
