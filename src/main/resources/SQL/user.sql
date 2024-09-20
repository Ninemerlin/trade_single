SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `mobile` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `email` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL,
  `status` int NULL DEFAULT 1 COMMENT '使用状态（1正常 2冻结）',
  `user_type` int NULL DEFAULT 1 COMMENT '用户类型（1买家 2卖家 3管理员）',
  `icon` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像',
  `gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '保密' COMMENT '性别',
  `birth` date COMMENT '生日',
  `intro` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '自我介绍',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'Jack', 'pwd1', '13900112224','Jack@mail.com', '2017-08-19 20:50:21', '2017-08-19 20:50:21', 1, 1, null, '男', '1990-01-04', 'HELLO');
INSERT INTO `user` VALUES (2, 'Rose', 'pwd2', '13900112223', 'Rose@mail.com', '2017-08-19 21:00:23', '2017-08-19 21:00:23', 1, 1, null, '女', '1998-08-11', 'HELLO');
INSERT INTO `user` VALUES (3, 'Hope', 'pwd3', '13900112222', 'Hope@mail.com', '2017-08-19 22:37:44', '2017-08-19 22:37:44', 1, 2, null, '女', '2003-02-04', 'HELLO');
INSERT INTO `user` VALUES (4, 'Thomas', 'pwd4', '17701265258', 'Thomas@mail.com', '2017-08-19 23:44:45', '2017-08-19 23:44:45', 1, 3, null, '男', '2010-11-22', 'HELLO');

SET FOREIGN_KEY_CHECKS = 1;
