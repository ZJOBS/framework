CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL COMMENT '管理员名称',
  `password` varchar(120) NOT NULL COMMENT '管理员登入密码',
  `isActivating` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否激活，0禁用、1启用',
  `description` text COMMENT '说明',
  PRIMARY KEY (`id`),
  UNIQUE KEY `admin_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

INSERT INTO zhang.admin (id, name, password, isActivating, description) VALUES (1, 'zhangjie', 'c5c36892a1af06cb6ec9', 0, '系统初始账户');
INSERT INTO zhang.admin (id, name, password, isActivating, description) VALUES (2, 'ZJOBS', 'c5c36892a1af06cb6ec9', 0, '系统初始账户');




CREATE TABLE `dictionary` (
  `id` varchar(20) NOT NULL COMMENT 'ID',
  `code` varchar(45) NOT NULL COMMENT '字典代码如SEX',
  `value` varchar(45) DEFAULT '值 如 1',
  `state` varchar(45) NOT NULL DEFAULT '0' COMMENT '状态:0禁用、1启用',
  `name` varchar(45) DEFAULT NULL COMMENT '名称 如 男',
  `parentId` varchar(20) DEFAULT  '0' COMMENT '父节点ID',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE user (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  sex varchar(45) DEFAULT NULL,
  email varchar(45) NOT NULL,
  password varchar(45) NOT NULL,
  type varchar(45) DEFAULT NULL,
  isActivating tinyint(1) DEFAULT '0',
  description text,
  createUserName varchar(45) DEFAULT NULL,
  updateUserName varchar(45) DEFAULT NULL,
  createDate timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  updateDate timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
);

##以下需要重新思考

CREATE TABLE `role_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleId` int(11) DEFAULT NULL,
  `resourceId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `roleId_idx` (`roleId`),
  KEY `resourceId_idx` (`resourceId`),
  CONSTRAINT `role_resource_resourceId` FOREIGN KEY (`resourceId`) REFERENCES `resource` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `role_resource_roleId` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`) ON UPDATE CASCADE
);

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `enable` tinyint(1) DEFAULT '0',
  `description` text,
  PRIMARY KEY (`id`)
);


CREATE TABLE `resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `type` int(11) NOT NULL,
  `priority` int(11) DEFAULT NULL,
  `url` varchar(255) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `type` varchar(2) NOT NULL,
  `image` varchar(45) DEFAULT NULL,
  `state` varchar(2) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` varchar(45) NOT NULL,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `content` text NOT NULL,
  `operation` varchar(250) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
);

CREATE TABLE `dictionary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) NOT NULL,
  `value` varchar(45) NOT NULL,
  `state` varchar(45) DEFAULT '0',
  `name` varchar(45) NOT NULL,
  `parentId` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
);

CREATE TABLE `auth_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `organizationId` int(11) DEFAULT NULL,
  `desc` int(11) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);