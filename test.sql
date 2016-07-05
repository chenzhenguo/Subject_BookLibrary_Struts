/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50530
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50530
File Encoding         : 65001

Date: 2016-06-28 18:00:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `b_book`
-- ----------------------------
DROP TABLE IF EXISTS `b_book`;
CREATE TABLE `b_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `categoryId` int(11) DEFAULT NULL,
  `bookNum` int(23) DEFAULT NULL,
  `pubDate` date DEFAULT NULL,
  `publish` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_eese0klhyxby7mm2mxhrv9oyy` (`categoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of b_book
-- ----------------------------
INSERT INTO `b_book` VALUES ('1', '查令十字街84号', '28.00', '海伦', '1', '0', '1999-06-15', '译林出版社');
INSERT INTO `b_book` VALUES ('6', '欢乐颂', '59.00', '阿耐', '6', '1', '2009-12-12', '四川文艺出版社');
INSERT INTO `b_book` VALUES ('7', '孤独小说家', '25.00', '石田衣良', '1', '1', '1996-12-12', '北京联合出版有限责任公司');
INSERT INTO `b_book` VALUES ('8', '摆渡人', '20.00', '张嘉佳', '5', '1', '1999-12-15', '百花洲文艺出版社');
INSERT INTO `b_book` VALUES ('9', '我们仨', '17.20', '杨绛', '1', '0', '2015-12-12', '新知三联书店');
INSERT INTO `b_book` VALUES ('10', '我喜欢这个功利的世界', '26.20', '咪蒙', '1', '1', '2002-01-12', '湖南文艺出版社');
INSERT INTO `b_book` VALUES ('11', '重返狼群', '27.40', '李微漪', '3', '1', '1992-12-12', '长江文艺出版社');
INSERT INTO `b_book` VALUES ('12', ' 赫伯特·乔治·威尔斯', '24.90', ' 赫伯特·乔治·威尔斯', '5', '1', '2000-08-12', '民主与建设出版社');
INSERT INTO `b_book` VALUES ('13', '百年孤独', '89.00', ' 加西亚·马尔克斯', '2', '1', '1992-12-12', '南海出版公司');
INSERT INTO `b_book` VALUES ('14', '巨人的陨落', '89.60', 'Ken Follett', '2', '1', '2016-04-01', '江苏凤凰文艺出版社');
INSERT INTO `b_book` VALUES ('15', '偷影子的人', '18.50', '马克·李维', '6', '1', '2013-03-01', '湖南文艺出版社');
INSERT INTO `b_book` VALUES ('16', '教父', '87.60', ' 马里奥·普佐', '2', '1', '2014-04-01', '江苏文艺出版社');
INSERT INTO `b_book` VALUES ('17', '大江东去', '122.60', '阿耐', '1', '1', '2016-04-01', '北京联合出版公司');
INSERT INTO `b_book` VALUES ('18', '战国纵横：鬼谷子的局', '174.80', '寒川子', '4', '1', '2014-11-01', '江苏凤凰文艺出版社');

-- ----------------------------
-- Table structure for `b_category`
-- ----------------------------
DROP TABLE IF EXISTS `b_category`;
CREATE TABLE `b_category` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of b_category
-- ----------------------------
INSERT INTO `b_category` VALUES ('1', '仙侠');
INSERT INTO `b_category` VALUES ('2', '都市');
INSERT INTO `b_category` VALUES ('3', '历史');
INSERT INTO `b_category` VALUES ('4', '言情');
INSERT INTO `b_category` VALUES ('5', '穿越');
INSERT INTO `b_category` VALUES ('6', '校园');
INSERT INTO `b_category` VALUES ('7', '神话');
INSERT INTO `b_category` VALUES ('8', '悬疑');
INSERT INTO `b_category` VALUES ('9', '修仙');
INSERT INTO `b_category` VALUES ('10', '小说');

-- ----------------------------
-- Table structure for `b_record`
-- ----------------------------
DROP TABLE IF EXISTS `b_record`;
CREATE TABLE `b_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of b_record
-- ----------------------------
INSERT INTO `b_record` VALUES ('62', '8', '19', '2016-06-13', '-1');
INSERT INTO `b_record` VALUES ('63', '8', '19', '2016-06-14', '1');
INSERT INTO `b_record` VALUES ('64', '1', '19', '2016-06-14', '-1');
INSERT INTO `b_record` VALUES ('65', '7', '19', '2016-06-14', '-1');
INSERT INTO `b_record` VALUES ('66', '7', '19', '2016-06-15', '1');
INSERT INTO `b_record` VALUES ('67', '9', '19', '2016-06-15', '-1');
INSERT INTO `b_record` VALUES ('68', '7', '23', '2016-06-15', '-1');
INSERT INTO `b_record` VALUES ('69', '7', '23', '2016-06-15', '1');

-- ----------------------------
-- Table structure for `b_user`
-- ----------------------------
DROP TABLE IF EXISTS `b_user`;
CREATE TABLE `b_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `password` varchar(20) NOT NULL,
  `roldId` int(10) NOT NULL,
  PRIMARY KEY (`id`,`name`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of b_user
-- ----------------------------
INSERT INTO `b_user` VALUES ('17', 'chen', '123', '1');
INSERT INTO `b_user` VALUES ('19', 'zhangsan', '123', '2');
INSERT INTO `b_user` VALUES ('23', 'lisi', '123', '2');

-- ----------------------------
-- Table structure for `b_user2`
-- ----------------------------
DROP TABLE IF EXISTS `b_user2`;
CREATE TABLE `b_user2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of b_user2
-- ----------------------------
INSERT INTO `b_user2` VALUES ('1', 'zhangsan');
INSERT INTO `b_user2` VALUES ('2', 'zhangs1');

-- ----------------------------
-- Table structure for `t_category`
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES ('1', '小说');
INSERT INTO `t_category` VALUES ('2', '科幻');
INSERT INTO `t_category` VALUES ('3', '都市');
INSERT INTO `t_category` VALUES ('4', '教育');
INSERT INTO `t_category` VALUES ('5', '少儿');
INSERT INTO `t_category` VALUES ('6', '计算机');

-- ----------------------------
-- Table structure for `t_city`
-- ----------------------------
DROP TABLE IF EXISTS `t_city`;
CREATE TABLE `t_city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_city
-- ----------------------------
INSERT INTO `t_city` VALUES ('1', ' 成都', '1');
INSERT INTO `t_city` VALUES ('2', '内江', '1');
INSERT INTO `t_city` VALUES ('3', '资阳', '1');
INSERT INTO `t_city` VALUES ('4', '达州', '1');
INSERT INTO `t_city` VALUES ('5', '广安', '1');
INSERT INTO `t_city` VALUES ('6', '绵阳', '1');
INSERT INTO `t_city` VALUES ('7', '长沙', '2');
INSERT INTO `t_city` VALUES ('8', '常德', '2');
INSERT INTO `t_city` VALUES ('9', '湘潭', '2');
INSERT INTO `t_city` VALUES ('10', '株洲', '2');
INSERT INTO `t_city` VALUES ('11', '郴州', '2');
INSERT INTO `t_city` VALUES ('12', '岳阳', '2');
INSERT INTO `t_city` VALUES ('13', '怀化', '2');
INSERT INTO `t_city` VALUES ('14', '济南', '3');
INSERT INTO `t_city` VALUES ('15', '青岛', '3');
INSERT INTO `t_city` VALUES ('16', '烟台', '3');
INSERT INTO `t_city` VALUES ('17', '菏泽', '3');
INSERT INTO `t_city` VALUES ('18', '日照', '3');
INSERT INTO `t_city` VALUES ('19', '德州', '3');
INSERT INTO `t_city` VALUES ('20', '武汉', '4');
INSERT INTO `t_city` VALUES ('21', '宜昌', '4');
INSERT INTO `t_city` VALUES ('22', '孝感', '4');
INSERT INTO `t_city` VALUES ('23', '十堰', '4');
INSERT INTO `t_city` VALUES ('24', '襄阳', '4');
INSERT INTO `t_city` VALUES ('25', '南京', '5');
INSERT INTO `t_city` VALUES ('26', '苏州', '5');
INSERT INTO `t_city` VALUES ('27', '常州', '5');
INSERT INTO `t_city` VALUES ('28', '昆山', '5');
INSERT INTO `t_city` VALUES ('29', '无锡', '5');
