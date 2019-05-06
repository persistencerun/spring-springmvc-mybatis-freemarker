/*
Navicat MySQL Data Transfer

Source Server         : zh
Source Server Version : 50713
Source Host           : 127.0.0.1:3306
Source Database       : webdb

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2019-05-06 13:44:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bbs
-- ----------------------------
DROP TABLE IF EXISTS `bbs`;
CREATE TABLE `bbs` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `USERBBS` varchar(255) DEFAULT NULL,
  `bbstilte` varchar(255) DEFAULT NULL,
  `data` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of bbs
-- ----------------------------

-- ----------------------------
-- Table structure for test1
-- ----------------------------
DROP TABLE IF EXISTS `test1`;
CREATE TABLE `test1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `useraccound` varchar(255) DEFAULT NULL,
  `userpsw` varchar(255) DEFAULT NULL,
  `userbirth` varchar(255) DEFAULT NULL,
  `userhead` varchar(255) DEFAULT NULL,
  `useremail` varchar(255) DEFAULT NULL,
  `usersex` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- ----------------------------
-- Records of test1
-- ----------------------------
INSERT INTO `test1` VALUES ('1', '111', '111', '2018-01-01', 'https://img0.bdstatic.com/static/searchdetail/img/logo-2X_0c4ef02.png', 'xxxxxxxxx', '2');
INSERT INTO `test1` VALUES ('2', 'xierujun', '123456', '1997/1/11', 'https://img2.bdstatic.com/static/common/widget/shitu/images/camera_new_on_4e3e250.png', 'ddddd', '1');
INSERT INTO `test1` VALUES ('3', 'qqqqqqqqqqqqqq', 'qqqqqqqqq', '1997/1/11', 'https://img2.bdstatic.com/static/common/widget/shitu/images/camera_new_on_4e3e250.png', 'ddddd', '1');
INSERT INTO `test1` VALUES ('4', '1111111111111', 'qqqqqq', '1997/1/11', 'https://img0.bdstatic.com/static/searchdetail/img/logo-2X_0c4ef02.png', 'qqqqq', '1');
