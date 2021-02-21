package com.jie.config;

import com.jie.config.authorization.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    //  登陆成功处理逻辑
    @Autowired
    CustomizeAuthenticationSuccessHandler authenticationSuccessHandler;

    //  登陆失败处理逻辑
    @Autowired
    CustomizeAuthenticationFailureHandler authenticationFailureHandler;

    //  403权限拒绝处理逻辑
    @Autowired
    CustomizeAccessDeniedHandler accessDeniedHandler;

    //  匿名用户访问无权限资源时得异常
    @Autowired
    CustomizeAuthenticationEntryPoint authenticationEntryPoint;

    //  登出失败处理逻辑
    @Autowired
    CustomizeLogoutSuccessHandler logoutSuccessHandler;

    //  会话过期处理逻辑
    @Autowired
    CustomizeSessionInformationExpiredStrategy sessionInformationExpiredStrategy;



    @Bean
    public UserDetailsService userDetailsService() {
        //获取用户账号密码及权限信息
        return new SecurityUserServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // 设置默认的加密方式（强hash方式加密）
        return new BCryptPasswordEncoder();
    }


    /*
     * 认证
     * */
    @Override
    protected void configure(AuthenticationManagerBuilder http) throws Exception {
        http.userDetailsService(userDetailsService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 解决跨域
        http.cors().and().csrf().disable();

        /*
        * 登录
        * */
        http.formLogin()
                .loginPage("/toLogin")
                .loginProcessingUrl("/login")
                .permitAll()
                .successHandler(authenticationSuccessHandler)  //登录成功处理逻辑
                .failureHandler(authenticationFailureHandler);  //登录失败处理逻辑

        /*
        * 登出
        * */
        http.logout().permitAll()
                .logoutSuccessHandler(logoutSuccessHandler)  //登出成功处理逻辑
                .deleteCookies("JSESSIONID");  //登出之后删除cookie
        /*
         * 开启授权
         * */
        http.authorizeRequests()
                /*
                * 过滤静态资源
                * */
                .antMatchers("/js/**","/css/**","/img/**").permitAll()
                // springEl表达式，WebSecurityExpressionRoot中的属性都能在括号里面使用
                .antMatchers("/**").access("@urlGrantedAuthorityImpl.hasAuthority(request,authentication)");

        /*
        * 403 处理逻辑
        * */
        http.exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler) //权限拒绝处理逻辑
                .authenticationEntryPoint(authenticationEntryPoint);//匿名用户访问无权限资源时的异常处理

        /*
        * 会话管理
        * */
        http.sessionManagement()
                //同一账号同时登录最大用户数
                .maximumSessions(1)
                //会话失效(账号被挤下线)处理逻辑
                .expiredSessionStrategy(sessionInformationExpiredStrategy);

    }



}
