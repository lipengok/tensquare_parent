package com.lp.config;

import com.lp.filter.PowerFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 拦截器配置
 *
 * @Author lipeng
 * @Date 2022/12/7 14:30
 * @Version 1.0
 */
@Configuration
public class FilterConfig extends WebMvcConfigurationSupport {

    @Autowired
    private PowerFilter powerFilter;

    /**
     * 拦截/不拦截路径配置
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(powerFilter).
                addPathPatterns("/**").
                // 登录接口不拦截
                        excludePathPatterns("/**/login").
                excludePathPatterns("/**/loginByMobile").
                excludePathPatterns("/**/loginByName");
    }
}
