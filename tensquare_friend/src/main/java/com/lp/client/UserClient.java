package com.lp.client;

import com.lp.common.entity.Login;
import com.lp.common.entity.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 调用 微服务tensquare-user API
 *
 * @Author lipeng
 * @Date 2022/12/8 14:16
 * @Version 1.0
 */
@FeignClient("TENSQUARE-USER")
public interface UserClient {

    /**
     * 根据用户名登录
     *
     * @param login
     * @return
     */
    @RequestMapping(value="/user/loginByName", method = RequestMethod.POST)
    Result loginByName(@RequestBody Login login);

    /**
     * 根据手机号登录
     *
     * @param login
     * @return
     */
    @RequestMapping(value="/user/loginByMobile", method = RequestMethod.POST)
    Result loginByMobile(@RequestBody Login login);
}
