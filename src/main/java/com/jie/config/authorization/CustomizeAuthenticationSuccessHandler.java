package com.jie.config.authorization;

import com.alibaba.fastjson.JSON;
import com.jie.response.ResponseResult;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* 登录成功处理
* */
@Component
public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler  {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        // 获取登录的用户
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        // 封装数据
        ResponseResult<User> success = ResponseResult.success(user);

        // 以json形式传给前端
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(success));
    }
}
