SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '购物车条目id ',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `item_id` bigint NOT NULL COMMENT '商品id',
  `amount` int NOT NULL DEFAULT '1' COMMENT '购买数量',
  `spec_id` bigint NOT NULL COMMENT '规格id',
  `shop_id` bigint NOT NULL COMMENT '归属商店id',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `key_user_item_id` (`user_id`,`item_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT COMMENT='购物车表';

-- ----------------------------
-- Records of cart
-- ----------------------------

# INSERT INTO `cart` (`id`, `user_id`, `item_id`, spec_id, `amount`, `shop_id`) VALUES

SET FOREIGN_KEY_CHECKS = 1;