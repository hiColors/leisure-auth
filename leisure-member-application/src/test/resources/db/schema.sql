/*
Navicat MySQL Data Transfer

Source Server         : 超神数据库
Source Server Version : 50722
Source Host           : 47.105.97.16:3306
Source Database       : leisure_member

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-11-28 21:03:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `nick_name` varchar(64) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '昵称',
  `username` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
  `password` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '密码',
  `enabled` bit(1) NOT NULL DEFAULT b'1' COMMENT '启用状态[0:未启用;1:启用]',
  `lock_status` bit(1) NOT NULL DEFAULT b'0' COMMENT '锁定状态[0:未锁定;1:锁定]',
  `expired_date` datetime NOT NULL DEFAULT '9999-12-31 23:59:59' COMMENT '过期时间',
  `credentials_expired_date` datetime NOT NULL DEFAULT '9999-12-31 23:59:59' COMMENT '凭证过期时间',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `creator` bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT '创建人',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modifier` bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT '修改人',
  `delete_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '删除状态[0:未删除;1:已删除]',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_username` (`username`),
  KEY `idx_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=100015 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='人员信息';

-- ----------------------------
-- Table structure for member_detail
-- ----------------------------
DROP TABLE IF EXISTS `member_detail`;
CREATE TABLE `member_detail` (
  `id` bigint(20) unsigned NOT NULL COMMENT '主键',
  `default_platform_id` bigint(20) unsigned DEFAULT NULL COMMENT '主平台 id',
  `email` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '邮箱',
  `mobile` varchar(20) COLLATE utf8mb4_bin NOT NULL COMMENT '手机号',
  `name` varchar(20) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '姓名',
  `birthday` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '出生日期',
  `description` varchar(255) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '描述',
  `website` varchar(50) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '主页',
  `avatar` varchar(255) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '头像',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `creator` bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT '创建人',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modifier` bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT '修改人',
  `delete_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '删除状态[0:未删除;1:已删除]',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_email` (`email`),
  UNIQUE KEY `uk_mobile` (`mobile`),
  KEY `idx_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='人员详细信息';

-- ----------------------------
-- Table structure for member_role
-- ----------------------------
DROP TABLE IF EXISTS `member_role`;
CREATE TABLE `member_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `member_id` bigint(20) unsigned NOT NULL COMMENT '人员 id',
  `role_id` bigint(20) unsigned NOT NULL COMMENT '角色 id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '状态[0:未启用;1:启用]',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `creator` bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT '创建人',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modifier` bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT '修改人',
  `delete_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '删除状态[0:未删除;1:已删除]',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_member_role` (`member_id`,`role_id`) USING BTREE,
  KEY `idx_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=100001 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='人员角色信息';

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) COLLATE utf8mb4_bin NOT NULL COMMENT '名称',
  `ant_path` varchar(100) COLLATE utf8mb4_bin NOT NULL COMMENT 'ant path 匹配规则',
  `strategy` bit(1) NOT NULL DEFAULT b'1' COMMENT '策略[0: 拒绝;1:允许]',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '状态[0:未启用;1:启用]',
  `description` varchar(255) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '说明',
  `comment` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `creator` bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT '创建人',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modifier` bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT '修改人',
  `delete_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '删除状态[0:未删除;1:已删除]',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_name` (`name`) USING BTREE,
  UNIQUE KEY `uk_ant_path_strategy` (`ant_path`,`strategy`) USING BTREE,
  KEY `idx_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='权限信息';

-- ----------------------------
-- Table structure for platform
-- ----------------------------
DROP TABLE IF EXISTS `platform`;
CREATE TABLE `platform` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) COLLATE utf8mb4_bin NOT NULL COMMENT '名称',
  `status` int(3) unsigned NOT NULL DEFAULT '0' COMMENT '状态[0:禁用;1:审核中;2:启用]',
  `comment` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `creator` bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT '创建人',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modifier` bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT '修改人',
  `delete_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '删除状态[0:未删除;1:已删除]',
  `originator` bigint(20) unsigned NOT NULL COMMENT '创始人',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_name` (`name`) USING BTREE,
  KEY `idx_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=100032 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='平台信息';

-- ----------------------------
-- Table structure for platform_job
-- ----------------------------
DROP TABLE IF EXISTS `platform_job`;
CREATE TABLE `platform_job` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `platform_id` bigint(20) unsigned NOT NULL COMMENT '平台',
  `level` varchar(100) COLLATE utf8mb4_bin NOT NULL COMMENT '职级',
  `title` varchar(100) COLLATE utf8mb4_bin NOT NULL COMMENT '职称',
  `comment` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `creator` bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT '创建人',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modifier` bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT '修改人',
  `delete_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '删除状态[0:未删除;1:已删除]',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_platform_title` (`platform_id`,`title`) USING BTREE,
  KEY `idx_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=100008 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='平台岗位信息';

-- ----------------------------
-- Table structure for platform_member
-- ----------------------------
DROP TABLE IF EXISTS `platform_member`;
CREATE TABLE `platform_member` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `platform_id` bigint(20) unsigned NOT NULL COMMENT '平台',
  `platform_organization_id` bigint(20) unsigned NOT NULL COMMENT '平台组织架构',
  `member_id` bigint(20) unsigned NOT NULL COMMENT '人员',
  `name` varchar(20) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '姓名',
  `platform_job_id` bigint(20) unsigned DEFAULT NULL COMMENT '平台岗位',
  `employee_number` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT ' 工号',
  `entry_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '入职日期',
  `comment` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `creator` bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT '创建人',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modifier` bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT '修改人',
  `delete_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '删除状态[0:未删除;1:已删除]',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_platform_member` (`platform_id`,`member_id`) USING BTREE,
  KEY `idx_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=100033 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='平台员工信息';

-- ----------------------------
-- Table structure for platform_member_role
-- ----------------------------
DROP TABLE IF EXISTS `platform_member_role`;
CREATE TABLE `platform_member_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `platform_member_id` bigint(20) unsigned NOT NULL COMMENT '平台员工 id',
  `role_id` bigint(20) unsigned NOT NULL COMMENT '角色',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `creator` bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT '创建人',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modifier` bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT '修改人',
  `delete_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '删除状态[0:未删除;1:已删除]',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_platform_member_role` (`platform_member_id`,`role_id`) USING BTREE,
  KEY `idx_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=100006 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='平台员工角色信息';

-- ----------------------------
-- Table structure for platform_organization
-- ----------------------------
DROP TABLE IF EXISTS `platform_organization`;
CREATE TABLE `platform_organization` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `platform_id` bigint(20) unsigned NOT NULL COMMENT '平台',
  `parent_id` bigint(20) unsigned NOT NULL COMMENT '父级节点',
  `name` varchar(100) COLLATE utf8mb4_bin NOT NULL COMMENT '名称',
  `level` int(4) NOT NULL DEFAULT '1' COMMENT '层级',
  `comment` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `creator` bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT '创建人',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modifier` bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT '修改人',
  `delete_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '删除状态[0:未删除;1:已删除]',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_platform_name` (`platform_id`,`name`) USING BTREE,
  KEY `idx_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=100038 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='平台组织架构信息';

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) COLLATE utf8mb4_bin NOT NULL COMMENT '名称',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '状态[0:未启用;1:启用]',
  `description` varchar(255) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '说明',
  `comment` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `creator` bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT '创建人',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modifier` bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT '修改人',
  `delete_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '删除状态[0:未删除;1:已删除]',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_name` (`name`) USING BTREE,
  KEY `idx_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=100013 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='角色信息';

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` bigint(20) unsigned NOT NULL COMMENT '角色 id',
  `permission_id` bigint(20) unsigned NOT NULL COMMENT '权限 id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `creator` bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT '创建人',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modifier` bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT '修改人',
  `delete_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '删除状态[0:未删除;1:已删除]',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_role_permission` (`role_id`,`permission_id`) USING BTREE,
  KEY `idx_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='角色权限信息';
