package com.jie.config.authorization;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface UrlGrantedAuthority {

    public boolean hasAuthority(HttpServletRequest request, Authentication authentication);
}
