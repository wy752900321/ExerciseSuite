/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : friend

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2012-05-03 19:22:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `friend`
-- ----------------------------
DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `info` text,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `qq` varchar(11) DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  `brithday` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Table structure for `concern`
-- ----------------------------
DROP TABLE IF EXISTS `concern`;
CREATE TABLE `concern` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `team` bigint(20) DEFAULT NULL,
	`friend` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_team` (`team`),
  CONSTRAINT `fk_team` FOREIGN KEY (`team`) REFERENCES `team` (`id`),
	KEY `fk_concern_friend` (`friend`),
  CONSTRAINT `fk_concern_friend` FOREIGN KEY (`friend`) REFERENCES `friend` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Records of friend
-- ----------------------------

-- ----------------------------
-- Table structure for `message`
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `message` text NOT NULL,
  `user` bigint(20) NOT NULL,
	`messageUser` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_message_user` (`user`),
  CONSTRAINT `fk_message_user` FOREIGN KEY (`user`) REFERENCES `user` (`id`),
CONSTRAINT `fk_mes_user` FOREIGN KEY (`messageUser`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------

-- ----------------------------
-- Table structure for `photo`
-- ----------------------------
DROP TABLE IF EXISTS `photo`;
	CREATE TABLE `photo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `info` text,
  `img` varchar(40) NOT NULL,
  `user` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_photo_user` (`user`),
  CONSTRAINT `fk_photo_user` FOREIGN KEY (`user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of photo
-- ----------------------------

-- ----------------------------
-- Table structure for `team`
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `info` text,
  `user` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user` (`user`),
  CONSTRAINT `fk_user` FOREIGN KEY (`user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of team
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL ,
  `userName` varchar(30) NOT NULL,
  `password` varchar(40) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_user_friend` FOREIGN KEY (`id`) REFERENCES `friend` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
