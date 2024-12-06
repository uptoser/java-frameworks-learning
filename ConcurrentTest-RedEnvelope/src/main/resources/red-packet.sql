/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.3.200_3306
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : 192.168.3.200:3306
 Source Schema         : red-packet

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 06/12/2024 08:55:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for T_RED_PACKET
-- ----------------------------
DROP TABLE IF EXISTS `T_RED_PACKET`;
CREATE TABLE `T_RED_PACKET`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` int(0) NOT NULL,
  `amount` decimal(16, 2) NOT NULL COMMENT '红包金额',
  `send_date` timestamp(0) NOT NULL COMMENT '发红包时间',
  `total` int(0) NOT NULL COMMENT '小红包总数',
  `unit_amount` decimal(12, 0) NOT NULL COMMENT '单个小红包金额',
  `stock` int(0) NOT NULL COMMENT '剩余小红包个数',
  `version` int(0) NOT NULL DEFAULT 0 COMMENT '版本号',
  `note` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of T_RED_PACKET
-- ----------------------------
INSERT INTO `T_RED_PACKET` VALUES (1, 1, 200000.00, '2024-12-06 08:51:04', 20000, 10, 20000, 0, '20万元金额，2万个小红包，每个10元');

-- ----------------------------
-- Table structure for T_USER_RED_PACKET
-- ----------------------------
DROP TABLE IF EXISTS `T_USER_RED_PACKET`;
CREATE TABLE `T_USER_RED_PACKET`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `red_packet_id` int(0) NOT NULL COMMENT '红包ID',
  `user_id` int(0) NOT NULL,
  `amount` decimal(16, 2) NOT NULL COMMENT '抢红包金额',
  `grab_time` timestamp(0) NOT NULL COMMENT '抢红包时间',
  `note` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of T_USER_RED_PACKET
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
