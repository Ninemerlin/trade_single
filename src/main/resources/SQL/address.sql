SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL COMMENT '用户ID',
  `province` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '省',
  `city` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '市',
  `town` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '县/区',
  `mobile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机',
  `street` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '详细地址',
  `receiver` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系人',
  `is_default` int NULL DEFAULT 1 COMMENT '是否是默认 1默认 0否',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT COMMENT='地址表';

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` (`id`, `user_id`, `province`, `city`, `town`, `mobile`, `street`, `receiver`, `is_default`) VALUES
	(59, 1, '北京', '北京', '朝阳区', '13900112222', '金燕龙办公楼', '李嘉诚', 0),
	(60, 1, '北京', '北京', '朝阳区', '13700221122', '修正大厦', '李佳红', 1),
	(61, 2, '上海', '上海', '浦东新区', '13301212233', '航头镇航头路', '李佳星', 1),
	(63, 3, '广东', '佛山', '永春', '13301212233', '永春武馆', '李小龙', 1);

SET FOREIGN_KEY_CHECKS = 1;