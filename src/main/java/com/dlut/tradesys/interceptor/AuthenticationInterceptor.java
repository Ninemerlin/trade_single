package com.dlut.tradesys.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.dlut.tradesys.common.pojo.result.Result;
import com.dlut.tradesys.utils.JwtUtil;
import com.dlut.tradesys.utils.UserContext;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        String url = req.getRequestURL().toString();
        log.info("URL: {}",url);

        if(url.contains("/user/login")){
            log.info("登录操作,放行.");
            return true;
        }

        if(url.contains("/user/register")){
            log.info("注册操作,放行.");
            return true;
        }

        if(url.contains("/item/itemSearch")){
            log.info("商品查询操作,放行.");
            return true;
        }

        String jwt = req.getHeader("token");
        if(!StringUtils.hasLength(jwt)){
            log.info("Token为空,未登录.");
            Result error = Result.fail().setCode(401).addMsg("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            res.getWriter().write(notLogin);
            return false;
        }

        try {
            Claims token = JwtUtil.parseJWT(jwt);
            UserContext.setUser(token.get("id", Long.class));
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析令牌失败.");
            Result error = Result.fail().setCode(401).addMsg("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            res.getWriter().write(notLogin);
            return false;
        }

        log.info("令牌: {}",jwt);
        log.info("令牌合法,放行.");
        return true;
    }
}
