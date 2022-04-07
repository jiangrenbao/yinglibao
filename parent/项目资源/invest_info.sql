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

 Date: 30/11/2021 11:21:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for invest_info
-- ----------------------------
DROP TABLE IF EXISTS `invest_info`;
CREATE TABLE `invest_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '投标记录ID',
  `product_id` int(11) NULL DEFAULT NULL COMMENT '产品ID',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户ID',
  `invest_money` decimal(11, 2) NULL DEFAULT NULL COMMENT '投标金额',
  `invest_time` datetime(0) NULL DEFAULT NULL COMMENT '投标时间',
  `invest_status` int(11) NULL DEFAULT NULL COMMENT '投标状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3235 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '投资记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of invest_info
-- ----------------------------
INSERT INTO `invest_info` VALUES (3027, 7, 1, 1.00, '2017-08-20 15:04:54', 1);
INSERT INTO `invest_info` VALUES (3028, 7, 1, 1.00, '2017-08-20 15:04:55', 1);
INSERT INTO `invest_info` VALUES (3029, 7, 1, 1.00, '2017-08-20 15:04:55', 1);
INSERT INTO `invest_info` VALUES (3030, 7, 1, 1.00, '2017-08-20 15:04:55', 1);
INSERT INTO `invest_info` VALUES (3031, 7, 1, 1.00, '2017-08-20 15:04:55', 1);
INSERT INTO `invest_info` VALUES (3032, 7, 1, 1.00, '2017-08-20 15:04:55', 1);
INSERT INTO `invest_info` VALUES (3033, 7, 1, 1.00, '2017-08-20 15:04:55', 1);
INSERT INTO `invest_info` VALUES (3034, 7, 1, 1.00, '2017-08-20 15:04:55', 1);
INSERT INTO `invest_info` VALUES (3035, 7, 1, 1.00, '2017-08-20 15:04:55', 1);
INSERT INTO `invest_info` VALUES (3036, 7, 1, 1.00, '2017-08-20 15:04:55', 1);
INSERT INTO `invest_info` VALUES (3037, 7, 1, 1.00, '2017-08-20 15:04:55', 1);
INSERT INTO `invest_info` VALUES (3038, 7, 1, 1.00, '2017-08-20 15:04:57', 1);
INSERT INTO `invest_info` VALUES (3039, 7, 1, 1.00, '2017-08-20 15:04:56', 1);
INSERT INTO `invest_info` VALUES (3040, 7, 1, 1.00, '2017-08-20 15:04:56', 1);
INSERT INTO `invest_info` VALUES (3041, 7, 1, 1.00, '2017-08-20 15:04:56', 1);
INSERT INTO `invest_info` VALUES (3042, 7, 1, 1.00, '2017-08-20 15:04:56', 1);
INSERT INTO `invest_info` VALUES (3043, 7, 1, 1.00, '2017-08-20 15:04:56', 1);
INSERT INTO `invest_info` VALUES (3044, 7, 1, 1.00, '2017-08-20 15:04:56', 1);
INSERT INTO `invest_info` VALUES (3045, 7, 1, 1.00, '2017-08-20 15:04:56', 1);
INSERT INTO `invest_info` VALUES (3047, 7, 1, 1.00, '2017-08-20 15:04:56', 1);
INSERT INTO `invest_info` VALUES (3048, 7, 1, 1.00, '2017-08-20 15:04:56', 1);
INSERT INTO `invest_info` VALUES (3049, 7, 1, 1.00, '2017-08-20 15:04:56', 1);
INSERT INTO `invest_info` VALUES (3050, 7, 1, 1.00, '2017-08-20 15:04:56', 1);
INSERT INTO `invest_info` VALUES (3051, 7, 1, 1.00, '2017-08-20 15:04:56', 1);
INSERT INTO `invest_info` VALUES (3052, 7, 1, 1.00, '2017-08-20 15:04:56', 1);
INSERT INTO `invest_info` VALUES (3053, 7, 1, 1.00, '2017-08-20 15:04:57', 1);
INSERT INTO `invest_info` VALUES (3054, 7, 1, 1.00, '2017-08-20 15:04:56', 1);
INSERT INTO `invest_info` VALUES (3055, 7, 1, 1.00, '2017-08-20 15:04:57', 1);
INSERT INTO `invest_info` VALUES (3056, 7, 1, 1.00, '2017-08-20 15:04:57', 1);
INSERT INTO `invest_info` VALUES (3057, 7, 1, 1.00, '2017-08-20 15:04:57', 1);
INSERT INTO `invest_info` VALUES (3058, 7, 1, 1.00, '2017-08-20 15:04:57', 1);
INSERT INTO `invest_info` VALUES (3059, 7, 1, 1.00, '2017-08-20 15:04:57', 1);
INSERT INTO `invest_info` VALUES (3060, 7, 1, 1.00, '2017-08-20 15:04:57', 1);
INSERT INTO `invest_info` VALUES (3061, 7, 1, 1.00, '2017-08-20 15:04:57', 1);
INSERT INTO `invest_info` VALUES (3062, 7, 1, 1.00, '2017-08-20 15:04:56', 1);
INSERT INTO `invest_info` VALUES (3063, 7, 1, 1.00, '2017-08-20 15:04:57', 1);
INSERT INTO `invest_info` VALUES (3064, 7, 1, 1.00, '2017-08-20 15:04:57', 1);
INSERT INTO `invest_info` VALUES (3065, 7, 1, 1.00, '2017-08-20 15:04:57', 1);
INSERT INTO `invest_info` VALUES (3066, 7, 1, 1.00, '2017-08-20 15:04:57', 1);
INSERT INTO `invest_info` VALUES (3067, 7, 1, 1.00, '2017-08-20 15:04:57', 1);
INSERT INTO `invest_info` VALUES (3068, 7, 1, 1.00, '2017-08-20 15:04:57', 1);
INSERT INTO `invest_info` VALUES (3069, 7, 1, 1.00, '2017-08-20 15:04:57', 1);
INSERT INTO `invest_info` VALUES (3070, 7, 1, 1.00, '2017-08-20 15:04:58', 1);
INSERT INTO `invest_info` VALUES (3071, 7, 1, 1.00, '2017-08-20 15:04:57', 1);
INSERT INTO `invest_info` VALUES (3072, 7, 1, 1.00, '2017-08-20 15:04:57', 1);
INSERT INTO `invest_info` VALUES (3073, 7, 1, 1.00, '2017-08-20 15:04:57', 1);
INSERT INTO `invest_info` VALUES (3074, 7, 1, 1.00, '2017-08-20 15:04:58', 1);
INSERT INTO `invest_info` VALUES (3075, 7, 1, 1.00, '2017-08-20 15:04:57', 1);
INSERT INTO `invest_info` VALUES (3076, 7, 1, 1.00, '2017-08-20 15:04:58', 1);
INSERT INTO `invest_info` VALUES (3077, 7, 1, 1.00, '2017-08-20 15:04:58', 1);
INSERT INTO `invest_info` VALUES (3078, 7, 1, 1.00, '2017-08-20 15:04:58', 1);
INSERT INTO `invest_info` VALUES (3079, 7, 1, 1.00, '2017-08-20 15:04:58', 1);
INSERT INTO `invest_info` VALUES (3080, 7, 1, 1.00, '2017-08-20 15:04:58', 1);
INSERT INTO `invest_info` VALUES (3081, 7, 1, 1.00, '2017-08-20 15:04:58', 1);
INSERT INTO `invest_info` VALUES (3082, 7, 1, 1.00, '2017-08-20 15:04:58', 1);
INSERT INTO `invest_info` VALUES (3083, 7, 1, 1.00, '2017-08-20 15:04:58', 1);
INSERT INTO `invest_info` VALUES (3084, 7, 1, 1.00, '2017-08-20 15:04:58', 1);
INSERT INTO `invest_info` VALUES (3085, 7, 1, 1.00, '2017-08-20 15:04:58', 1);
INSERT INTO `invest_info` VALUES (3086, 7, 1, 1.00, '2017-08-20 15:04:58', 1);
INSERT INTO `invest_info` VALUES (3087, 7, 1, 1.00, '2017-08-20 15:04:58', 1);
INSERT INTO `invest_info` VALUES (3088, 7, 1, 1.00, '2017-08-20 15:04:58', 1);
INSERT INTO `invest_info` VALUES (3089, 7, 1, 1.00, '2017-08-20 15:04:58', 1);
INSERT INTO `invest_info` VALUES (3090, 7, 1, 1.00, '2017-08-20 15:04:58', 1);
INSERT INTO `invest_info` VALUES (3091, 7, 1, 1.00, '2017-08-20 15:04:58', 1);
INSERT INTO `invest_info` VALUES (3092, 7, 1, 1.00, '2017-08-20 15:04:58', 1);
INSERT INTO `invest_info` VALUES (3093, 7, 1, 1.00, '2017-08-20 15:04:58', 1);
INSERT INTO `invest_info` VALUES (3094, 7, 1, 1.00, '2017-08-20 15:04:59', 1);
INSERT INTO `invest_info` VALUES (3095, 7, 1, 1.00, '2017-08-20 15:04:58', 1);
INSERT INTO `invest_info` VALUES (3096, 7, 1, 1.00, '2017-08-20 15:04:58', 1);
INSERT INTO `invest_info` VALUES (3097, 7, 1, 1.00, '2017-08-20 15:04:58', 1);
INSERT INTO `invest_info` VALUES (3098, 7, 1, 1.00, '2017-08-20 15:04:58', 1);
INSERT INTO `invest_info` VALUES (3099, 7, 1, 1.00, '2017-08-20 15:04:58', 1);
INSERT INTO `invest_info` VALUES (3100, 7, 1, 1.00, '2017-08-20 15:04:58', 1);
INSERT INTO `invest_info` VALUES (3101, 7, 1, 1.00, '2017-08-20 15:04:58', 1);
INSERT INTO `invest_info` VALUES (3102, 7, 1, 1.00, '2017-08-20 15:04:58', 1);
INSERT INTO `invest_info` VALUES (3103, 7, 1, 1.00, '2017-08-20 15:04:58', 1);
INSERT INTO `invest_info` VALUES (3104, 7, 1, 1.00, '2017-08-20 15:04:59', 1);
INSERT INTO `invest_info` VALUES (3105, 7, 1, 1.00, '2017-08-20 15:04:59', 1);
INSERT INTO `invest_info` VALUES (3106, 7, 1, 1.00, '2017-08-20 15:04:59', 1);
INSERT INTO `invest_info` VALUES (3107, 7, 1, 1.00, '2017-08-20 15:04:59', 1);
INSERT INTO `invest_info` VALUES (3108, 7, 1, 1.00, '2017-08-20 15:04:59', 1);
INSERT INTO `invest_info` VALUES (3109, 7, 1, 1.00, '2017-08-20 15:04:59', 1);
INSERT INTO `invest_info` VALUES (3110, 7, 1, 1.00, '2017-08-20 15:04:59', 1);
INSERT INTO `invest_info` VALUES (3111, 7, 1, 1.00, '2017-08-20 15:04:59', 1);
INSERT INTO `invest_info` VALUES (3112, 7, 1, 1.00, '2017-08-20 15:04:59', 1);
INSERT INTO `invest_info` VALUES (3113, 7, 1, 1.00, '2017-08-20 15:05:00', 1);
INSERT INTO `invest_info` VALUES (3114, 7, 1, 1.00, '2017-08-20 15:04:59', 1);
INSERT INTO `invest_info` VALUES (3115, 7, 1, 1.00, '2017-08-20 15:04:59', 1);
INSERT INTO `invest_info` VALUES (3116, 7, 1, 1.00, '2017-08-20 15:04:59', 1);
INSERT INTO `invest_info` VALUES (3117, 7, 1, 1.00, '2017-08-20 15:04:59', 1);
INSERT INTO `invest_info` VALUES (3118, 7, 1, 1.00, '2017-08-20 15:04:59', 1);
INSERT INTO `invest_info` VALUES (3119, 7, 1, 1.00, '2017-08-20 15:04:59', 1);
INSERT INTO `invest_info` VALUES (3120, 7, 1, 1.00, '2017-08-20 15:04:59', 1);
INSERT INTO `invest_info` VALUES (3121, 7, 1, 1.00, '2017-08-20 15:04:59', 1);
INSERT INTO `invest_info` VALUES (3122, 7, 1, 1.00, '2017-08-20 15:04:59', 1);
INSERT INTO `invest_info` VALUES (3123, 7, 1, 1.00, '2017-08-20 15:04:59', 1);
INSERT INTO `invest_info` VALUES (3124, 7, 1, 1.00, '2017-08-20 15:04:59', 1);
INSERT INTO `invest_info` VALUES (3125, 7, 1, 1.00, '2017-08-20 15:04:59', 1);
INSERT INTO `invest_info` VALUES (3126, 7, 1, 1.00, '2017-08-20 15:04:59', 1);
INSERT INTO `invest_info` VALUES (3127, 7, 1, 1.00, '2017-08-20 15:04:59', 1);
INSERT INTO `invest_info` VALUES (3128, 7, 1, 1.00, '2017-08-20 15:04:59', 1);
INSERT INTO `invest_info` VALUES (3129, 7, 1, 1.00, '2017-08-20 15:04:59', 1);
INSERT INTO `invest_info` VALUES (3130, 7, 1, 1.00, '2017-08-20 15:04:59', 1);
INSERT INTO `invest_info` VALUES (3131, 7, 1, 1.00, '2017-08-20 15:04:59', 1);
INSERT INTO `invest_info` VALUES (3132, 7, 1, 1.00, '2017-08-20 15:05:00', 1);
INSERT INTO `invest_info` VALUES (3133, 7, 1, 1.00, '2017-08-20 15:04:59', 1);
INSERT INTO `invest_info` VALUES (3134, 7, 1, 1.00, '2017-08-20 15:05:00', 1);
INSERT INTO `invest_info` VALUES (3135, 7, 1, 1.00, '2017-08-20 15:05:00', 1);
INSERT INTO `invest_info` VALUES (3136, 7, 1, 1.00, '2017-08-20 15:05:00', 1);
INSERT INTO `invest_info` VALUES (3137, 7, 1, 1.00, '2017-08-20 15:05:00', 1);
INSERT INTO `invest_info` VALUES (3138, 7, 1, 1.00, '2017-08-20 15:04:59', 1);
INSERT INTO `invest_info` VALUES (3139, 7, 1, 1.00, '2017-08-20 15:05:00', 1);
INSERT INTO `invest_info` VALUES (3140, 7, 1, 1.00, '2017-08-20 15:05:00', 1);
INSERT INTO `invest_info` VALUES (3141, 7, 1, 1.00, '2017-08-20 15:05:00', 1);
INSERT INTO `invest_info` VALUES (3142, 7, 1, 1.00, '2017-08-20 15:05:00', 1);
INSERT INTO `invest_info` VALUES (3143, 7, 1, 1.00, '2017-08-20 15:05:00', 1);
INSERT INTO `invest_info` VALUES (3144, 7, 1, 1.00, '2017-08-20 15:05:00', 1);
INSERT INTO `invest_info` VALUES (3145, 7, 1, 1.00, '2017-08-20 15:05:00', 1);
INSERT INTO `invest_info` VALUES (3146, 7, 1, 1.00, '2017-08-20 15:05:00', 1);
INSERT INTO `invest_info` VALUES (3147, 7, 1, 1.00, '2017-08-20 15:05:00', 1);
INSERT INTO `invest_info` VALUES (3148, 7, 1, 1.00, '2017-08-20 15:05:00', 1);
INSERT INTO `invest_info` VALUES (3149, 7, 1, 1.00, '2017-08-20 15:05:00', 1);
INSERT INTO `invest_info` VALUES (3150, 7, 1, 1.00, '2017-08-20 15:05:00', 1);
INSERT INTO `invest_info` VALUES (3151, 7, 1, 1.00, '2017-08-20 15:05:00', 1);
INSERT INTO `invest_info` VALUES (3152, 7, 1, 1.00, '2017-08-20 15:05:00', 1);
INSERT INTO `invest_info` VALUES (3153, 7, 1, 1.00, '2017-08-20 15:05:00', 1);
INSERT INTO `invest_info` VALUES (3154, 7, 1, 1.00, '2017-08-20 15:05:00', 1);
INSERT INTO `invest_info` VALUES (3155, 7, 1, 1.00, '2017-08-20 15:05:00', 1);
INSERT INTO `invest_info` VALUES (3156, 7, 1, 1.00, '2017-08-20 15:05:00', 1);
INSERT INTO `invest_info` VALUES (3157, 7, 1, 1.00, '2017-08-20 15:04:59', 1);
INSERT INTO `invest_info` VALUES (3158, 7, 1, 1.00, '2017-08-20 15:05:00', 1);
INSERT INTO `invest_info` VALUES (3159, 7, 1, 1.00, '2017-08-20 15:05:00', 1);
INSERT INTO `invest_info` VALUES (3160, 7, 1, 1.00, '2017-08-20 15:05:00', 1);
INSERT INTO `invest_info` VALUES (3161, 7, 1, 1.00, '2017-08-20 15:05:00', 1);
INSERT INTO `invest_info` VALUES (3162, 7, 1, 1.00, '2017-08-20 15:05:00', 1);
INSERT INTO `invest_info` VALUES (3163, 7, 1, 1.00, '2017-08-20 15:05:00', 1);
INSERT INTO `invest_info` VALUES (3164, 7, 1, 1.00, '2017-08-20 15:05:01', 1);
INSERT INTO `invest_info` VALUES (3165, 7, 1, 1.00, '2017-08-20 15:05:01', 1);
INSERT INTO `invest_info` VALUES (3166, 7, 1, 1.00, '2017-08-20 15:05:01', 1);
INSERT INTO `invest_info` VALUES (3167, 7, 1, 1.00, '2017-08-20 15:05:00', 1);
INSERT INTO `invest_info` VALUES (3168, 7, 1, 1.00, '2017-08-20 15:05:01', 1);
INSERT INTO `invest_info` VALUES (3169, 7, 1, 1.00, '2017-08-20 15:05:01', 1);
INSERT INTO `invest_info` VALUES (3170, 7, 1, 1.00, '2017-08-20 15:05:01', 1);
INSERT INTO `invest_info` VALUES (3171, 7, 1, 1.00, '2017-08-20 15:05:01', 1);
INSERT INTO `invest_info` VALUES (3172, 7, 1, 1.00, '2017-08-20 15:05:01', 1);
INSERT INTO `invest_info` VALUES (3173, 7, 1, 1.00, '2017-08-20 15:05:01', 1);
INSERT INTO `invest_info` VALUES (3174, 7, 1, 1.00, '2017-08-20 15:05:01', 1);
INSERT INTO `invest_info` VALUES (3175, 7, 1, 1.00, '2017-08-20 15:05:01', 1);
INSERT INTO `invest_info` VALUES (3176, 7, 1, 1.00, '2017-08-20 15:05:01', 1);
INSERT INTO `invest_info` VALUES (3177, 7, 1, 1.00, '2017-08-20 15:05:01', 1);
INSERT INTO `invest_info` VALUES (3178, 7, 1, 1.00, '2017-08-20 15:05:01', 1);
INSERT INTO `invest_info` VALUES (3179, 7, 1, 1.00, '2017-08-20 15:05:01', 1);
INSERT INTO `invest_info` VALUES (3180, 7, 1, 1.00, '2017-08-20 15:05:01', 1);
INSERT INTO `invest_info` VALUES (3181, 7, 1, 1.00, '2017-08-20 15:05:01', 1);
INSERT INTO `invest_info` VALUES (3182, 7, 1, 1.00, '2017-08-20 15:05:01', 1);
INSERT INTO `invest_info` VALUES (3183, 7, 1, 1.00, '2017-08-20 15:05:01', 1);
INSERT INTO `invest_info` VALUES (3184, 7, 1, 1.00, '2017-08-20 15:05:01', 1);
INSERT INTO `invest_info` VALUES (3185, 7, 1, 1.00, '2017-08-20 15:05:01', 1);
INSERT INTO `invest_info` VALUES (3186, 7, 1, 1.00, '2017-08-20 15:05:01', 1);
INSERT INTO `invest_info` VALUES (3187, 7, 1, 1.00, '2017-08-20 15:05:01', 1);
INSERT INTO `invest_info` VALUES (3188, 7, 1, 1.00, '2017-08-20 15:05:01', 1);
INSERT INTO `invest_info` VALUES (3189, 7, 1, 1.00, '2017-08-20 15:05:01', 1);
INSERT INTO `invest_info` VALUES (3190, 7, 1, 1.00, '2017-08-20 15:05:01', 1);
INSERT INTO `invest_info` VALUES (3191, 7, 1, 1.00, '2017-08-20 15:05:01', 1);
INSERT INTO `invest_info` VALUES (3192, 7, 1, 1.00, '2017-08-20 15:05:01', 1);
INSERT INTO `invest_info` VALUES (3193, 7, 1, 1.00, '2017-08-20 15:05:01', 1);
INSERT INTO `invest_info` VALUES (3194, 7, 1, 1.00, '2017-08-20 15:05:01', 1);
INSERT INTO `invest_info` VALUES (3195, 7, 1, 1.00, '2017-08-20 15:05:01', 1);
INSERT INTO `invest_info` VALUES (3196, 7, 1, 1.00, '2017-08-20 15:05:02', 1);
INSERT INTO `invest_info` VALUES (3197, 7, 1, 1.00, '2017-08-20 15:05:01', 1);
INSERT INTO `invest_info` VALUES (3198, 7, 1, 1.00, '2017-08-20 15:05:02', 1);
INSERT INTO `invest_info` VALUES (3199, 7, 1, 1.00, '2017-08-20 15:05:02', 1);
INSERT INTO `invest_info` VALUES (3200, 7, 1, 1.00, '2017-08-20 15:05:02', 1);
INSERT INTO `invest_info` VALUES (3201, 7, 1, 1.00, '2017-08-20 15:05:02', 1);
INSERT INTO `invest_info` VALUES (3202, 7, 1, 1.00, '2017-08-20 15:05:01', 1);
INSERT INTO `invest_info` VALUES (3203, 7, 1, 1.00, '2017-08-20 15:05:02', 1);
INSERT INTO `invest_info` VALUES (3204, 7, 1, 1.00, '2017-08-20 15:05:02', 1);
INSERT INTO `invest_info` VALUES (3205, 7, 1, 1.00, '2017-08-20 15:05:02', 1);
INSERT INTO `invest_info` VALUES (3206, 7, 1, 1.00, '2017-08-20 15:05:02', 1);
INSERT INTO `invest_info` VALUES (3207, 7, 1, 1.00, '2017-08-20 15:05:02', 1);
INSERT INTO `invest_info` VALUES (3208, 7, 1, 1.00, '2017-08-20 15:05:02', 1);
INSERT INTO `invest_info` VALUES (3209, 7, 1, 1.00, '2017-08-20 15:05:02', 1);
INSERT INTO `invest_info` VALUES (3210, 7, 1, 1.00, '2017-08-20 15:05:02', 1);
INSERT INTO `invest_info` VALUES (3211, 7, 1, 1.00, '2017-08-20 15:05:02', 1);
INSERT INTO `invest_info` VALUES (3212, 7, 1, 1.00, '2017-08-20 15:05:02', 1);
INSERT INTO `invest_info` VALUES (3213, 7, 1, 1.00, '2017-08-20 15:05:03', 1);
INSERT INTO `invest_info` VALUES (3214, 7, 1, 1.00, '2017-08-20 15:05:03', 1);
INSERT INTO `invest_info` VALUES (3215, 1, 27, 200.00, '2020-08-20 15:05:03', 1);
INSERT INTO `invest_info` VALUES (3216, 1, 27, 300.00, '2020-08-20 15:05:03', 1);
INSERT INTO `invest_info` VALUES (3217, 7, 27, 1.00, '2017-08-20 15:05:03', 1);
INSERT INTO `invest_info` VALUES (3218, 7, 27, 1.00, '2017-08-20 15:05:03', 1);
INSERT INTO `invest_info` VALUES (3219, 7, 27, 1.00, '2017-08-20 15:05:03', 1);
INSERT INTO `invest_info` VALUES (3220, 7, 27, 1.00, '2017-08-20 15:05:03', 1);
INSERT INTO `invest_info` VALUES (3221, 7, 27, 1.00, '2017-08-20 15:05:03', 1);
INSERT INTO `invest_info` VALUES (3222, 7, 27, 1.00, '2017-08-20 15:05:03', 1);
INSERT INTO `invest_info` VALUES (3223, 7, 27, 1.00, '2017-08-20 15:05:03', 1);
INSERT INTO `invest_info` VALUES (3224, 7, 27, 1.00, '2017-08-20 15:05:03', 1);
INSERT INTO `invest_info` VALUES (3225, 7, 27, 1.00, '2017-08-20 15:05:03', 1);
INSERT INTO `invest_info` VALUES (3226, 7, 27, 1.00, '2017-08-20 15:05:03', 1);
INSERT INTO `invest_info` VALUES (3227, 1, 27, 100.00, '2020-08-20 15:09:52', 1);
INSERT INTO `invest_info` VALUES (3228, 1310699, 23, 100.00, '2020-12-31 14:07:51', 1);
INSERT INTO `invest_info` VALUES (3229, 1310699, 23, 100.00, '2020-12-31 14:08:57', 1);
INSERT INTO `invest_info` VALUES (3230, 1310699, 23, 100.00, '2020-12-31 14:17:56', 1);
INSERT INTO `invest_info` VALUES (3231, 1310699, 23, 100.00, '2020-12-31 14:23:17', 1);
INSERT INTO `invest_info` VALUES (3232, 1310699, 23, 200.00, '2020-12-31 14:31:23', 1);
INSERT INTO `invest_info` VALUES (3233, 1310699, 23, 300.00, '2020-12-31 14:32:41', 1);
INSERT INTO `invest_info` VALUES (3234, 1310697, 27, 100.00, '2020-12-31 14:34:00', 1);

SET FOREIGN_KEY_CHECKS = 1;
