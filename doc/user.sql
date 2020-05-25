/*
 Navicat Premium Data Transfer

 Source Server         : testMysql
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : ysh-test

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 25/05/2020 15:07:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `name` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'neo', 18, 'smile1@ityouknow.com');
INSERT INTO `user` VALUES (2, 'keep', 36, 'smile2@ityouknow.com');
INSERT INTO `user` VALUES (3, 'pure', 28, 'smile3@ityouknow.com');
INSERT INTO `user` VALUES (4, 'smile', 21, 'smile4@ityouknow.com');
INSERT INTO `user` VALUES (5, 'it', 24, 'smile5@ityouknow.com');
INSERT INTO `user` VALUES (6, '张三', 18, 'zhangsan@163.com');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
