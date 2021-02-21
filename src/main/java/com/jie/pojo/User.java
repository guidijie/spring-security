package com.jie.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int id;
    private String username;  // 账号名
    private String password;  // 密码
    private String disName;   // 个性名称
    private Set<Role> roles;  //角色

}
