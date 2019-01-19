/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : trace

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2016-08-29 17:31:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for accounts
-- ----------------------------
DROP TABLE IF EXISTS `accounts`;
CREATE TABLE `accounts` (
  `id` int(11) NOT NULL,
  `user` varchar(20) DEFAULT NULL,
  `pass` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of accounts
-- ----------------------------
INSERT INTO `accounts` VALUES ('1001', 'Boba', '123456');
INSERT INTO `accounts` VALUES ('1002', 'Omda', '123456');
INSERT INTO `accounts` VALUES ('1003', 'Omda', '123456');
INSERT INTO `accounts` VALUES ('1004', 'omda', '123');
INSERT INTO `accounts` VALUES ('1005', 'Omar', '1213123');

-- ----------------------------
-- Table structure for bank
-- ----------------------------
DROP TABLE IF EXISTS `bank`;
CREATE TABLE `bank` (
  `id` int(11) DEFAULT NULL,
  `money` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bank
-- ----------------------------
INSERT INTO `bank` VALUES ('1001', '1200');
INSERT INTO `bank` VALUES ('1002', '1200');
INSERT INTO `bank` VALUES ('1003', '5000');
INSERT INTO `bank` VALUES ('1004', '4000');
INSERT INTO `bank` VALUES ('1003', '5000');
INSERT INTO `bank` VALUES ('1004', '4000');
