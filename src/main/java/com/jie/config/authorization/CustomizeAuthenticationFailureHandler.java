package com.jie.config.authorization;

import com.alibaba.fastjson.JSON;
import com.jie.response.ResponseResult;
import com.jie.response.ResultCode;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* 登录失败处理
* */
@Configuration
public class CustomizeAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        ResponseResult result = null;

        if (e instanceof AccountExpiredException) {
            //账号过期
            result = ResponseResult.error(ResultCode.USER_ACCOUNT_EXPIRED);
        } else if (e instanceof BadCredentialsException) {
            //密码错误
            result = ResponseResult.error(ResultCode.USER_CREDENTIALS_ERROR);
        } else if (e instanceof CredentialsExpiredException) {
            //密码过期
            result = ResponseResult.error(ResultCode.USER_CREDENTIALS_EXPIRED);
        } else if (e instanceof DisabledException) {
            //账号不可用
            result = ResponseResult.error(ResultCode.USER_ACCOUNT_DISABLE);
        } else if (e instanceof LockedException) {
            //账号锁定
            result = ResponseResult.error(ResultCode.USER_ACCOUNT_LOCKED);
        } else if (e instanceof InternalAuthenticationServiceException) {
            //用户不存在
            result = ResponseResult.error(ResultCode.USER_ACCOUNT_NOT_EXIST);
        } else {
            //其他错误
            result = ResponseResult.error(ResultCode.FAIL);
        }

        // 失败了就响应
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(result));
    }
}
