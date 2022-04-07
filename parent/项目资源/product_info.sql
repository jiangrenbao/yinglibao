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

 Date: 30/11/2021 11:22:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for product_info
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品名称',
  `rate` decimal(11, 2) NOT NULL COMMENT '产品利率',
  `cycle` int(11) NOT NULL COMMENT '产品期限',
  `release_time` date NOT NULL COMMENT '产品发布时间',
  `product_type` int(11) NOT NULL COMMENT '产品类型 0新手宝，1优选产品，2散标产品',
  `product_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品编号',
  `product_money` decimal(11, 2) NOT NULL COMMENT '产品金额',
  `left_product_money` decimal(11, 2) NOT NULL COMMENT '产品剩余可投金额',
  `invest_min_limit` decimal(11, 2) NOT NULL COMMENT '最低投资金额，即起投金额',
  `invest_max_limit` decimal(11, 2) NOT NULL COMMENT '最高投资金额，即最多能投多少金额',
  `product_status` int(11) NOT NULL COMMENT '产品状态（0未满标，1已满标，2满标已生成收益计划）',
  `product_full_time` datetime(0) NULL DEFAULT NULL COMMENT '产品投资满标时间',
  `product_desc` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品描述',
  `version` int(11) NOT NULL COMMENT '版本号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1310700 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_info
-- ----------------------------
INSERT INTO `product_info` VALUES (1, '个人信用消费借款1', 5.90, 9, '2018-07-24', 2, '20170722', 100000.00, 0.00, 100.00, 100.00, 1, '2020-12-31 14:32:41', '个人消费借款，信用良好，购车消费，精英人士', 4);
INSERT INTO `product_info` VALUES (2, '个人信用消费借款', 4.90, 6, '2017-07-24', 2, '20170722', 100000.00, 99696.00, 100.00, 100.00, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `product_info` VALUES (3, '个人信用消费借款', 4.90, 6, '2017-07-24', 2, '20170722', 100.00, 0.00, 100.00, 100.00, 1, NULL, '个人消费借款，信用良好，购车消费，精英人士', 100);
INSERT INTO `product_info` VALUES (4, '个人信用消费借款', 4.90, 6, '2017-07-24', 2, '20170722', 100.00, 0.00, 100.00, 100.00, 1, NULL, '个人消费借款，信用良好，购车消费，精英人士', 100);
INSERT INTO `product_info` VALUES (6, '个人信用消费借款', 4.90, 1, '2017-07-24', 2, '20170722', 100.00, 0.00, 100.00, 100.00, 1, '2017-07-16 16:54:06', '个人消费借款，信用良好，购车消费，精英人士', 100);
INSERT INTO `product_info` VALUES (7, '个人信用消费借款', 4.90, 6, '2017-07-24', 2, '20170722', 200.00, 0.00, 1.00, 100.00, 1, '2017-08-20 15:05:02', '个人消费借款，信用良好，购车消费，精英人士', 199);
INSERT INTO `product_info` VALUES (8, '个人信用消费借款', 4.90, 6, '2017-07-24', 2, '20170722', 100000.00, 100000.00, 100.00, 100.00, 0, '2017-02-19 11:12:12', '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `product_info` VALUES (9, '个人信用消费借款', 4.90, 6, '2017-07-24', 2, '20170722', 100000.00, 100000.00, 100.00, 100.00, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `product_info` VALUES (13, '个人信用消费借款', 4.90, 6, '2017-07-24', 2, '20170722', 100000.00, 100000.00, 100.00, 100.00, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `product_info` VALUES (14, '个人信用消费借款', 4.90, 6, '2017-07-24', 2, '20170722', 100000.00, 100000.00, 100.00, 100.00, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `product_info` VALUES (15, '27个人信用消费借款', 4.90, 6, '2017-07-24', 2, '20170722', 100000.00, 100000.00, 100.00, 100.00, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `product_info` VALUES (16, '28个人信用消费借款', 4.90, 6, '2017-07-24', 2, '20170722', 100000.00, 100000.00, 100.00, 100.00, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `product_info` VALUES (17, '29个人信用消费借款', 4.90, 6, '2017-07-24', 2, '20170722', 100000.00, 100000.00, 100.00, 100.00, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `product_info` VALUES (18, '30个人信用消费借款', 4.90, 6, '2017-07-24', 2, '20170722', 100000.00, 100000.00, 100.00, 100.00, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `product_info` VALUES (19, '31个人信用消费借款', 4.90, 6, '2017-07-24', 2, '20170722', 100000.00, 100000.00, 100.00, 100.00, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `product_info` VALUES (20, '17个人信用消费借款', 4.90, 6, '2017-07-24', 2, '20170722', 100000.00, 100000.00, 100.00, 100.00, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `product_info` VALUES (28, '16个人信用消费借款', 4.90, 6, '2017-07-24', 2, '20170722', 100000.00, 100000.00, 100.00, 100.00, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `product_info` VALUES (29, '15个人信用消费借款3', 4.90, 6, '2017-07-24', 2, '20170722', 100000.00, 100000.00, 100.00, 100.00, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `product_info` VALUES (30, '个人信用消费借款2', 5.20, 8, '2017-07-24', 2, '20170722', 50000.00, 100000.00, 100.00, 100.00, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `product_info` VALUES (31, '个人信用消费借款4', 4.90, 2, '2019-07-24', 2, '20170722', 100000.00, 100000.00, 100.00, 100.00, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `product_info` VALUES (32, '个人信用消费借款', 4.60, 6, '2019-07-24', 2, '20170722', 80000.00, 100000.00, 100.00, 100.00, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `product_info` VALUES (33, '个人信用消费借款', 4.30, 5, '2017-07-24', 2, '20170722', 20000.00, 100000.00, 100.00, 100.00, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `product_info` VALUES (34, '个人信用消费借款5', 4.90, 6, '2017-07-24', 2, '20170722', 100000.00, 100000.00, 100.00, 100.00, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `product_info` VALUES (35, '个人信用消费借款', 4.90, 6, '2017-07-24', 2, '20170722', 100000.00, 100000.00, 100.00, 100.00, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `product_info` VALUES (36, '个人信用消费借款', 4.90, 6, '2017-07-24', 2, '20170722', 100000.00, 100000.00, 100.00, 100.00, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `product_info` VALUES (37, '个人信用消费借款', 4.90, 6, '2017-07-24', 2, '20170722', 100000.00, 100000.00, 100.00, 100.00, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `product_info` VALUES (38, '9个人信用消费借款', 4.90, 6, '2017-07-24', 2, '20170722', 100000.00, 100000.00, 100.00, 100.00, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `product_info` VALUES (39, '10个人信用消费借款', 4.90, 6, '2017-07-24', 2, '20170722', 100000.00, 100000.00, 100.00, 100.00, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `product_info` VALUES (40, '11个人信用消费借款', 4.90, 6, '2017-07-24', 2, '20170722', 100000.00, 100000.00, 100.00, 100.00, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `product_info` VALUES (41, '12个人信用消费借款', 4.90, 6, '2017-07-24', 2, '20170722', 100000.00, 100000.00, 100.00, 100.00, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `product_info` VALUES (42, '13个人信用消费借款', 4.90, 6, '2017-07-24', 2, '20170722', 100000.00, 100000.00, 100.00, 100.00, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `product_info` VALUES (43, '14个人信用消费借款', 4.90, 6, '2017-07-24', 2, '20170722', 100000.00, 100000.00, 100.00, 100.00, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `product_info` VALUES (59, '32个人信用消费借款', 4.90, 6, '2017-07-24', 2, '20170722', 100000.00, 100000.00, 100.00, 100.00, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `product_info` VALUES (1310694, '满月宝', 5.60, 1, '2020-11-26', 1, '20170726', 1000000.00, 98600.00, 100.00, 100.00, 0, NULL, '短期信贷金融消费产品', 14);
INSERT INTO `product_info` VALUES (1310695, '季度宝', 5.80, 1, '2019-01-26', 1, '20170726', 1000000.00, 99900.00, 100.00, 100.00, 0, NULL, '短期信贷金融消费产品', 1);
INSERT INTO `product_info` VALUES (1310696, '双季宝', 6.50, 1, '2019-07-22', 1, '20170726', 1000000.00, 0.00, 100.00, 100.00, 1, NULL, '短期信贷金融消费产品', 0);
INSERT INTO `product_info` VALUES (1310697, '年度宝', 8.50, 1, '2020-05-18', 1, '20170726', 1000000.00, 99900.00, 100.00, 100.00, 0, NULL, '短期信贷金融消费产品', 1);
INSERT INTO `product_info` VALUES (1310699, '新手宝', 12.00, 7, '2017-07-26', 0, '20170726', 10000.00, 0.00, 100.00, 2000.00, 1, '2020-12-31 14:32:41', '短期信贷金融消费产品', 8);

SET FOREIGN_KEY_CHECKS = 1;
