/*
Source Server         : mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : love

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-10-09 16:57:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for game_image
-- ----------------------------
DROP TABLE IF EXISTS `game_image`;
CREATE TABLE `game_image` (
  `id` varchar(50) NOT NULL COMMENT '主键id',
  `page_id` varchar(50) DEFAULT NULL COMMENT '新闻ID',
  `image_url_b` varchar(50) DEFAULT NULL COMMENT '图片原始链接',
  `image_url_a` varchar(50) DEFAULT NULL COMMENT '图片生成链接',
  `suffix` varchar(10) DEFAULT NULL COMMENT '图片后缀',
  `width` int(4) DEFAULT NULL COMMENT '图片宽度',
  `height` int(4) DEFAULT NULL COMMENT '图片高度',
  `size` int(4) DEFAULT NULL COMMENT '图片大小',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for game_link
-- ----------------------------
DROP TABLE IF EXISTS `game_link`;
CREATE TABLE `game_link` (
  `id` varchar(50) NOT NULL COMMENT '主键ID',
  `url_from` varchar(20) DEFAULT NULL COMMENT '网站来源',
  `url` varchar(50) NOT NULL COMMENT '网址',
  `title` varchar(50) DEFAULT NULL COMMENT '标题',
  `time` bigint(20) DEFAULT NULL COMMENT '获取时间',
  `name` varchar(20) DEFAULT NULL COMMENT '游戏名',
  `main_type` varchar(20) DEFAULT NULL COMMENT '主分类',
  `sub_type` varchar(20) DEFAULT NULL COMMENT '子分类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for game_page
-- ----------------------------
DROP TABLE IF EXISTS `game_page`;
CREATE TABLE `game_page` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `url_b` varchar(50) DEFAULT NULL COMMENT '原始链接',
  `url_a` varchar(50) DEFAULT NULL COMMENT '生成链接',
  `url_from` varchar(20) DEFAULT NULL COMMENT '来源',
  `title` varchar(50) DEFAULT NULL COMMENT '标题',
  `publish_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '发布时间',
  `time` bigint(20) DEFAULT NULL COMMENT '获取时间',
  `source` varchar(20) DEFAULT NULL COMMENT '内容来源',
  `author` varchar(20) DEFAULT NULL COMMENT '作者',
  `content` varchar(1000) DEFAULT NULL COMMENT '正文',
  `main_type` varchar(20) DEFAULT NULL COMMENT '主分类',
  `sub_type` varchar(20) DEFAULT NULL COMMENT '子分类',
  `keywords` varchar(50) DEFAULT NULL COMMENT '关键字',
  `html` varchar(1000) DEFAULT NULL COMMENT 'html内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for game_vedio
-- ----------------------------
DROP TABLE IF EXISTS `game_vedio`;
CREATE TABLE `game_vedio` (
  `id` varchar(50) NOT NULL COMMENT '主键ID',
  `page_id` varchar(50) DEFAULT NULL COMMENT '新闻ID',
  `vedio_url_b` varchar(50) DEFAULT NULL COMMENT '视频原始链接',
  `vedio_url_a` varchar(50) DEFAULT NULL COMMENT '视频生成链接',
  `suffix` varchar(10) DEFAULT NULL COMMENT '视频后缀',
  `width` int(4) DEFAULT NULL COMMENT '视频宽度',
  `height` int(4) DEFAULT NULL COMMENT '视频高度',
  `size` int(4) DEFAULT NULL COMMENT '视频大小',
  `length` bigint(20) DEFAULT NULL COMMENT '视频时长',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
