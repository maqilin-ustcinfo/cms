/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 60011
Source Host           : localhost:3306
Source Database       : oa

Target Server Type    : MYSQL
Target Server Version : 60011
File Encoding         : 65001

Date: 2017-05-08 20:41:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `pm_sys_area`
-- ----------------------------
DROP TABLE IF EXISTS `pm_sys_area`;
CREATE TABLE `pm_sys_area` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `parent_id` int(32) NOT NULL COMMENT '父级编号',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `sort` decimal(10,0) NOT NULL COMMENT '排序',
  `code` varchar(100) DEFAULT NULL COMMENT '区域编码',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_area_parent_id` (`parent_id`),
  KEY `sys_area_del_flag` (`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='区域表';

-- ----------------------------
-- Records of pm_sys_area
-- ----------------------------
INSERT INTO `pm_sys_area` VALUES ('1', '0', '中国', '10', '086', '1', '2015-07-10 08:00:00', '', '0');

-- ----------------------------
-- Table structure for `pm_sys_dept`
-- ----------------------------
DROP TABLE IF EXISTS `pm_sys_dept`;
CREATE TABLE `pm_sys_dept` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `parent_id` int(32) NOT NULL COMMENT '父级编号',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `sort` decimal(10,0) NOT NULL COMMENT '排序',
  `code` varchar(100) DEFAULT NULL COMMENT '区域编码',
  `address` varchar(255) DEFAULT NULL COMMENT '联系地址',
  `master` varchar(100) DEFAULT NULL COMMENT '负责人',
  `phone` varchar(200) DEFAULT NULL COMMENT '电话',
  `fax` varchar(200) DEFAULT NULL COMMENT '传真',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_office_parent_id` (`parent_id`),
  KEY `sys_office_del_flag` (`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='机构表';

-- ----------------------------
-- Records of pm_sys_dept
-- ----------------------------
INSERT INTO `pm_sys_dept` VALUES ('1', '0', '潭州学院', '10', '100000', '', '', '', '', '', '1', '2016-12-05 22:04:26', '', '0');

-- ----------------------------
-- Table structure for `pm_sys_dict`
-- ----------------------------
DROP TABLE IF EXISTS `pm_sys_dict`;
CREATE TABLE `pm_sys_dict` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `value` varchar(100) NOT NULL COMMENT '数据值',
  `label` varchar(100) NOT NULL COMMENT '标签名',
  `type` varchar(100) NOT NULL COMMENT '类型',
  `description` varchar(100) NOT NULL COMMENT '描述',
  `sort` decimal(10,0) NOT NULL COMMENT '排序（升序）',
  `parent_id` varchar(64) DEFAULT '0' COMMENT '父级编号',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_dict_value` (`value`),
  KEY `sys_dict_label` (`label`),
  KEY `sys_dict_del_flag` (`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8 COMMENT='字典表';

-- ----------------------------
-- Records of pm_sys_dict
-- ----------------------------
INSERT INTO `pm_sys_dict` VALUES ('1', '0', '正常', 'del_flag', '删除标记', '10', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pm_sys_dict` VALUES ('2', '1', '删除', 'del_flag', '删除标记', '20', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pm_sys_dict` VALUES ('3', '1', '显示', 'show_hide', '显示/隐藏', '10', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pm_sys_dict` VALUES ('4', '0', '隐藏', 'show_hide', '显示/隐藏', '20', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pm_sys_dict` VALUES ('5', '1', '是', 'yes_no', '是/否', '10', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pm_sys_dict` VALUES ('6', '0', '否', 'yes_no', '是/否', '20', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pm_sys_dict` VALUES ('17', '1', '国家', 'sys_area_type', '区域类型', '10', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pm_sys_dict` VALUES ('18', '2', '省份、直辖市', 'sys_area_type', '区域类型', '20', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pm_sys_dict` VALUES ('19', '3', '地市', 'sys_area_type', '区域类型', '30', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pm_sys_dict` VALUES ('20', '4', '区县', 'sys_area_type', '区域类型', '40', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pm_sys_dict` VALUES ('21', '1', '公司', 'sys_office_type', '机构类型', '60', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pm_sys_dict` VALUES ('22', '2', '部门', 'sys_office_type', '机构类型', '70', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pm_sys_dict` VALUES ('23', '3', '小组', 'sys_office_type', '机构类型', '80', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pm_sys_dict` VALUES ('24', '4', '其它', 'sys_office_type', '机构类型', '90', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pm_sys_dict` VALUES ('28', '1', '一级', 'sys_office_grade', '机构等级', '10', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pm_sys_dict` VALUES ('29', '2', '二级', 'sys_office_grade', '机构等级', '20', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pm_sys_dict` VALUES ('30', '3', '三级', 'sys_office_grade', '机构等级', '30', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pm_sys_dict` VALUES ('31', '4', '四级', 'sys_office_grade', '机构等级', '40', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pm_sys_dict` VALUES ('32', '1', '所有数据', 'sys_data_scope', '数据范围', '10', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pm_sys_dict` VALUES ('33', '2', '所在公司及以下数据', 'sys_data_scope', '数据范围', '20', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pm_sys_dict` VALUES ('34', '3', '所在公司数据', 'sys_data_scope', '数据范围', '30', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pm_sys_dict` VALUES ('35', '4', '所在部门及以下数据', 'sys_data_scope', '数据范围', '40', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pm_sys_dict` VALUES ('36', '5', '所在部门数据', 'sys_data_scope', '数据范围', '50', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pm_sys_dict` VALUES ('37', '8', '仅本人数据', 'sys_data_scope', '数据范围', '90', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pm_sys_dict` VALUES ('38', '9', '按明细设置', 'sys_data_scope', '数据范围', '100', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pm_sys_dict` VALUES ('39', '1', '系统管理', 'sys_user_type', '用户类型', '10', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pm_sys_dict` VALUES ('40', '2', '部门经理', 'sys_user_type', '用户类型', '20', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pm_sys_dict` VALUES ('41', '3', '普通用户', 'sys_user_type', '用户类型', '30', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pm_sys_dict` VALUES ('67', '1', '操作日志', 'sys_log_type', '日志类型', '30', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pm_sys_dict` VALUES ('68', '2', '异常日志', 'sys_log_type', '日志类型', '40', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pm_sys_dict` VALUES ('96', '1', '男', 'sex', '性别', '10', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pm_sys_dict` VALUES ('97', '2', '女', 'sex', '性别', '20', '0', '1', '2015-07-10 08:00:00', null, '0');

-- ----------------------------
-- Table structure for `pm_sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `pm_sys_menu`;
CREATE TABLE `pm_sys_menu` (
  `id` int(64) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `parent_id` int(64) NOT NULL COMMENT '父级编号',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `sort` decimal(10,0) NOT NULL COMMENT '排序',
  `href` varchar(2000) DEFAULT NULL COMMENT '链接',
  `target` varchar(20) DEFAULT NULL COMMENT '目标',
  `icon` varchar(100) DEFAULT NULL COMMENT '图标',
  `is_show` char(1) NOT NULL COMMENT '是否在菜单中显示',
  `permission` varchar(200) DEFAULT NULL COMMENT '权限标识',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_menu_parent_id` (`parent_id`),
  KEY `sys_menu_del_flag` (`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of pm_sys_menu
-- ----------------------------
INSERT INTO `pm_sys_menu` VALUES ('1', '0', '功能菜单', '10', '', '', '', '1', '', '1', '2017-04-20 16:52:01', '', '0');
INSERT INTO `pm_sys_menu` VALUES ('3', '1', '系统设置', '20', '', '', '', '1', '', '1', '2017-04-21 16:25:00', '', '0');
INSERT INTO `pm_sys_menu` VALUES ('4', '3', '菜单管理', '10', '/sysmgr/menu/gotoMenuList', null, 'list-alt', '1', null, '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pm_sys_menu` VALUES ('7', '3', '角色管理', '20', '/sysmgr/role/gotoRoleList', '', 'lock', '1', '', '1', '2016-11-29 17:09:58', '', '0');
INSERT INTO `pm_sys_menu` VALUES ('10', '3', '字典管理', '30', '/sysmgr/dict/gotoDictList', '', 'th-list', '1', null, '1', '2017-04-21 16:32:32', '', '0');
INSERT INTO `pm_sys_menu` VALUES ('14', '3', '区域管理', '30', '/sysmgr/area/gotoAreaList', '', 'th', '1', '', '1', '2017-04-21 16:29:17', '', '0');
INSERT INTO `pm_sys_menu` VALUES ('17', '3', '部门管理', '20', '/sysmgr/dept/gotoDeptList', '', 'th-large', '1', '', '1', '2017-04-21 16:29:52', '', '0');
INSERT INTO `pm_sys_menu` VALUES ('20', '3', '用户管理', '10', '/sysmgr/user/gotoUserList', '', 'user', '1', '', '1', '2017-04-21 16:30:09', '', '0');
INSERT INTO `pm_sys_menu` VALUES ('28', '1', '个人信息管理', '10', '', '', null, '1', null, '1', '2017-04-21 16:31:44', '', '0');
INSERT INTO `pm_sys_menu` VALUES ('29', '28', '个人信息', '20', '/sysmgr/user/gotoUserInfo', '', 'user', '1', null, '1', '2017-04-21 16:31:25', '', '0');
INSERT INTO `pm_sys_menu` VALUES ('30', '28', '修改密码', '30', '/sysmgr/user/gotoChangePwd', '', 'lock', '1', '', '1', '2017-04-21 16:32:12', '', '0');

-- ----------------------------
-- Table structure for `pm_sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `pm_sys_role`;
CREATE TABLE `pm_sys_role` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(100) NOT NULL COMMENT '角色名称',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_role_del_flag` (`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of pm_sys_role
-- ----------------------------
INSERT INTO `pm_sys_role` VALUES ('1', '超级系统管理员', '1', '2017-05-08 20:35:52', '', '0');

-- ----------------------------
-- Table structure for `pm_sys_role_area`
-- ----------------------------
DROP TABLE IF EXISTS `pm_sys_role_area`;
CREATE TABLE `pm_sys_role_area` (
  `role_id` int(32) NOT NULL COMMENT '角色编号',
  `area_id` int(32) NOT NULL COMMENT '菜单编号',
  PRIMARY KEY (`role_id`,`area_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-菜单';

-- ----------------------------
-- Records of pm_sys_role_area
-- ----------------------------
INSERT INTO `pm_sys_role_area` VALUES ('1', '1');

-- ----------------------------
-- Table structure for `pm_sys_role_dept`
-- ----------------------------
DROP TABLE IF EXISTS `pm_sys_role_dept`;
CREATE TABLE `pm_sys_role_dept` (
  `role_id` int(32) NOT NULL COMMENT '角色编号',
  `dept_id` int(32) NOT NULL COMMENT '菜单编号',
  PRIMARY KEY (`role_id`,`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-菜单';

-- ----------------------------
-- Records of pm_sys_role_dept
-- ----------------------------
INSERT INTO `pm_sys_role_dept` VALUES ('1', '1');

-- ----------------------------
-- Table structure for `pm_sys_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `pm_sys_role_menu`;
CREATE TABLE `pm_sys_role_menu` (
  `role_id` int(32) NOT NULL COMMENT '角色编号',
  `menu_id` int(32) NOT NULL COMMENT '菜单编号',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-菜单';

-- ----------------------------
-- Records of pm_sys_role_menu
-- ----------------------------
INSERT INTO `pm_sys_role_menu` VALUES ('1', '1');
INSERT INTO `pm_sys_role_menu` VALUES ('1', '3');
INSERT INTO `pm_sys_role_menu` VALUES ('1', '4');
INSERT INTO `pm_sys_role_menu` VALUES ('1', '7');
INSERT INTO `pm_sys_role_menu` VALUES ('1', '10');
INSERT INTO `pm_sys_role_menu` VALUES ('1', '14');
INSERT INTO `pm_sys_role_menu` VALUES ('1', '17');
INSERT INTO `pm_sys_role_menu` VALUES ('1', '20');
INSERT INTO `pm_sys_role_menu` VALUES ('1', '28');
INSERT INTO `pm_sys_role_menu` VALUES ('1', '29');
INSERT INTO `pm_sys_role_menu` VALUES ('1', '30');

-- ----------------------------
-- Table structure for `pm_sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `pm_sys_user`;
CREATE TABLE `pm_sys_user` (
  `user_id` int(32) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `dept_id` int(32) NOT NULL COMMENT '归属部门',
  `login_name` varchar(100) NOT NULL COMMENT '登录名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `user_no` varchar(100) DEFAULT NULL COMMENT '工号',
  `user_name` varchar(100) NOT NULL COMMENT '姓名',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(200) DEFAULT NULL COMMENT '电话',
  `mobile` varchar(200) DEFAULT NULL COMMENT '手机',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`user_id`),
  KEY `sys_user_office_id` (`dept_id`),
  KEY `sys_user_login_name` (`login_name`),
  KEY `sys_user_update_date` (`update_date`),
  KEY `sys_user_del_flag` (`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of pm_sys_user
-- ----------------------------
INSERT INTO `pm_sys_user` VALUES ('1', '1', 'admin', '24e3829ffe5522e801fd4c80816e7331e33445ee3ed510f1fefa5592', '0001', 'keven', 'tz4@tanzhouedu.com', '12345', '45645', '1', '2016-12-02 15:58:08', '78945', '0');

-- ----------------------------
-- Table structure for `pm_sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `pm_sys_user_role`;
CREATE TABLE `pm_sys_user_role` (
  `user_id` int(32) NOT NULL COMMENT '用户编号',
  `role_id` int(32) NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户-角色';

-- ----------------------------
-- Records of pm_sys_user_role
-- ----------------------------
INSERT INTO `pm_sys_user_role` VALUES ('1', '1');
