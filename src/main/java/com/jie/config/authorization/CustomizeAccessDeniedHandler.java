package com.jie.config.authorization;

import com.alibaba.fastjson.JSON;
import com.jie.response.ResponseResult;
import com.jie.response.ResultCode;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 权限拒绝处理逻辑
 */
@Component
public class CustomizeAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {

        // 设置转态为403
        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        //响应用户没有权限
        ResponseResult result = ResponseResult.error(ResultCode.NO_PERMISSION);
        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(result));
    }
}
