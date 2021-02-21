package com.jie.dao;

import com.jie.pojo.Role;

public interface RoleDao {

    //  按照用户id查询角色
    Role findRolesByUserId(int id);
}
