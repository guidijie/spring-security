package com.jie.service;

import com.jie.pojo.User;

public interface UserService {

    User findUserByUsername(String name);
}
