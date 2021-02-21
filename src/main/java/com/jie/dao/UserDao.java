package com.jie.dao;

import com.jie.pojo.User;

public interface UserDao {

    //  按照名称查询用户
    User findUserByUsername(String name);

}
