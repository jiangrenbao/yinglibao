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

 Date: 30/11/2021 11:22:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for recharge_record
-- ----------------------------
DROP TABLE IF EXISTS `recharge_record`;
CREATE TABLE `recharge_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `u_id` int(11) NOT NULL COMMENT '用户id',
  `recharge_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '充值订单号',
  `recharge_status` int(1) NOT NULL COMMENT '充值订单状态（0充值中，1充值成功，2充值失败）',
  `recharge_money` decimal(11, 2) NOT NULL COMMENT '充值金额',
  `recharge_time` datetime(0) NOT NULL COMMENT '充值时间',
  `recharge_desc` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '充值描述',
  `channel` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 66 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '充值记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of recharge_record
-- ----------------------------
INSERT INTO `recharge_record` VALUES (1, 1, '1501489834609', 0, 0.01, '2017-07-31 16:30:35', '支付购买理财产品', '');
INSERT INTO `recharge_record` VALUES (2, 1, '1501490635719', 0, 0.01, '2017-07-31 16:43:56', '支付购买理财产品', '');
INSERT INTO `recharge_record` VALUES (3, 1, '1501490823263', 1, 0.01, '2017-07-31 16:47:03', '支付购买理财产品', '');
INSERT INTO `recharge_record` VALUES (4, 1, '1501491112382', 1, 0.01, '2017-07-31 16:51:52', '支付购买理财产品', '');
INSERT INTO `recharge_record` VALUES (5, 1, '1501725717869', 0, 1.11, '2017-08-03 10:01:58', '支付购买理财产品', '');
INSERT INTO `recharge_record` VALUES (6, 1, '1501725981036', 0, 0.01, '2017-08-03 10:06:21', '支付购买理财产品', '');
INSERT INTO `recharge_record` VALUES (7, 1, '1501726137193', 0, 0.01, '2017-08-03 10:08:57', '支付购买理财产品', '');
INSERT INTO `recharge_record` VALUES (8, 1, '1501727489369', 0, 1.12, '2017-08-03 10:31:29', '支付购买理财产品', '');
INSERT INTO `recharge_record` VALUES (9, 1, '1501728006875', 0, 0.01, '2017-08-03 10:40:07', '支付购买理财产品', '');
INSERT INTO `recharge_record` VALUES (10, 1, '1501728016965', 0, 0.01, '2017-08-03 10:40:17', '支付购买理财产品', '');
INSERT INTO `recharge_record` VALUES (11, 1, '1501728034093', 0, 0.01, '2017-08-03 10:40:34', '支付购买理财产品', '');
INSERT INTO `recharge_record` VALUES (12, 1, '1501728037262', 0, 0.01, '2017-08-03 10:40:37', '支付购买理财产品', '');
INSERT INTO `recharge_record` VALUES (13, 1, '1501728122258', 0, 1.00, '2017-08-03 10:42:02', '支付购买理财产品', '');
INSERT INTO `recharge_record` VALUES (14, 1, '1501728548630', 0, 0.01, '2017-08-03 10:49:09', '支付购买理财产品', '');
INSERT INTO `recharge_record` VALUES (15, 1, '1501728608962', 0, 0.01, '2017-08-03 10:50:09', '支付购买理财产品', '');
INSERT INTO `recharge_record` VALUES (16, 1, '1501728869884', 0, 0.01, '2017-08-03 10:54:30', '支付购买理财产品', '');
INSERT INTO `recharge_record` VALUES (17, 1, '1501728901531', 0, 0.01, '2017-08-03 10:55:02', '支付购买理财产品', '');
INSERT INTO `recharge_record` VALUES (18, 1, '1501728950112', 0, 0.01, '2017-08-03 10:55:50', '支付购买理财产品', '');
INSERT INTO `recharge_record` VALUES (19, 1, '1501728973824', 0, 0.01, '2017-08-03 10:56:14', '支付购买理财产品', '');
INSERT INTO `recharge_record` VALUES (20, 1, '1501729000664', 0, 0.01, '2017-08-03 10:56:41', '支付购买理财产品', '');
INSERT INTO `recharge_record` VALUES (21, 1, '1501729245978', 0, 0.01, '2017-08-03 11:00:46', '支付购买理财产品', '');
INSERT INTO `recharge_record` VALUES (22, 1, '1501729256515', 0, 0.01, '2017-08-03 11:00:57', '支付购买理财产品', '');
INSERT INTO `recharge_record` VALUES (23, 27, '1502021222705', 0, 0.01, '2017-08-06 20:07:03', '支付购买理财产品', '');
INSERT INTO `recharge_record` VALUES (24, 27, '1502023873391', 1, 0.01, '2017-08-06 20:51:13', '支付购买理财产品', '');
INSERT INTO `recharge_record` VALUES (25, 27, '1502024156914', 1, 0.01, '2017-08-06 20:55:57', '支付购买理财产品', '');
INSERT INTO `recharge_record` VALUES (26, 27, '1502448608243', 0, 0.10, '2017-08-11 18:50:08', '支付购买理财产品', '');
INSERT INTO `recharge_record` VALUES (27, 27, '1502448646236', 1, 0.01, '2017-08-11 18:50:46', '支付购买理财产品', '');
INSERT INTO `recharge_record` VALUES (28, 27, '1502449864723', 0, 0.01, '2017-08-11 19:11:05', '支付购买理财产品', '');
INSERT INTO `recharge_record` VALUES (29, 27, '1502500509727', 0, 0.01, '2017-08-12 09:15:10', '支付购买理财产品', '');
INSERT INTO `recharge_record` VALUES (30, 27, '1502519856863', 1, 0.01, '2017-08-12 14:37:37', '支付理财', '');
INSERT INTO `recharge_record` VALUES (31, 27, '1502866468501', 0, 0.01, '2017-08-16 14:54:29', '支付理财', '');
INSERT INTO `recharge_record` VALUES (32, 27, '1502868127518', 1, 0.01, '2017-08-16 15:22:08', '支付理财', '');
INSERT INTO `recharge_record` VALUES (33, 27, '1502868638430', 0, 0.01, '2017-08-16 15:30:38', '支付理财', '');
INSERT INTO `recharge_record` VALUES (34, 27, '1502868724312', 1, 0.01, '2017-08-16 15:32:04', '支付理财', '');
INSERT INTO `recharge_record` VALUES (35, 27, '1502872591807', 1, 0.01, '2017-08-16 16:36:32', '支付理财', '');
INSERT INTO `recharge_record` VALUES (36, 27, '1502873319830', 1, 0.01, '2017-08-16 16:48:40', '支付理财', '');
INSERT INTO `recharge_record` VALUES (37, 27, '1502873758936', 1, 0.01, '2017-08-16 16:55:59', '支付理财', '');
INSERT INTO `recharge_record` VALUES (38, 27, '1502874561626', 1, 0.01, '2017-08-16 17:09:22', '支付理财', '');
INSERT INTO `recharge_record` VALUES (39, 27, '1502874731033', 1, 0.01, '2017-08-16 17:12:11', '支付理财', '');
INSERT INTO `recharge_record` VALUES (40, 27, '1502879206156', 1, 0.01, '2017-08-16 18:26:46', '支付理财', '');
INSERT INTO `recharge_record` VALUES (41, 27, '1502880241719', 0, 0.01, '2017-08-16 18:44:02', '支付理财', '');
INSERT INTO `recharge_record` VALUES (42, 27, '1502880393830', 0, 0.01, '2017-08-16 18:46:34', '支付理财', '');
INSERT INTO `recharge_record` VALUES (43, 27, '201708181730337311', 0, 0.01, '2017-08-18 17:30:50', '支付理财', '');
INSERT INTO `recharge_record` VALUES (44, 27, '201708181741346741', 0, 0.01, '2017-08-18 17:42:34', '支付理财', '');
INSERT INTO `recharge_record` VALUES (45, 27, '201708181743079162', 0, 0.01, '2017-08-18 17:43:43', '支付理财', '');
INSERT INTO `recharge_record` VALUES (46, 27, '201708181743519043', 0, 0.01, '2017-08-18 17:43:58', '支付理财', '');
INSERT INTO `recharge_record` VALUES (47, 27, '201708181744042114', 0, 0.01, '2017-08-18 17:44:16', '支付理财', '');
INSERT INTO `recharge_record` VALUES (48, 27, '201708191759589502', 0, 0.01, '2017-08-19 17:59:59', '支付理财', '');
INSERT INTO `recharge_record` VALUES (49, 27, '201708191800535053', 0, 0.01, '2017-08-19 18:00:54', '支付理财', '');
INSERT INTO `recharge_record` VALUES (50, 27, '201708191801379264', 0, 0.01, '2017-08-19 18:01:38', '支付理财', '');
INSERT INTO `recharge_record` VALUES (51, 27, '201708201135431175', 0, 0.01, '2017-08-20 11:35:43', '支付理财', '');
INSERT INTO `recharge_record` VALUES (52, 27, '201708201136258596', 1, 0.01, '2017-08-20 11:36:26', '支付理财', '');
INSERT INTO `recharge_record` VALUES (53, 27, '202101070421195', 1, 10.00, '2021-01-07 12:21:19', '使用支付宝充值', 'alipay');
INSERT INTO `recharge_record` VALUES (54, 27, '202101070640146', 1, 2.00, '2021-01-07 14:40:14', '使用支付宝充值', 'alipay');
INSERT INTO `recharge_record` VALUES (55, 27, '202101070644057', 1, 6.00, '2021-01-07 14:44:05', '使用支付宝充值', 'alipay');
INSERT INTO `recharge_record` VALUES (56, 27, '202101070648368', 1, 3.00, '2021-01-07 14:48:36', '使用支付宝充值', 'alipay');
INSERT INTO `recharge_record` VALUES (57, 27, '202101070734309', 1, 1.00, '2021-01-07 15:34:30', '使用支付宝充值', 'alipay');
INSERT INTO `recharge_record` VALUES (58, 27, '2021010707370010', 1, 1.00, '2021-01-07 15:37:00', '使用支付宝充值', 'alipay');
INSERT INTO `recharge_record` VALUES (59, 27, '2021010707412511', 1, 1.00, '2021-01-07 15:41:25', '使用支付宝充值', 'alipay');
INSERT INTO `recharge_record` VALUES (60, 27, '2021010708002612', 1, 5.00, '2021-01-07 16:00:26', '使用支付宝充值', 'alipay');
INSERT INTO `recharge_record` VALUES (61, 27, '2021010807105486912', 0, 1.00, '2021-01-08 15:10:54', '动力微信支付', 'weixin');
INSERT INTO `recharge_record` VALUES (62, 27, '2021010807171386013', 0, 1.00, '2021-01-08 15:17:13', '动力微信支付', 'weixin');
INSERT INTO `recharge_record` VALUES (63, 27, '2021010807174958814', 0, 1.00, '2021-01-08 15:17:49', '动力微信支付', 'weixin');
INSERT INTO `recharge_record` VALUES (64, 27, '2021010807210029615', 0, 1.00, '2021-01-08 15:21:00', '动力微信支付', 'weixin');
INSERT INTO `recharge_record` VALUES (65, 1, '2021010808064949316', 1, 1.00, '2021-01-08 16:06:49', '动力微信支付', 'weixin');

SET FOREIGN_KEY_CHECKS = 1;
