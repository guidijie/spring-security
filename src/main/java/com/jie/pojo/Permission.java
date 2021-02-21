package com.jie.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 权限
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission implements Serializable{
    private int id;
    private String pName; // 权限url名称
    private String pDescribe; // 描述

}
