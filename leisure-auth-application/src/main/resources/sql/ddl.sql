CREATE TABLE `role` (
  `id` BIGINT ( 20 ) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` VARCHAR ( 100 ) NOT NULL COMMENT '名称',
  `status` bit ( 1 ) NOT NULL DEFAULT 1 COMMENT '状态[0:未启用;1:启用]',
  `explain` VARCHAR ( 255 ) NOT NULL DEFAULT '' COMMENT '说明',
  `comment` VARCHAR ( 255 ) NULL COMMENT '备注',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `creator` BIGINT ( 20 ) UNSIGNED NOT NULL DEFAULT 1 COMMENT '创建人',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modifier` BIGINT ( 20 ) UNSIGNED NOT NULL DEFAULT 1 COMMENT '修改人',
  `delete_flag` bit ( 1 ) NOT NULL DEFAULT 0 COMMENT '删除状态[0:未删除;1:已删除]',
  PRIMARY KEY ( `id` ) USING BTREE,
  UNIQUE KEY `uk_name` ( `name` ) USING BTREE,
  KEY `idx_create_time` ( `create_time` ) USING BTREE
) ENGINE = INNODB AUTO_INCREMENT = 100000 COMMENT = '角色信息';

CREATE TABLE `role_permission` (
  `id` BIGINT ( 20 ) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` BIGINT ( 20 ) UNSIGNED NOT NULL COMMENT '角色 id',
  `name` VARCHAR ( 100 ) NOT NULL COMMENT '名称',
  `ant_path` VARCHAR ( 100 ) NOT NULL COMMENT '路径匹配规则',
  `status` bit ( 1 ) NOT NULL DEFAULT 1 COMMENT '状态[0:未启用;1:启用]',
  `explain` VARCHAR ( 255 ) NOT NULL DEFAULT '' COMMENT '说明',
  `comment` VARCHAR ( 255 ) NULL COMMENT '备注',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `creator` BIGINT ( 20 ) UNSIGNED NOT NULL DEFAULT 1 COMMENT '创建人',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modifier` BIGINT ( 20 ) UNSIGNED NOT NULL DEFAULT 1 COMMENT '修改人',
  `delete_flag` bit ( 1 ) NOT NULL DEFAULT 0 COMMENT '删除状态[0:未删除;1:已删除]',
  PRIMARY KEY ( `id` ) USING BTREE,
  UNIQUE KEY `uk_name` ( `name` ) USING BTREE,
  KEY `idx_create_time` ( `create_time` ) USING BTREE
) ENGINE = INNODB AUTO_INCREMENT = 100000 COMMENT = '角色权限信息';

CREATE TABLE `company` (
  `id` BIGINT ( 20 ) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` VARCHAR ( 100 ) NOT NULL COMMENT '名称',
  `status` INTEGER ( 3 ) UNSIGNED NOT NULL DEFAULT 0 COMMENT '状态[0:禁用;1:审核中;2:启用]',
  `comment` VARCHAR ( 255 ) NULL COMMENT '备注',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `creator` BIGINT ( 20 ) UNSIGNED NOT NULL DEFAULT 1 COMMENT '创建人',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modifier` BIGINT ( 20 ) UNSIGNED NOT NULL DEFAULT 1 COMMENT '修改人',
  `delete_flag` bit ( 1 ) NOT NULL DEFAULT 0 COMMENT '删除状态[0:未删除;1:已删除]',
  PRIMARY KEY ( `id` ) USING BTREE,
  UNIQUE KEY `uk_name` ( `name` ) USING BTREE,
  KEY `idx_create_time` ( `create_time` ) USING BTREE
) ENGINE = INNODB AUTO_INCREMENT = 100000 COMMENT = '集团信息';

CREATE TABLE `organization` (
  `id` BIGINT ( 20 ) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `company_id` BIGINT ( 20 ) UNSIGNED NOT NULL COMMENT '集团',
  `parent_id` BIGINT ( 20 ) UNSIGNED NOT NULL COMMENT '父级节点',
  `name` VARCHAR ( 100 ) NOT NULL COMMENT '名称',
  `level` INTEGER ( 4 ) NOT NULL DEFAULT 1 COMMENT '层级',
  `comment` VARCHAR ( 255 ) NULL COMMENT '备注',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `creator` BIGINT ( 20 ) UNSIGNED NOT NULL DEFAULT 1 COMMENT '创建人',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modifier` BIGINT ( 20 ) UNSIGNED NOT NULL DEFAULT 1 COMMENT '修改人',
  `delete_flag` bit ( 1 ) NOT NULL DEFAULT 0 COMMENT '删除状态[0:未删除;1:已删除]',
  PRIMARY KEY ( `id` ) USING BTREE,
  UNIQUE KEY `uk_company_name` ( `company_id`, `name` ) USING BTREE,
  KEY `idx_create_time` ( `create_time` ) USING BTREE
) ENGINE = INNODB AUTO_INCREMENT = 100000 COMMENT = '组织机构信息';

CREATE TABLE `member` (
  `id` BIGINT ( 20 ) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `company_id` BIGINT ( 20 ) UNSIGNED NOT NULL COMMENT '集团 id',
  `organization_id` BIGINT ( 20 ) UNSIGNED NOT NULL COMMENT '组织机构 id',
  `nick_name` VARCHAR ( 64 ) NOT NULL DEFAULT '' COMMENT '昵称',
  `username` VARCHAR ( 32 ) NOT NULL COMMENT '用户名',
  `password` VARCHAR ( 64 ) NOT NULL COMMENT '密码',
  `enabled` bit ( 1 ) NOT NULL DEFAULT 1 COMMENT '启用状态[0:未启用;1:启用]',
  `lock_status` bit ( 1 ) NOT NULL DEFAULT 0 COMMENT '锁定状态[0:未锁定;1:锁定]',
  `expired_date` DATETIME NOT NULL DEFAULT '9999-12-31 23:59:59' COMMENT '过期时间',
  `credentials_expired_date` DATETIME NOT NULL DEFAULT '9999-12-31 23:59:59' COMMENT '凭证过期时间',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `creator` BIGINT ( 20 ) UNSIGNED NOT NULL DEFAULT 1 COMMENT '创建人',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modifier` BIGINT ( 20 ) UNSIGNED NOT NULL DEFAULT 1 COMMENT '修改人',
  `delete_flag` bit ( 1 ) NOT NULL DEFAULT 0 COMMENT '删除状态[0:未删除;1:已删除]',
  PRIMARY KEY ( `id` ) USING BTREE,
  UNIQUE KEY `uk_username` ( `username` ),
  KEY `idx_create_time` ( `create_time` ) USING BTREE
) ENGINE = INNODB AUTO_INCREMENT = 100000 COMMENT = '职工信息';

CREATE TABLE `member_detail` (
  `id` BIGINT ( 20 ) UNSIGNED NOT NULL COMMENT '主键',
  `email` VARCHAR ( 50 ) NOT NULL COMMENT '邮箱',
  `mobile` VARCHAR ( 20 ) NOT NULL COMMENT '手机号',
  `name` VARCHAR ( 20 ) NOT NULL DEFAULT '' COMMENT '姓名',
  `birthday` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '出生日期',
  `description` VARCHAR ( 255 ) NOT NULL DEFAULT '' COMMENT '描述',
  `website` VARCHAR ( 50 ) NOT NULL DEFAULT '' COMMENT '主页',
  `favicon` VARCHAR ( 150 ) NOT NULL DEFAULT '' COMMENT '头像',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `creator` BIGINT ( 20 ) UNSIGNED NOT NULL DEFAULT 1 COMMENT '创建人',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modifier` BIGINT ( 20 ) UNSIGNED NOT NULL DEFAULT 1 COMMENT '修改人',
  `delete_flag` bit ( 1 ) NOT NULL DEFAULT 0 COMMENT '删除状态[0:未删除;1:已删除]',
  PRIMARY KEY ( `id` ) USING BTREE,
  UNIQUE KEY `uk_email` ( `email` ),
  UNIQUE KEY `uk_mobile` ( `mobile` ),
KEY `idx_create_time` ( `create_time` ) USING BTREE
) ENGINE = INNODB COMMENT = '职工详细信息';

CREATE TABLE `member_role` (
  `id` BIGINT ( 20 ) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `member_id` BIGINT ( 20 ) UNSIGNED NOT NULL COMMENT '职工 id',
  `role_id` BIGINT ( 20 ) UNSIGNED NOT NULL COMMENT '角色 id',
  `status` bit ( 1 ) NOT NULL DEFAULT 1 COMMENT '状态[0:未启用;1:启用]',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `creator` BIGINT ( 20 ) UNSIGNED NOT NULL DEFAULT 1 COMMENT '创建人',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modifier` BIGINT ( 20 ) UNSIGNED NOT NULL DEFAULT 1 COMMENT '修改人',
  `delete_flag` bit ( 1 ) NOT NULL DEFAULT 0 COMMENT '删除状态[0:未删除;1:已删除]',
  PRIMARY KEY ( `id` ) USING BTREE,
  UNIQUE KEY `uk_member_role` ( `member_id`,`role_id`) USING BTREE,
  KEY `idx_create_time` ( `create_time` ) USING BTREE
) ENGINE = INNODB AUTO_INCREMENT = 100000 COMMENT = '职工角色信息';