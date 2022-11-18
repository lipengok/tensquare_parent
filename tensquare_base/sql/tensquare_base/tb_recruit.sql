/*
Navicat MySQL Data Transfer

Source Server         : mysql5.5.3306
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : tensquare_base

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2022-11-18 16:08:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_recruit
-- ----------------------------
DROP TABLE IF EXISTS `tb_recruit`;
CREATE TABLE `tb_recruit` (
  `id` varchar(255) NOT NULL,
  `jobname` varchar(255) DEFAULT NULL COMMENT '招聘职位',
  `salary` varchar(255) DEFAULT NULL COMMENT '薪资范围',
  `condition` varchar(255) DEFAULT NULL COMMENT '经验要求',
  `education` varchar(255) DEFAULT NULL COMMENT '学历要求',
  `address` varchar(255) DEFAULT NULL COMMENT '办公地址',
  `type` varchar(255) DEFAULT NULL COMMENT '任职方式',
  `eid` varchar(255) DEFAULT NULL COMMENT '企业id',
  `state` varchar(255) DEFAULT NULL COMMENT '状态：0：关闭 1:开启 2：推荐',
  `createtime` datetime DEFAULT NULL COMMENT '发布日期',
  `url` varchar(255) DEFAULT NULL COMMENT '原网址',
  `label` varchar(255) DEFAULT NULL COMMENT '标签',
  `content1` varchar(255) DEFAULT NULL COMMENT '职位描述',
  `content2` varchar(255) DEFAULT NULL COMMENT '职位要求',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
