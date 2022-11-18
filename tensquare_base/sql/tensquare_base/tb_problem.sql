/*
Navicat MySQL Data Transfer

Source Server         : mysql5.5.3306
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : tensquare_base

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2022-11-18 16:07:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_problem
-- ----------------------------
DROP TABLE IF EXISTS `tb_problem`;
CREATE TABLE `tb_problem` (
  `id` varchar(255) NOT NULL,
  `title` varchar(255) DEFAULT NULL COMMENT '问题标题',
  `content` varchar(255) DEFAULT NULL COMMENT '问题内容',
  `createtime` datetime DEFAULT NULL COMMENT '发布时间',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `userid` varchar(255) DEFAULT NULL COMMENT '发布人id',
  `nickname` varchar(255) DEFAULT NULL COMMENT '发布人昵称',
  `visits` int(11) DEFAULT NULL COMMENT '浏览量',
  `thumbup` int(11) DEFAULT NULL COMMENT '点赞数',
  `reply` int(11) DEFAULT NULL COMMENT '回复数',
  `solve` varchar(255) DEFAULT '0' COMMENT '是否解决：0解决，1未解决',
  `replyname` varchar(255) DEFAULT NULL COMMENT '最新回复人',
  `replytime` datetime DEFAULT NULL COMMENT '最新回复时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
