SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `price` int NOT NULL DEFAULT '0' COMMENT '价格',
  `stock` int UNSIGNED NOT NULL COMMENT '库存数量',
  `image` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品图片',
  `category` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '类目名称',
  `brand` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '品牌名称',
#   `spec` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '规格',
  `sold` int DEFAULT '0' COMMENT '销量',
  `status` int DEFAULT '1' COMMENT '商品状态 1-正常，2-下架，3-删除',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `shop_id` bigint DEFAULT NULL COMMENT '归属商店id',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `status` (`status`) USING BTREE,
  KEY `updated` (`update_time`) USING BTREE,
  KEY `category` (`category`)
) ENGINE=InnoDB AUTO_INCREMENT=100002672305 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT COMMENT='商品表';

-- ----------------------------
-- Records of item
-- ----------------------------

INSERT INTO `item` (`id`, `name`, `price`, `stock`, `image`, `category`, `brand`, `sold`, `status`, `create_time`, `update_time`, `shop_id`) VALUES
	(317578, 'RIMOWA 21寸托运箱拉杆箱 SALSA AIR系列果绿色 820.70.36.4', 28900, 10000, 'https://m.360buyimg.com/mobilecms/s720x720_jfs/t6934/364/1195375010/84676/e9f2c55f/597ece38N0ddcbc77.jpg!q70.jpg.webp', '拉杆箱', 'RIMOWA', 0, 1, '2019-05-01 00:00:00', '2023-05-06 11:06:17', 1),
	(317580, 'RIMOWA 26寸托运箱拉杆箱 SALSA AIR系列果绿色 820.70.36.4', 28600, 9999, 'https://m.360buyimg.com/mobilecms/s720x720_jfs/t6934/364/1195375010/84676/e9f2c55f/597ece38N0ddcbc77.jpg!q70.jpg.webp', '拉杆箱', 'RIMOWA', 0, 1, '2019-05-01 00:00:00', '2023-10-07 10:04:39', 1),
	(546872, '博兿（BOYI）拉杆包男23英寸大容量旅行包户外手提休闲拉杆袋 BY09186黑灰色', 27500, 10000, 'https://m.360buyimg.com/mobilecms/s720x720_jfs/t3301/221/3887995271/90563/bf2cadb/57f9fbf4N8e47c225.jpg!q70.jpg.webp', '拉杆箱', '博兿', 0, 1, '2019-05-01 00:00:00', '2019-05-01 00:00:00', 1),
	(561178, 'RIMOWA 30寸托运箱拉杆箱 SALSA AIR系列果绿色 820.70.36.4', 13000, 10000, 'https://m.360buyimg.com/mobilecms/s720x720_jfs/t6934/364/1195375010/84676/e9f2c55f/597ece38N0ddcbc77.jpg!q70.jpg.webp', '拉杆箱', 'RIMOWA', 0, 1, '2019-05-01 00:00:00', '2023-10-07 10:04:54', 1),
	(577967, '莎米特SUMMIT 旅行拉杆箱28英寸PC材质大容量旅行行李箱PC154 黑色', 71300, 10000, 'https://m.360buyimg.com/mobilecms/s720x720_jfs/t30454/163/719393962/79149/13bcc06a/5bfca9b6N493202d2.jpg!q70.jpg.webp', '拉杆箱', '莎米特', 0, 1, '2019-05-01 00:00:00', '2019-05-01 00:00:00', 1),
	(584382, '美旅AmericanTourister拉杆箱 商务男女超轻PP行李箱时尚大容量耐磨飞机轮旅行箱 25英寸海关锁DL7灰色', 36600, 10000, 'https://m.360buyimg.com/mobilecms/s720x720_jfs/t1/22734/21/2036/130399/5c18af2aEab296c01/7b148f18c6081654.jpg!q70.jpg.webp', '拉杆箱', '美旅箱包', 0, 1, '2019-05-01 00:00:00', '2019-05-01 00:00:00', 2),
	(584387, '美旅AmericanTourister拉杆箱 商务男女超轻PP行李箱时尚大容量耐磨飞机轮旅行箱 29英寸海关锁DL7灰色', 16200, 10000, 'https://m.360buyimg.com/mobilecms/s720x720_jfs/t1/22734/21/2036/130399/5c18af2aEab296c01/7b148f18c6081654.jpg!q70.jpg.webp', '拉杆箱', '美旅箱包',0, 1, '2019-05-01 00:00:00', '2019-05-01 00:00:00', 2),
	(584391, '美旅AmericanTourister拉杆箱 商务男女超轻PP行李箱时尚大容量耐磨飞机轮旅行箱 20英寸海关锁DL7灰色', 29900, 10000, 'https://m.360buyimg.com/mobilecms/s720x720_jfs/t1/22734/21/2036/130399/5c18af2aEab296c01/7b148f18c6081654.jpg!q70.jpg.webp', '拉杆箱', '美旅箱包',  0, 1, '2019-05-01 00:00:00', '2019-05-01 00:00:00', 2),
	(584392, '美旅AmericanTourister拉杆箱 商务男女超轻PP行李箱时尚大容量耐磨飞机轮旅行箱 29英寸海关锁DL7灰色', 17000, 10000, 'https://m.360buyimg.com/mobilecms/s720x720_jfs/t1/22734/21/2036/130399/5c18af2aEab296c01/7b148f18c6081654.jpg!q70.jpg.webp', '拉杆箱', '美旅箱包',  0, 1, '2019-05-01 00:00:00', '2023-10-07 10:04:59', 2),
	(584394, '美旅AmericanTourister拉杆箱 商务男女超轻PP行李箱时尚大容量耐磨飞机轮旅行箱 25英寸海关锁DL7灰色', 79400, 10000, 'https://m.360buyimg.com/mobilecms/s720x720_jfs/t1/22734/21/2036/130399/5c18af2aEab296c01/7b148f18c6081654.jpg!q70.jpg.webp', '拉杆箱', '美旅箱包',  0, 1, '2019-05-01 00:00:00', '2019-05-01 00:00:00', 2),
	(613357, '莎米特SUMMIT 旅行拉杆箱28英寸PC材质大容量旅行行李箱PC154 黑色', 79800, 10000, 'https://m.360buyimg.com/mobilecms/s720x720_jfs/t30454/163/719393962/79149/13bcc06a/5bfca9b6N493202d2.jpg!q70.jpg.webp', '拉杆箱', '莎米特',  0, 1, '2019-05-01 00:00:00', '2019-05-01 00:00:00', 3),
	(613358, '莎米特SUMMIT 旅行拉杆箱28英寸PC材质大容量旅行行李箱PC154 蓝色', 14000, 10000, 'https://m.360buyimg.com/mobilecms/s720x720_jfs/t30454/163/719393962/79149/13bcc06a/5bfca9b6N493202d2.jpg!q70.jpg.webp', '拉杆箱', '莎米特',  0, 1, '2019-05-01 00:00:00', '2023-10-07 10:05:00', 3),
	(613359, '莎米特SUMMIT 旅行拉杆箱28英寸PC材质大容量旅行行李箱PC154 深灰', 70900, 10000, 'https://m.360buyimg.com/mobilecms/s720x720_jfs/t30454/163/719393962/79149/13bcc06a/5bfca9b6N493202d2.jpg!q70.jpg.webp', '拉杆箱', '莎米特',  0, 1, '2019-05-01 00:00:00', '2019-05-01 00:00:00', 3),
	(613360, '莎米特SUMMIT 旅行拉杆箱28英寸PC材质大容量旅行行李箱PC154 黑色', 88000, 10000, 'https://m.360buyimg.com/mobilecms/s720x720_jfs/t30454/163/719393962/79149/13bcc06a/5bfca9b6N493202d2.jpg!q70.jpg.webp', '拉杆箱', '莎米特',  0, 1, '2019-05-01 00:00:00', '2019-05-01 00:00:00', 3),
	(625465, '德国原装进口牛奶 德亚（Weidendorf）全脂纯牛奶 1L*6盒 礼盒装', 85900, 10000, 'https://m.360buyimg.com/mobilecms/s720x720_jfs/t25771/98/1071132390/186396/29fc5eca/5b879ac4Nca072d7c.jpg!q70.jpg.webp', '牛奶', '德亚', 0, 1, '2019-05-01 00:00:00', '2019-05-01 00:00:00', 4),
	(626738, '花王（Merries）拉拉裤 M58片 中号尿不湿（6-11kg）（日本原装进口）', 38900, 10000, 'https://m.360buyimg.com/mobilecms/s720x720_jfs/t24370/119/1282321183/267273/b4be9a80/5b595759N7d92f931.jpg!q70.jpg.webp', '拉拉裤', '花王', 0, 1, '2019-05-01 00:00:00', '2019-05-01 00:00:00', 4),
	(627718, '德国DMK进口牛奶 欧德堡（Oldenburger）超高温处理全脂纯牛奶1L*12盒', 42900, 10000, 'https://m.360buyimg.com/mobilecms/s720x720_jfs/t24328/97/2181458616/279103/83a4a2a7/5b753954N5657e230.jpg!q70.jpg.webp', '牛奶', '欧德堡', 0, 1, '2019-05-01 00:00:00', '2019-05-01 00:00:00', 4),
	(627719, '德国DMK进口牛奶 欧德堡（Oldenburger）超高温处理脱脂牛奶1L*12盒', 76100, 10000, 'https://m.360buyimg.com/mobilecms/s720x720_jfs/t25294/191/611097475/277750/190dbdd2/5b75344bN5ff72a8a.jpg!q70.jpg.webp', '牛奶', '欧德堡', 0, 1, '2019-05-01 00:00:00', '2019-05-01 00:00:00', 4),
	(627720, '德国DMK进口牛奶 欧德堡（Oldenburger）超高温处理部分脱脂牛奶1L*1盒', 33900, 10000, 'https://m.360buyimg.com/mobilecms/s720x720_jfs/t23269/234/2090465105/271112/fdcdb12e/5b76288eN001ee37d.jpg!q70.jpg.webp', '牛奶', '欧德堡',  0, 1, '2019-05-01 00:00:00', '2019-05-01 00:00:00', 4),
	(651742, 'RIMOWA 化妆箱登机箱拉杆箱 LIMBO系列蓝色 881.52.21.4', 27600, 10000, 'https://m.360buyimg.com/mobilecms/s720x720_jfs/t5872/360/8032888912/69228/e3111270/5977f232Nc29351dd.jpg!q70.jpg.webp', '拉杆箱', 'RIMOWA', 0, 1, '2019-05-01 00:00:00', '2019-05-01 00:00:00', 4),
	(670469, '德国进口 甘蒂牧场（MUH）牧牌 部分脱脂纯牛奶1L*6盒进口纯牛奶 礼盒装', 62700, 10000, 'https://m.360buyimg.com/mobilecms/s720x720_jfs/t3481/125/1265942888/311041/1a99725b/582292ebN29b95633.jpg!q70.jpg.webp', '牛奶', '甘蒂牧场', 0, 1, '2019-05-01 00:00:00', '2019-05-01 00:00:00', 4);

SET FOREIGN_KEY_CHECKS = 1;