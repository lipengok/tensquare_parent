package com.lp.jwt;

import com.lp.common.entity.Result;
import com.lp.common.entity.StatusCode;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Author lipeng
 * @Date 2022/12/7 9:17
 * @Version 1.0
 */
@Slf4j
@Component
@PropertySource("classpath:jwt/jwt.properties")
public class JwtOpera {

    @Value("${jwt.key}")
    private String key;

    @Value("${jwt.ttl}")
    private long ttl;  // 过期时间

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public long getTtl() {
        return ttl;
    }

    public void setTtl(long ttl) {
        this.ttl = ttl;
    }

    /**
     * 生成token
     *
     * @param id
     * @param subject
     * @param roles
     * @return
     */
    public String createJWT(String id, String subject, String roles) {
        log.info("key[{}],ttl[{}]",key,ttl);
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        JwtBuilder builder = Jwts.builder().setId(id)
                .setSubject(subject)
                .setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS256, key)
                .claim("roles", roles);
        if (ttl > 0) {
            builder.setExpiration(new Date(nowMillis + ttl));
        }
        return builder.compact();
    }

    /**
     * 解析token
     *
     * @param jwtStr
     * @return
     */
    public Claims parseJWT(String jwtStr) {
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(jwtStr)
                .getBody();
    }

    public boolean checkPower(HttpServletRequest request){
        //获取头信息
        String authHeader = request.getHeader("Authorization");
        if(authHeader==null){
            return false;
        }
        if(!authHeader.startsWith("Bearer ")){
            return false;
        }
        String token=authHeader.substring(7);//提取token
        Claims claims = parseJWT(token);
        if(claims==null){
            return false;
        }
        if(!"admin".equals(claims.get("roles"))){
            return false;
        }
        return true;
    }
}
