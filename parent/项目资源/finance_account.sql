/*
 Navicat Premium Data Transfer

 Source Server         : Linux5.5版本
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : 192.168.159.128:3306
 Source Schema         : yinglibao

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 30/11/2021 11:20:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for finance_account
-- ----------------------------
DROP TABLE IF EXISTS `finance_account`;
CREATE TABLE `finance_account`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `u_id` int(11) NOT NULL COMMENT '用户ID',
  `available_money` decimal(11, 2) NOT NULL COMMENT '用户可用资金',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户财务资金账户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of finance_account
-- ----------------------------
INSERT INTO `finance_account` VALUES (1, 1, 994949.61);
INSERT INTO `finance_account` VALUES (2, 5, 999999800.00);
INSERT INTO `finance_account` VALUES (3, 23, 688.00);
INSERT INTO `finance_account` VALUES (4, 24, 888.00);
INSERT INTO `finance_account` VALUES (5, 25, 888.00);
INSERT INTO `finance_account` VALUES (6, 26, 992.37);
INSERT INTO `finance_account` VALUES (7, 27, 1356.87);
INSERT INTO `finance_account` VALUES (8, 42, 888.00);
INSERT INTO `finance_account` VALUES (9, 43, 888.00);
INSERT INTO `finance_account` VALUES (10, 44, 888.00);
INSERT INTO `finance_account` VALUES (11, 45, 888.00);
INSERT INTO `finance_account` VALUES (12, 46, 888.00);
INSERT INTO `finance_account` VALUES (13, 47, 888.00);
INSERT INTO `finance_account` VALUES (14, 48, 888.00);
INSERT INTO `finance_account` VALUES (15, 49, 888.00);
INSERT INTO `finance_account` VALUES (18, 52, 888.00);
INSERT INTO `finance_account` VALUES (19, 53, 888.00);

SET FOREIGN_KEY_CHECKS = 1;
