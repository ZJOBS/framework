CREATE TABLE admin (
  id           int(11)      NOT NULL AUTO_INCREMENT,
  name         varchar(20)  NOT NULL
  COMMENT '管理员名称',
  password     varchar(120) NOT NULL
  COMMENT '管理员登入密码',
  isActivating tinyint(4)   NOT NULL DEFAULT '0'
  COMMENT '是否激活，0禁用、1启用',
  description  text COMMENT '说明',
  PRIMARY KEY (id),
  UNIQUE KEY admin_id_uindex (id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8;

INSERT INTO zhang.admin (id, name, password, isActivating, description)
VALUES (1, 'zhangjie', 'c5c36892a1af06cb6ec9', 0, '系统初始账户');
INSERT INTO zhang.admin (id, name, password, isActivating, description)
VALUES (2, 'ZJOBS', 'c5c36892a1af06cb6ec9', 0, '系统初始账户');


CREATE TABLE dictionary (
  id       varchar(20) NOT NULL
  COMMENT 'ID',
  code     varchar(45) NOT NULL
  COMMENT '字典代码如SEX',
  value    varchar(45)          DEFAULT '值 如 1',
  state    varchar(45) NOT NULL DEFAULT '0'
  COMMENT '状态:0禁用、1启用',
  name     varchar(45)          DEFAULT NULL
  COMMENT '名称 如 男',
  parentId varchar(20)          DEFAULT '0'
  COMMENT '父节点ID',
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


CREATE TABLE user (
  id             int(11)     NOT NULL AUTO_INCREMENT,
  name           varchar(45) NOT NULL,
  sex            varchar(45)          DEFAULT NULL,
  email          varchar(45) NOT NULL,
  password       varchar(45) NOT NULL,
  type           varchar(45)          DEFAULT NULL,
  isActivating   tinyint(1)           DEFAULT '0',
  description    text,
  createUserName varchar(45)          DEFAULT NULL,
  updateUserName varchar(45)          DEFAULT NULL,
  createDate     timestamp   NULL     DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP,
  updateDate     timestamp   NULL     DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);

##以下需要重新思考

CREATE TABLE role_resource (
  id         int(11) NOT NULL AUTO_INCREMENT,
  roleId     int(11)          DEFAULT NULL,
  resourceId int(11)          DEFAULT NULL,
  PRIMARY KEY (id),
  KEY roleId_idx (roleId),
  KEY resourceId_idx (resourceId),
  CONSTRAINT role_resource_resourceId FOREIGN KEY (resourceId) REFERENCES resource (id)
    ON UPDATE CASCADE,
  CONSTRAINT role_resource_roleId FOREIGN KEY (roleId) REFERENCES role (id)
    ON UPDATE CASCADE
);

CREATE TABLE role (
  id          int(11)      NOT NULL AUTO_INCREMENT,
  name        varchar(255) NOT NULL,
  enable      tinyint(1)            DEFAULT '0',
  description text,
  PRIMARY KEY (id)
);


CREATE TABLE resource (
  id          int(11)      NOT NULL AUTO_INCREMENT,
  name        varchar(45)  NOT NULL,
  type        int(11)      NOT NULL,
  priority    int(11)               DEFAULT NULL,
  url         varchar(255) NOT NULL,
  description varchar(45)           DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE product (
  id    int(11)     NOT NULL AUTO_INCREMENT,
  name  varchar(45) NOT NULL,
  type  varchar(2)  NOT NULL,
  image varchar(45)          DEFAULT NULL,
  state varchar(2)  NOT NULL,
  price double      NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE log (
  id         int(11)      NOT NULL AUTO_INCREMENT,
  userId     varchar(45)  NOT NULL,
  createDate timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP,
  content    text         NOT NULL,
  operation  varchar(250) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id)
);

CREATE TABLE dictionary (
  id       int(11)     NOT NULL AUTO_INCREMENT,
  code     varchar(45) NOT NULL,
  value    varchar(45) NOT NULL,
  state    varchar(45)          DEFAULT '0',
  name     varchar(45) NOT NULL,
  parentId int(11)              DEFAULT '0',
  PRIMARY KEY (id)
);

CREATE TABLE auth_role (
  id             int(11) NOT NULL AUTO_INCREMENT,
  name           varchar(45)      DEFAULT NULL,
  organizationId int(11)          DEFAULT NULL,
  desc           int(11)          DEFAULT NULL,
  status         varchar(45)      DEFAULT NULL,
  PRIMARY KEY (id)
);

# 集群定时器


drop table if exists quartz_fired_triggers;
drop table if exists quartz_paused_trigger_grps;
drop table if exists quartz_scheduler_state;
drop table if exists quartz_locks;
drop table if exists quartz_simple_triggers;
drop table if exists quartz_simprop_triggers;
drop table if exists quartz_cron_triggers;
drop table if exists quartz_blob_triggers;
drop table if exists quartz_triggers;
drop table if exists quartz_job_details;
drop table if exists quartz_calendars;

Create table quartz_job_details (
  sched_name        varchar(120) not null,
  job_name          varchar(200) not null,
  job_group         varchar(200) not null,
  description       varchar(250) null,
  job_class_name    varchar(250) not null,
  is_durable        varchar(1)   not null,
  is_nonconcurrent  varchar(1)   not null,
  is_update_data    varchar(1)   not null,
  requests_recovery varchar(1)   not null,
  job_data          blob         null,
  primary key (sched_name, job_name, job_group)
)
  engine = innodb;

create table quartz_triggers (
  sched_name     varchar(120) not null,
  trigger_name   varchar(200) not null,
  trigger_group  varchar(200) not null,
  job_name       varchar(200) not null,
  job_group      varchar(200) not null,
  description    varchar(250) null,
  next_fire_time bigint(13)   null,
  prev_fire_time bigint(13)   null,
  priority       integer      null,
  trigger_state  varchar(16)  not null,
  trigger_type   varchar(8)   not null,
  start_time     bigint(13)   not null,
  end_time       bigint(13)   null,
  calendar_name  varchar(200) null,
  misfire_instr  smallint(2)  null,
  job_data       blob         null,
  primary key (sched_name, trigger_name, trigger_group),
  foreign key (sched_name, job_name, job_group)
  references quartz_job_details (sched_name, job_name, job_group)
)
  engine = innodb;

create table quartz_simple_triggers (
  sched_name      varchar(120) not null,
  trigger_name    varchar(200) not null,
  trigger_group   varchar(200) not null,
  repeat_count    bigint(7)    not null,
  repeat_interval bigint(12)   not null,
  times_triggered bigint(10)   not null,
  primary key (sched_name, trigger_name, trigger_group),
  foreign key (sched_name, trigger_name, trigger_group)
  references quartz_triggers (sched_name, trigger_name, trigger_group)
)
  engine = innodb;

create table quartz_cron_triggers (
  sched_name      varchar(120) not null,
  trigger_name    varchar(200) not null,
  trigger_group   varchar(200) not null,
  cron_expression varchar(120) not null,
  time_zone_id    varchar(80),
  primary key (sched_name, trigger_name, trigger_group),
  foreign key (sched_name, trigger_name, trigger_group)
  references quartz_triggers (sched_name, trigger_name, trigger_group)
)
  engine = innodb;


create table quartz_simprop_triggers
(
  sched_name    varchar(120)   not null,
  trigger_name  varchar(200)   not null,
  trigger_group varchar(200)   not null,
  str_prop_1    varchar(512)   null,
  str_prop_2    varchar(512)   null,
  str_prop_3    varchar(512)   null,
  int_prop_1    int            null,
  int_prop_2    int            null,
  long_prop_1   bigint         null,
  long_prop_2   bigint         null,
  dec_prop_1    numeric(13, 4) null,
  dec_prop_2    numeric(13, 4) null,
  bool_prop_1   varchar(1)     null,
  bool_prop_2   varchar(1)     null,
  primary key (sched_name, trigger_name, trigger_group),
  foreign key (sched_name, trigger_name, trigger_group)
  references quartz_triggers (sched_name, trigger_name, trigger_group)
)
  engine = innodb;

create table quartz_blob_triggers (
  sched_name    varchar(120) not null,
  trigger_name  varchar(200) not null,
  trigger_group varchar(200) not null,
  blob_data     blob         null,
  primary key (sched_name, trigger_name, trigger_group),
  index (sched_name, trigger_name, trigger_group),
  foreign key (sched_name, trigger_name, trigger_group)
  references quartz_triggers (sched_name, trigger_name, trigger_group)
)
  engine = innodb;

create table quartz_calendars (
  sched_name    varchar(120) not null,
  calendar_name varchar(200) not null,
  calendar      blob         not null,
  primary key (sched_name, calendar_name)
)
  engine = innodb;

create table quartz_paused_trigger_grps (
  sched_name    varchar(120) not null,
  trigger_group varchar(200) not null,
  primary key (sched_name, trigger_group)
)
  engine = innodb;

create table quartz_fired_triggers (
  sched_name        varchar(120) not null,
  entry_id          varchar(95)  not null,
  trigger_name      varchar(200) not null,
  trigger_group     varchar(200) not null,
  instance_name     varchar(200) not null,
  fired_time        bigint(13)   not null,
  sched_time        bigint(13)   not null,
  priority          integer      not null,
  state             varchar(16)  not null,
  job_name          varchar(200) null,
  job_group         varchar(200) null,
  is_nonconcurrent  varchar(1)   null,
  requests_recovery varchar(1)   null,
  primary key (sched_name, entry_id)
)
  engine = innodb;

create table quartz_scheduler_state (
  sched_name        varchar(120) not null,
  instance_name     varchar(200) not null,
  last_checkin_time bigint(13)   not null,
  checkin_interval  bigint(13)   not null,
  primary key (sched_name, instance_name)
)
  engine = innodb;

create table quartz_locks (
  sched_name varchar(120) not null,
  lock_name  varchar(40)  not null,
  primary key (sched_name, lock_name)
)
  engine = innodb;

create index idx_qrtz_j_req_recovery
  on quartz_job_details (sched_name, requests_recovery);
create index idx_qrtz_j_grp
  on quartz_job_details (sched_name, job_group);

create index idx_qrtz_t_j
  on quartz_triggers (sched_name, job_name, job_group);
create index idx_qrtz_t_jg
  on quartz_triggers (sched_name, job_group);
create index idx_qrtz_t_c
  on quartz_triggers (sched_name, calendar_name);
create index idx_qrtz_t_g
  on quartz_triggers (sched_name, trigger_group);
create index idx_qrtz_t_state
  on quartz_triggers (sched_name, trigger_state);
create index idx_qrtz_t_n_state
  on quartz_triggers (sched_name, trigger_name, trigger_group, trigger_state);
create index idx_qrtz_t_n_g_state
  on quartz_triggers (sched_name, trigger_group, trigger_state);
create index idx_qrtz_t_next_fire_time
  on quartz_triggers (sched_name, next_fire_time);
create index idx_qrtz_t_nft_st
  on quartz_triggers (sched_name, trigger_state, next_fire_time);
create index idx_qrtz_t_nft_misfire
  on quartz_triggers (sched_name, misfire_instr, next_fire_time);
create index idx_qrtz_t_nft_st_misfire
  on quartz_triggers (sched_name, misfire_instr, next_fire_time, trigger_state);
create index idx_qrtz_t_nft_st_misfire_grp
  on quartz_triggers (sched_name, misfire_instr, next_fire_time, trigger_group, trigger_state);

create index idx_qrtz_ft_trig_inst_name
  on quartz_fired_triggers (sched_name, instance_name);
create index idx_qrtz_ft_inst_job_req_rcvry
  on quartz_fired_triggers (sched_name, instance_name, requests_recovery);
create index idx_qrtz_ft_j_g
  on quartz_fired_triggers (sched_name, job_name, job_group);
create index idx_qrtz_ft_jg
  on quartz_fired_triggers (sched_name, job_group);
create index idx_qrtz_ft_t_g
  on quartz_fired_triggers (sched_name, trigger_name, trigger_group);
create index idx_qrtz_ft_tg
  on quartz_fired_triggers (sched_name, trigger_group);

commit;