/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.3.200_3306
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : 192.168.3.200:3306
 Source Schema         : mybatis-test

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 01/01/2025 11:18:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_employee
-- ----------------------------
DROP TABLE IF EXISTS `t_employee`;
CREATE TABLE `t_employee`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `real_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `sex` int(0) NOT NULL,
  `birthday` date NOT NULL,
  `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `position` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '职位',
  `note` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_employee
-- ----------------------------
INSERT INTO `t_employee` VALUES (1, '小明', 0, '2024-12-04', '123', 'xiaoming', '工程师', '1');
INSERT INTO `t_employee` VALUES (2, '小红', 1, '2024-12-05', '456', 'xiaohong', '设计师', '2');

-- ----------------------------
-- Table structure for t_employee_task
-- ----------------------------
DROP TABLE IF EXISTS `t_employee_task`;
CREATE TABLE `t_employee_task`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `emp_id` int(0) NOT NULL,
  `task_id` int(0) NOT NULL,
  `task_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `note` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_Reference_4`(`emp_id`) USING BTREE,
  INDEX `FK_Reference_8`(`task_id`) USING BTREE,
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`emp_id`) REFERENCES `t_employee` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`task_id`) REFERENCES `t_task` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_employee_task
-- ----------------------------
INSERT INTO `t_employee_task` VALUES (1, 1, 1, '讨论研发方案', NULL);
INSERT INTO `t_employee_task` VALUES (2, 2, 1, '讨论研发方案', NULL);
INSERT INTO `t_employee_task` VALUES (3, 1, 3, '选择架构', NULL);

-- ----------------------------
-- Table structure for t_female_health_form
-- ----------------------------
DROP TABLE IF EXISTS `t_female_health_form`;
CREATE TABLE `t_female_health_form`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `emp_id` int(0) NOT NULL,
  `heart` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '心',
  `liver` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '肝',
  `spleen` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '脾',
  `lung` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '肺',
  `kidney` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '肾',
  `uterus` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '前列腺',
  `note` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_Reference_5`(`emp_id`) USING BTREE,
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`emp_id`) REFERENCES `t_employee` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_female_health_form
-- ----------------------------
INSERT INTO `t_female_health_form` VALUES (1, 2, '1', '1', '1', '1', '1', 'UTERUS', NULL);
INSERT INTO `t_female_health_form` VALUES (2, 2, '2', '2', '2', '2', '2', 'UTERUS', NULL);

-- ----------------------------
-- Table structure for t_male_health_form
-- ----------------------------
DROP TABLE IF EXISTS `t_male_health_form`;
CREATE TABLE `t_male_health_form`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `emp_id` int(0) NOT NULL,
  `heart` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '心',
  `liver` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '肝',
  `spleen` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '脾',
  `lung` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '肺',
  `kidney` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '肾',
  `prostate` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '子宫',
  `note` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_Reference_6`(`emp_id`) USING BTREE,
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`emp_id`) REFERENCES `t_employee` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_male_health_form
-- ----------------------------
INSERT INTO `t_male_health_form` VALUES (1, 1, '1', '1', '1', '1', '1', 'PROSTATE', NULL);

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `note` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, 'role_name_1', 'note_1');
INSERT INTO `t_role` VALUES (2, 'role_name_2', 'note_2');
INSERT INTO `t_role` VALUES (3, 'role_name_3', 'note_3');
INSERT INTO `t_role` VALUES (7, 'role_name_5', 'note_5');
INSERT INTO `t_role` VALUES (8, 'role_name_5', 'note_5');
INSERT INTO `t_role` VALUES (14, 'role_name', 'note');

-- ----------------------------
-- Table structure for t_task
-- ----------------------------
DROP TABLE IF EXISTS `t_task`;
CREATE TABLE `t_task`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `title` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `context` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `note` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_task
-- ----------------------------
INSERT INTO `t_task` VALUES (1, '讨论研发方案', '运营部、产品部和开发部需要派出代表与客户开会讨论方案', '111');
INSERT INTO `t_task` VALUES (2, '编写PD', '产品负责人给出方案', NULL);
INSERT INTO `t_task` VALUES (3, '选择架构', '研发负责人根据需求设计开发架构', NULL);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `real_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `sex` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `moble` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `note` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `index_user`(`user_name`, `real_name`, `sex`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'user_name1', 'real_name1', '1', '123', '123', '1');
INSERT INTO `t_user` VALUES (2, 'user_name2', 'real_name2', '0', '234', '234', '2');
INSERT INTO `t_user` VALUES (3, 'user_name3', 'real_name3', 'FEMALE', '345', '345', '3');
INSERT INTO `t_user` VALUES (4, 'user_name4', 'real_name4', 'MALE', '456', '456', '4');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` int(0) NOT NULL,
  `role_id` int(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_id`(`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES (1, 1, 1);
INSERT INTO `t_user_role` VALUES (2, 1, 2);
INSERT INTO `t_user_role` VALUES (4, 1, 3);
INSERT INTO `t_user_role` VALUES (3, 2, 1);
INSERT INTO `t_user_role` VALUES (5, 2, 3);
INSERT INTO `t_user_role` VALUES (6, 3, 2);
INSERT INTO `t_user_role` VALUES (7, 3, 3);

-- ----------------------------
-- Table structure for t_work_card
-- ----------------------------
DROP TABLE IF EXISTS `t_work_card`;
CREATE TABLE `t_work_card`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `emp_id` int(0) NOT NULL,
  `real_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `department` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `position` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '职位',
  `note` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_Reference_7`(`emp_id`) USING BTREE,
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`emp_id`) REFERENCES `t_employee` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_work_card
-- ----------------------------
INSERT INTO `t_work_card` VALUES (1, 1, '小明', '开发部', '123', '工程师', '11111');
INSERT INTO `t_work_card` VALUES (2, 2, '小红', '产品部', '456', '设计师', '22222');

SET FOREIGN_KEY_CHECKS = 1;
