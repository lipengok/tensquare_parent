/*
Navicat MySQL Data Transfer

Source Server         : mysql5.5.3306
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : tensquare_base

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2022-11-18 16:08:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_reply
-- ----------------------------
DROP TABLE IF EXISTS `tb_reply`;
CREATE TABLE `tb_reply` (
  `id` varchar(255) NOT NULL,
  `problemid` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL COMMENT '回答内容',
  `createtime` datetime DEFAULT NULL COMMENT '回复日期',
  `updatetime` datetime DEFAULT NULL COMMENT '更新日期',
  `userid` varchar(255) DEFAULT NULL COMMENT '回复人id',
  `nickname` varchar(255) DEFAULT NULL COMMENT '回复人昵称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
