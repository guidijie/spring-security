package com.jie.config.authorization;

import com.alibaba.fastjson.JSON;
import com.jie.response.ResponseResult;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 *@Description 登出成功处理逻辑
 *@Author jin_z
 *@Date 2020/5/19 23:36
 *@since:
 *@copyright:
 */
@Component
public class CustomizeLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        ResponseResult result = ResponseResult.success();
        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(result));
    }
}
