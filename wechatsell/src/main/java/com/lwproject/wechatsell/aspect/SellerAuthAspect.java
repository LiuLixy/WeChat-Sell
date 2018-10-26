package com.lwproject.wechatsell.aspect;

import com.lwproject.wechatsell.util.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: LiuWang
 * @Created: 2018/8/26 15:47
 */
@Aspect
@Component
@Slf4j
public class SellerAuthAspect {

    public static final String USERNAME = "admin";
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Pointcut("execution(public * com.lwproject.wechatsell.controller.Seller*.*(..))" +
            "&& !execution(public * com.lwproject.wechatsell.controller.SellerLoginController.*(..))")
    public void verify() {
    }

    @Before("verify()")
    public void doVerify() {
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletResponse response = attributes.getResponse();
        HttpServletRequest request = attributes.getRequest();
        // 查询Cookie
        Cookie cookie = CookieUtil.get(request, USERNAME);
        if (cookie == null) {
            log.error("【登录校验】cookie为空，请重新输入");
            try {
                assert response != null;
                response.sendRedirect("/sell");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String token = redisTemplate.opsForValue().get(USERNAME);
        if (StringUtils.isEmpty(token)) {
            log.error("【登录校验】Redis中查不到指定token");
            try {
                assert response != null;
                response.sendRedirect("/sell");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        assert response != null;
        CookieUtil.set(USERNAME, token, response, 7200);
    }
}
