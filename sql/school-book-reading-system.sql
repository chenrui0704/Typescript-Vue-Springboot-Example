/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1-MySql
Source Server Version : 50711
Source Host           : 127.0.0.1:3306
Source Database       : school-book-reading-system

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2019-08-16 16:55:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '书籍名称',
  `title` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '书籍标题',
  `input_id` int(11) DEFAULT NULL COMMENT '录入人',
  `input_time` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '录入时间',
  `status` int(11) DEFAULT NULL COMMENT '状态:  1 = 作废， 0 = 正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '三国演义', '三国演义', '1', '2019-08-15 00:00:00', '0');
INSERT INTO `book` VALUES ('2', '水浒传', '水浒传', '1', '2019-08-15 00:00:00', '0');
INSERT INTO `book` VALUES ('3', '红楼梦', '红楼梦', '0', '2019-08-15 00:00:00', '0');
INSERT INTO `book` VALUES ('4', '语文', '语文', '0', '2019-08-16 16:04:22', '0');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户名',
  `login_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '登录名',
  `password` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '密码',
  `status` int(11) DEFAULT NULL COMMENT '状态  1 = 作废，0 = 正常。',
  `input_id` int(11) DEFAULT NULL COMMENT '录入人，管理员录入为0',
  `input_time` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '录入时间',
  `role` int(11) DEFAULT NULL COMMENT '角色: 1 = 学生， 0 = 管理员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1', '管理员1', 'admin', 'admin', '0', '0', '2019-08-15 00:00:00', '0');
INSERT INTO `userinfo` VALUES ('2', '小明', 'xm', 'ok', '0', '0', '2019-08-16 00:00:00', '1');
INSERT INTO `userinfo` VALUES ('3', '小刚', 'xg', 'ok', '0', '0', '2019-08-16 15:16:14', '1');
INSERT INTO `userinfo` VALUES ('4', '小红', 'xh', 'ok', '1', '0', '2019-08-16 15:36:46', '1');
INSERT INTO `userinfo` VALUES ('5', '小花', 'xiaohua', 'ok', '0', '0', '2019-08-16 15:43:56', '1');
INSERT INTO `userinfo` VALUES ('6', 'A', 'a', 'a', '0', '0', '2019-08-16 16:45:27', '1');
INSERT INTO `userinfo` VALUES ('7', 'b', 'b', 'b', '0', '0', '2019-08-16 16:45:31', '1');
INSERT INTO `userinfo` VALUES ('8', 'c', 'c', 'c', '0', '0', '2019-08-16 16:45:36', '1');
INSERT INTO `userinfo` VALUES ('9', 'd', 'd', 'd', '0', '0', '2019-08-16 16:45:43', '1');
INSERT INTO `userinfo` VALUES ('10', 'e', 'e', 'e', '0', '0', '2019-08-16 16:45:47', '1');
INSERT INTO `userinfo` VALUES ('11', 'f', 'f', 'f', '0', '0', '2019-08-16 16:45:50', '1');
INSERT INTO `userinfo` VALUES ('12', 'g', 'g', 'g', '0', '0', '2019-08-16 16:45:54', '1');
INSERT INTO `userinfo` VALUES ('13', 'h', 'h', 'h', '0', '0', '2019-08-16 16:45:59', '1');
INSERT INTO `userinfo` VALUES ('14', 'z', 'z', 'z', '0', '0', '2019-08-16 16:46:02', '1');
INSERT INTO `userinfo` VALUES ('15', 'x', 'x', 'x', '0', '0', '2019-08-16 16:46:06', '1');
INSERT INTO `userinfo` VALUES ('16', 'w', 'w', 'w', '0', '0', '2019-08-16 16:46:18', '1');
