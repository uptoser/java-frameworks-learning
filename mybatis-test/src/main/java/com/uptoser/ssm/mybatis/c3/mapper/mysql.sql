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

 Date: 01/01/2025 11:16:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
-- Procedure structure for count_role
-- ----------------------------
DROP PROCEDURE IF EXISTS `count_role`;
delimiter ;;
CREATE PROCEDURE `count_role`(IN p_role_name VARCHAR(20),OUT count_total INT,OUT exec_date DATE)
BEGIN

SELECT COUNT(*) INTO count_total FROM t_role WHERE role_name LIKE CONCAT('%',p_role_name,'%');
SELECT CURDATE() INTO exec_date;

END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
