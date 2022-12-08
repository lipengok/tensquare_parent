package com.lp.filter;

import com.lp.jwt.JwtOpera;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限验证拦截器
 *
 * @Author lipeng
 * @Date 2022/12/7 14:29
 * @Version 1.0
 */
@Slf4j
@Component
public class PowerFilter extends HandlerInterceptorAdapter {
    @Autowired
    private JwtOpera jwtOpera;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        log.info("进行权限认证");
        if (jwtOpera.checkPowerOpera(request)){
            String power = request.getAttribute("admin_claims")!=null ? "admin_claims" : "user_claims";
            log.info("权限认证通过，权限级别为[{}]", power);
        }else {
            log.error("权限认证失败");
        }
        return true;
    }
}
