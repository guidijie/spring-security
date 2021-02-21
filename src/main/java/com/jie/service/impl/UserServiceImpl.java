package com.jie.service.impl;

import com.jie.dao.UserDao;
import com.jie.pojo.User;
import com.jie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service()
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User findUserByUsername(String name) {
        return userDao.findUserByUsername(name);
    }
}
