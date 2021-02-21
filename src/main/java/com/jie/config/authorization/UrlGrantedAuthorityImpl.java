package com.jie.config.authorization;


import com.jie.dao.PermissionDao;
import com.jie.pojo.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

@Component
public class UrlGrantedAuthorityImpl implements UrlGrantedAuthority {

    @Autowired
    PermissionDao permissionDao;


    @Override
    public boolean hasAuthority(HttpServletRequest request, Authentication authentication) {
        // 获取url
        String servletPath = request.getServletPath();

        // 计数
        int num = 0;

        // 如果数据库中没有配置权限证明都能访问
        Set<Permission> permissionsAll = permissionDao.findPermissionsAll();
        for (Permission p : permissionsAll) {
            if (servletPath.equals(p.getPName())) {
                // 如果请求的url等于数据库中的url，那么nu++
                num++;
            }
        }

        // 如果num 小于等于o,证明改url不需要权限，都能访问
        if (num <= 0) {
            return true;
        } else {
            // url转换为权限类
            GrantedAuthority g = new SimpleGrantedAuthority(servletPath);
            // 判断是否有权限
            return authentication.getAuthorities().contains(g);
        }
    }
}
