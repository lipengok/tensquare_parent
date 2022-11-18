/*
Navicat MySQL Data Transfer

Source Server         : mysql5.5.3306
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : tensquare_base

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2022-11-18 16:07:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_pl
-- ----------------------------
DROP TABLE IF EXISTS `tb_pl`;
CREATE TABLE `tb_pl` (
  `problemid` varchar(255) DEFAULT NULL COMMENT '问题id',
  `labelid` varchar(255) DEFAULT NULL COMMENT '标签id',
  `id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
