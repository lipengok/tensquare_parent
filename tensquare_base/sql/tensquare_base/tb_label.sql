/*
Navicat MySQL Data Transfer

Source Server         : mysql5.5.3306
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : tensquare_base

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2022-11-18 16:07:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_label
-- ----------------------------
DROP TABLE IF EXISTS `tb_label`;
CREATE TABLE `tb_label` (
  `id` varchar(255) NOT NULL,
  `labelname` varchar(255) DEFAULT NULL COMMENT '标签名称',
  `state` varchar(255) DEFAULT '0' COMMENT '0：无效 1：有效',
  `count` int(11) DEFAULT '0' COMMENT '使用数量',
  `fans` int(11) DEFAULT '0' COMMENT '关注数量',
  `recommend` varchar(255) DEFAULT '0' COMMENT '0：不推荐 1:推荐',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
