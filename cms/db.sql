SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS pm_sys_area;
DROP TABLE IF EXISTS pm_sys_dept;
DROP TABLE IF EXISTS pm_sys_role_menu;
DROP TABLE IF EXISTS pm_sys_menu;
DROP TABLE IF EXISTS pm_sys_user_role;
DROP TABLE IF EXISTS pm_sys_role;
DROP TABLE IF EXISTS pm_sys_user;




/* Create Tables */

CREATE TABLE pm_sys_area
(
	-- 区域ID
	area_id int NOT NULL COMMENT '区域ID',
	-- 区域名称
	area_name varchar(64) NOT NULL COMMENT '区域名称',
	-- 父级区域ID
	parent_id int NOT NULL COMMENT '父级区域ID',
	-- 排序
	sort decimal NOT NULL COMMENT '排序',
	-- 区域编码
	area_code varchar(128) NOT NULL COMMENT '区域编码',
	-- 修改者
	update_by varchar(32) COMMENT '修改者',
	-- 修改时间
	update_time datetime COMMENT '修改时间',
	-- 删除标识（0未删除，1删除）
	del_flag char(1) DEFAULT '0' NOT NULL COMMENT '删除标识（0未删除，1删除）',
	-- 备注
	remarks varchar(255) COMMENT '备注',
	PRIMARY KEY (area_id)
);


CREATE TABLE pm_sys_dept
(
	-- 部门ID
	dept_id int NOT NULL COMMENT '部门ID',
	-- 部门名称
	dept_name varchar(100) NOT NULL COMMENT '部门名称',
	-- 父部门ID
	parent_id int NOT NULL COMMENT '父部门ID',
	-- 排序
	sort decimal NOT NULL COMMENT '排序',
	-- 部门编码
	dept_code varchar(255) NOT NULL COMMENT '部门编码',
	-- 负责人
	master varchar(100) COMMENT '负责人',
	-- 电话
	phone varchar(100) COMMENT '电话',
	-- 联系地址
	address varchar(255) COMMENT '联系地址',
	-- 邮箱
	email varchar(100) COMMENT '邮箱',
	-- 修改者
	update_by varchar(100) COMMENT '修改者',
	-- 修改时间
	update_time datetime COMMENT '修改时间',
	-- 是否删除
	del_flag char(1) DEFAULT '0' NOT NULL COMMENT '是否删除',
	-- 备注
	remarks varchar(255) COMMENT '备注',
	-- 用户ID
	user_id int NOT NULL COMMENT '用户ID',
	PRIMARY KEY (dept_id)
);


-- 菜单表
CREATE TABLE pm_sys_menu
(
	-- 菜单ID
	menu_id int NOT NULL COMMENT '菜单ID',
	-- 菜单名称
	menu_name varchar(100) NOT NULL COMMENT '菜单名称',
	-- 父级菜单ID
	parent_id int NOT NULL COMMENT '父级菜单ID',
	-- 排序
	sort decimal NOT NULL COMMENT '排序',
	-- 链接
	href varchar(255) COMMENT '链接',
	-- 目标
	target varchar(255) COMMENT '目标',
	-- 图标
	icon varchar(100) COMMENT '图标',
	-- 权限
	permission varchar(100) COMMENT '权限',
	-- 是否显示（0显示，1不显示）
	is_show char(1) DEFAULT '0' NOT NULL COMMENT '是否显示（0显示，1不显示）',
	-- 修改者
	update_by varchar(100) COMMENT '修改者',
	-- 修改时间
	update_time datetime COMMENT '修改时间',
	-- 删除标识（0未删除，1已删除）
	del_flag char(1) DEFAULT '0' NOT NULL COMMENT '删除标识（0未删除，1已删除）',
	-- 备注
	remarks varchar(255) COMMENT '备注',
	PRIMARY KEY (menu_id)
) COMMENT = '菜单表';


-- 角色表
CREATE TABLE pm_sys_role
(
	-- 角色ID
	role_id int NOT NULL COMMENT '角色ID',
	-- 角色名称
	role_name varchar(100) NOT NULL COMMENT '角色名称',
	-- 修改者
	update_by varchar(100) COMMENT '修改者',
	-- 修改时间
	update_time datetime COMMENT '修改时间',
	-- 删除标识（0未删除，1已删除）
	del_flag char(1) DEFAULT '0' NOT NULL COMMENT '删除标识（0未删除，1已删除）',
	-- 备注
	remarks varchar(255) COMMENT '备注',
	PRIMARY KEY (role_id)
) COMMENT = '角色表';


CREATE TABLE pm_sys_role_menu
(
	-- 角色ID
	role_id int NOT NULL COMMENT '角色ID',
	-- 菜单ID
	menu_id int NOT NULL COMMENT '菜单ID'
);


-- 用户表
CREATE TABLE pm_sys_user
(
	-- 用户ID
	user_id int NOT NULL COMMENT '用户ID',
	-- 用户名
	user_name varchar(100) NOT NULL COMMENT '用户名',
	-- 登陆名
	login_name varchar(100) NOT NULL COMMENT '登陆名',
	-- 密码
	password varchar(32) NOT NULL COMMENT '密码',
	-- 工号
	user_no varchar(32) COMMENT '工号',
	-- 部门ID
	dept_id int NOT NULL COMMENT '部门ID',
	-- 邮箱
	email varchar(100) COMMENT '邮箱',
	-- 电话
	phone varchar(100) COMMENT '电话',
	-- 修改者
	update_by varchar(100) COMMENT '修改者',
	-- 修改时间
	update_time datetime COMMENT '修改时间',
	-- 删除标识（0未删除，1已删除）
	del_flag char(1) DEFAULT '0' NOT NULL COMMENT '删除标识（0未删除，1已删除）',
	-- 备注
	remarks varchar(255) COMMENT '备注',
	PRIMARY KEY (user_id),
	UNIQUE (login_name)
) COMMENT = '用户表';


CREATE TABLE pm_sys_user_role
(
	-- 用户ID
	user_id int NOT NULL COMMENT '用户ID',
	-- 角色ID
	role_id int NOT NULL COMMENT '角色ID'
);



/* Create Foreign Keys */

ALTER TABLE pm_sys_role_menu
	ADD FOREIGN KEY (menu_id)
	REFERENCES pm_sys_menu (menu_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE pm_sys_role_menu
	ADD FOREIGN KEY (role_id)
	REFERENCES pm_sys_role (role_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE pm_sys_user_role
	ADD FOREIGN KEY (role_id)
	REFERENCES pm_sys_role (role_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE pm_sys_dept
	ADD FOREIGN KEY (user_id)
	REFERENCES pm_sys_user (user_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE pm_sys_user_role
	ADD FOREIGN KEY (user_id)
	REFERENCES pm_sys_user (user_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



