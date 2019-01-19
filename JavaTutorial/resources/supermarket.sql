/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : supermarket

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2016-08-29 17:31:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `code` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `product_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`code`),
  KEY `fk` (`product_type`),
  CONSTRAINT `fk` FOREIGN KEY (`product_type`) REFERENCES `p_type` (`Type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1001', 'chikens', '51', '1');
INSERT INTO `product` VALUES ('1002', 'CocaCola', '82', '2');
INSERT INTO `product` VALUES ('1003', 'Fanta', '68', '2');

-- ----------------------------
-- Table structure for p_type
-- ----------------------------
DROP TABLE IF EXISTS `p_type`;
CREATE TABLE `p_type` (
  `Food` varchar(50) DEFAULT NULL,
  `Type` int(20) NOT NULL,
  PRIMARY KEY (`Type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of p_type
-- ----------------------------
INSERT INTO `p_type` VALUES ('food', '1');
INSERT INTO `p_type` VALUES ('drink', '2');
INSERT INTO `p_type` VALUES ('salade', '4');
