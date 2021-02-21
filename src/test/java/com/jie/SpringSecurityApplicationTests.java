package com.jie;

import com.jie.dao.PermissionDao;
import com.jie.dao.UserDao;
import com.jie.pojo.Permission;
import com.jie.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Set;

@SpringBootTest
class SpringSecurityApplicationTests {

    @Autowired
    UserDao userDao;

    @Autowired
    PermissionDao permissionDao;


    @Test
    void contextLoads() {
        BCryptPasswordEncoder b = new BCryptPasswordEncoder();
        String root = b.encode("root");
        String root2 = b.encode("root");

        System.out.println(root);
        System.out.println(root2);
    }

}
