/*
Navicat MySQL Data Transfer

Source Server         : mysql5.5.3306
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : tensquare_base

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2022-11-18 16:07:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_article
-- ----------------------------
DROP TABLE IF EXISTS `tb_article`;
CREATE TABLE `tb_article` (
  `id` varchar(255) NOT NULL,
  `columnid` varchar(255) DEFAULT NULL COMMENT '专栏id',
  `userid` varchar(255) DEFAULT NULL COMMENT '用户id',
  `title` varchar(255) DEFAULT NULL COMMENT '文章标题',
  `content` varchar(255) DEFAULT NULL COMMENT '文章内容',
  `image` varchar(255) DEFAULT NULL COMMENT '文章封面',
  `createtime` datetime DEFAULT NULL COMMENT '发表时间',
  `updatetime` datetime DEFAULT NULL COMMENT '修改时间',
  `ispublic` varchar(255) DEFAULT '0' COMMENT '0：不公开 1：公开',
  `istop` varchar(255) DEFAULT '0' COMMENT '0：不置顶 1：置顶',
  `visits` int(11) DEFAULT NULL COMMENT '浏览量',
  `thumbup` int(11) DEFAULT NULL COMMENT '点赞量',
  `comment` int(11) DEFAULT NULL COMMENT '评论数',
  `state` varchar(255) DEFAULT '0' COMMENT '0：未审核 1：已审核',
  `channelid` int(11) DEFAULT NULL COMMENT '关联频道表ID',
  `url` varchar(255) DEFAULT NULL COMMENT 'URL地址',
  `type` varchar(255) DEFAULT '0' COMMENT '文章类型：0：分享 1：专栏',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
