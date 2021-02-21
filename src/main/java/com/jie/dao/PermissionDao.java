package com.jie.dao;

import com.jie.pojo.Permission;

import java.util.Set;

public interface PermissionDao {

    // 根据role id查询权限
    Permission findPermissionsByRoleId(int id);

    // 查询所有权限
    Set<Permission> findPermissionsAll();
}
