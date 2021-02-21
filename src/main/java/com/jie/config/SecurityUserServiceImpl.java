package com.jie.config;

import com.jie.pojo.Permission;
import com.jie.pojo.Role;
import com.jie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/*
*   用户登录逻辑
* */
@Component()
public class SecurityUserServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    //根据用户名查询用户信息，username就是前端传过来的用户名
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.jie.pojo.User user = userService.findUserByUsername(username);

        //远程调用用户服务，根据用户名查询用户信息
        if(user == null ){
            //用户名不存在，抛出异常UsernameNotFoundException
            return null;
        }

        // 存储权限
        List<GrantedAuthority> list = new ArrayList<>();
        // 获取用户角色
        Set<Role> roles = user.getRoles();
        // 遍历角色
        for(Role role : roles){
            // 根据角色获取相应的权限
            Set<Permission> permissions = role.getPermissions();
            for(Permission permission : permissions){
                //存储权限
                list.add(new SimpleGrantedAuthority(permission.getPName()));
            }
        }

        //  返回用户及权限
        return new User(username,user.getPassword(),list);
    }
}
