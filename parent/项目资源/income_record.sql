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

 Date: 30/11/2021 11:21:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for income_record
-- ----------------------------
DROP TABLE IF EXISTS `income_record`;
CREATE TABLE `income_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `u_id` int(11) NOT NULL COMMENT '用户ID',
  `product_id` int(11) NOT NULL COMMENT '产品ID',
  `invest_id` int(11) NOT NULL COMMENT '投标记录ID',
  `invest_money` decimal(11, 2) NOT NULL COMMENT '投资金额',
  `income_date` date NOT NULL COMMENT '收益时间',
  `income_money` decimal(11, 2) NOT NULL COMMENT '收益金额',
  `income_status` int(11) NOT NULL COMMENT '收益状态（0未返，1已返）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 315 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '收益记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of income_record
-- ----------------------------
INSERT INTO `income_record` VALUES (203, 1, 6, 214, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (204, 1, 6, 215, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (205, 1, 6, 216, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (206, 1, 6, 217, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (207, 1, 6, 218, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (208, 1, 6, 219, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (209, 1, 6, 220, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (210, 1, 6, 221, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (211, 1, 6, 222, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (212, 1, 6, 223, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (213, 1, 6, 224, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (214, 1, 6, 225, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (215, 1, 6, 226, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (216, 1, 6, 227, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (217, 1, 6, 228, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (218, 1, 6, 229, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (219, 1, 6, 230, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (220, 1, 6, 231, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (221, 1, 6, 232, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (222, 1, 6, 233, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (223, 1, 6, 234, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (224, 1, 6, 235, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (225, 1, 6, 236, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (226, 1, 6, 237, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (227, 1, 6, 238, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (228, 1, 6, 239, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (229, 1, 6, 240, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (230, 1, 6, 241, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (231, 1, 6, 242, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (232, 1, 6, 243, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (233, 1, 6, 244, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (234, 1, 6, 245, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (235, 1, 6, 246, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (236, 1, 6, 247, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (237, 1, 6, 248, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (238, 1, 6, 249, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (239, 1, 6, 250, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (240, 1, 6, 251, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (241, 1, 6, 252, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (242, 1, 6, 253, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (243, 1, 6, 254, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (244, 1, 6, 255, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (245, 1, 6, 256, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (246, 1, 6, 257, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (247, 1, 6, 258, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (248, 1, 6, 259, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (249, 1, 6, 260, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (250, 1, 6, 261, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (251, 1, 6, 262, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (252, 1, 6, 263, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (253, 1, 6, 264, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (254, 1, 6, 265, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (255, 1, 6, 266, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (256, 1, 6, 267, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (257, 1, 6, 268, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (258, 1, 6, 269, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (259, 1, 6, 270, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (260, 1, 6, 271, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (261, 1, 6, 272, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (262, 1, 6, 273, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (263, 1, 6, 274, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (264, 1, 6, 275, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (265, 1, 6, 276, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (266, 1, 6, 277, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (267, 1, 6, 278, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (268, 1, 6, 279, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (269, 1, 6, 280, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (270, 1, 6, 281, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (271, 1, 6, 282, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (272, 1, 6, 283, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (273, 1, 6, 284, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (274, 1, 6, 285, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (275, 1, 6, 286, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (276, 1, 6, 287, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (277, 1, 6, 288, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (278, 1, 6, 289, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (279, 1, 6, 290, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (280, 1, 6, 291, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (281, 1, 6, 292, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (282, 1, 6, 293, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (283, 1, 6, 294, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (284, 1, 6, 295, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (285, 1, 6, 296, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (286, 1, 6, 297, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (287, 1, 6, 298, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (288, 1, 6, 299, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (289, 1, 6, 300, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (290, 1, 6, 301, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (291, 1, 6, 302, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (292, 1, 6, 303, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (293, 1, 6, 304, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (294, 1, 6, 305, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (295, 1, 6, 306, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (296, 1, 6, 307, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (297, 1, 6, 308, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (298, 1, 6, 309, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (299, 1, 6, 310, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (300, 2, 6, 311, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (301, 1, 6, 312, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (302, 1, 6, 313, 1.00, '2017-08-20', 0.01, 1);
INSERT INTO `income_record` VALUES (312, 27, 1, 3215, 200.00, '2021-01-05', 8.75, 1);
INSERT INTO `income_record` VALUES (313, 27, 1, 3216, 300.00, '2021-01-05', 13.12, 1);
INSERT INTO `income_record` VALUES (314, 26, 1, 3227, 100.00, '2021-01-05', 4.37, 1);

SET FOREIGN_KEY_CHECKS = 1;
