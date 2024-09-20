SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for spec
-- ----------------------------
DROP TABLE IF EXISTS `spec`;
CREATE TABLE `spec`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `item_id` bigint NOT NULL COMMENT '商品id',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `price` int NOT NULL DEFAULT '0' COMMENT '价格',
  `stock` int UNSIGNED NOT NULL COMMENT '库存数量',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `item_id`(`item_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '规格表' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of spec
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
