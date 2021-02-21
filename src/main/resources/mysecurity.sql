/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : mysecurity

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 20/02/2021 16:54:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `p_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `p_describe` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES (1, '/delete', '删除');
INSERT INTO `t_permission` VALUES (2, '/updata', '修改');
INSERT INTO `t_permission` VALUES (3, '/add', '增加');
INSERT INTO `t_permission` VALUES (4, '/select', '查询');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `r_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `r_describe` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, '超级管理员', '超级管理员角色拥有至高无上的权限');
INSERT INTO `t_role` VALUES (2, '管理员', '管理员权限');
INSERT INTO `t_role` VALUES (3, '普通用户', '用户权限');

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `r_id` int(0) NULL DEFAULT NULL,
  `p_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
INSERT INTO `t_role_permission` VALUES (1, 1, 1);
INSERT INTO `t_role_permission` VALUES (2, 1, 2);
INSERT INTO `t_role_permission` VALUES (3, 1, 3);
INSERT INTO `t_role_permission` VALUES (4, 1, 4);
INSERT INTO `t_role_permission` VALUES (5, 2, 2);
INSERT INTO `t_role_permission` VALUES (6, 2, 3);
INSERT INTO `t_role_permission` VALUES (7, 2, 4);
INSERT INTO `t_role_permission` VALUES (8, 3, 4);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dis_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'admin', '$2a$10$cRs7CBzEfnwXOB0lHRJYDeXSGWut6wtZnO04AS.XxQlcw.g2XPkc2', 'admin');
INSERT INTO `t_user` VALUES (2, 'jie', '$2a$10$cRs7CBzEfnwXOB0lHRJYDeXSGWut6wtZnO04AS.XxQlcw.g2XPkc2', '你来啦');
INSERT INTO `t_user` VALUES (3, 'zhangsan', '$2a$10$cRs7CBzEfnwXOB0lHRJYDeXSGWut6wtZnO04AS.XxQlcw.g2XPkc2', '往事随风');
INSERT INTO `t_user` VALUES (4, 'lisi', '$2a$10$cRs7CBzEfnwXOB0lHRJYDeXSGWut6wtZnO04AS.XxQlcw.g2XPkc2', '嘿哈');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `u_id` int(0) NULL DEFAULT NULL,
  `r_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES (1, 1, 1);
INSERT INTO `t_user_role` VALUES (2, 2, 2);
INSERT INTO `t_user_role` VALUES (3, 3, 3);
INSERT INTO `t_user_role` VALUES (4, 4, 3);

SET FOREIGN_KEY_CHECKS = 1;
