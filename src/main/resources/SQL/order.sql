SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` bigint NOT NULL COMMENT '订单id',
  `total_price` int NOT NULL DEFAULT '0' COMMENT '总金额',
  `payment_type` tinyint(1) unsigned zerofill NOT NULL COMMENT '支付类型，1、支付宝，2、微信',
  `buyer_id` bigint NOT NULL COMMENT '购买用户id',
  `shop_id` bigint NOT NULL COMMENT '商店id',
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地址详情',
  `status` tinyint(1) DEFAULT NULL COMMENT '订单的状态，1、未付款 2、已付款,未发货 3、已发货,未确认 4、确认收货，交易成功 5、交易取消订单关闭 6、退款中 7、已退款',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `pay_time` datetime NULL DEFAULT NULL COMMENT '支付时间',
  `consign_time` datetime NULL DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime NULL DEFAULT NULL COMMENT '交易完成时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `multi_key_status_time` (`status`,`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='订单表';

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` (`id`, `total_price`, `payment_type`, `buyer_id`, `shop_id`, `address`, `status`, `create_time`, `pay_time`, `consign_time`, `end_time`) VALUES
	(1, 56400, 1, 1, 1, '北京朝阳区修正大厦 李佳红 13700221122', 6, '2021-07-28 11:01:41', NULL, NULL, '2021-07-28 11:01:47');

SET FOREIGN_KEY_CHECKS = 1;