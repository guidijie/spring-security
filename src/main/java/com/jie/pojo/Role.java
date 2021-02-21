package com.jie.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    private int id;
    private String rName;  // 角色名称
    private String rDescribe;  //描述
    private Set<Permission> permissions;
}
