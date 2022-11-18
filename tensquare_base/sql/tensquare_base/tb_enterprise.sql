/*
Navicat MySQL Data Transfer

Source Server         : mysql5.5.3306
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : tensquare_base

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2022-11-18 16:07:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_enterprise
-- ----------------------------
DROP TABLE IF EXISTS `tb_enterprise`;
CREATE TABLE `tb_enterprise` (
  `id` varchar(255) NOT NULL,
  `summary` varchar(255) DEFAULT NULL COMMENT '企业简介',
  `name` varchar(255) DEFAULT NULL COMMENT '企业名称',
  `address` varchar(255) DEFAULT NULL COMMENT '企业地址',
  `labels` varchar(255) DEFAULT NULL COMMENT '标签列表：用逗号隔开。',
  `coordinate` varchar(255) DEFAULT NULL COMMENT '企业坐标：经度，纬度',
  `ishot` varchar(255) DEFAULT '0' COMMENT '是否热门：0：非热门 1：热门',
  `logo` varchar(255) DEFAULT NULL COMMENT 'LOGO',
  `jobcount` int(11) DEFAULT NULL COMMENT '职位数',
  `url` varchar(255) DEFAULT NULL COMMENT 'URL',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
