CREATE DATABASE IF NOT EXISTS `tinyid`;
use tinyid;
CREATE TABLE `tiny_id_info`
(
    `id`          bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `biz_type`    varchar(63) NOT NULL DEFAULT '' COMMENT '业务类型，唯一',
    `begin_id`    bigint(20)  NOT NULL DEFAULT '0' COMMENT '开始id，仅记录初始值，无其他含义。初始化时begin_id和max_id应相同',
    `max_id`      bigint(20)  NOT NULL DEFAULT '0' COMMENT '当前最大id',
    `step`        int(11)              DEFAULT '0' COMMENT '步长',
    `delta`       int(11)     NOT NULL DEFAULT '1' COMMENT '每次id增量',
    `remainder`   int(11)     NOT NULL DEFAULT '0' COMMENT '余数',
    `create_time` timestamp   NOT NULL DEFAULT '2023-01-01 00:00:00' COMMENT '创建时间',
    `update_time` timestamp   NOT NULL DEFAULT '2023-01-01 00:00:00' COMMENT '更新时间',
    `version`     bigint(20)  NOT NULL DEFAULT '0' COMMENT '版本号',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uniq_biz_type` (`biz_type`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8 COMMENT 'id信息表';

CREATE TABLE `tiny_id_token`
(
    `id`          int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `token`       varchar(255)     NOT NULL DEFAULT '' COMMENT 'token',
    `biz_type`    varchar(63)      NOT NULL DEFAULT '' COMMENT '此token可访问的业务类型标识',
    `remark`      varchar(255)     NOT NULL DEFAULT '' COMMENT '备注',
    `create_time` timestamp        NOT NULL DEFAULT '2023-01-01 00:00:00' COMMENT '创建时间',
    `update_time` timestamp        NOT NULL DEFAULT '2023-01-01 00:00:00' COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8 COMMENT 'token信息表';

CREATE TABLE `undo_log`
(
    `id`            bigint(20)   NOT NULL AUTO_INCREMENT,
    `branch_id`     bigint(20)   NOT NULL,
    `xid`           varchar(100) NOT NULL,
    `context`       varchar(128) NOT NULL,
    `rollback_info` longblob     NOT NULL,
    `log_status`    int(11)      NOT NULL,
    `log_created`   datetime     NOT NULL,
    `log_modified`  datetime     NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `ux_undo_log` (`xid`, `branch_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;


insert into `tiny_id_info` (id, biz_type, begin_id, max_id, step, delta, remainder, create_time, update_time, version)
values (1, 'course_comment', 1, 1, 100, 1, 0, '2023-01-01 00:00:00', '2023-01-01 00:00:00', 1);
insert into `tiny_id_info` (id, biz_type, begin_id, max_id, step, delta, remainder, create_time, update_time, version)
values (2, 'course_info', 1, 1, 100, 1, 0, '2023-01-01 00:00:00', '2023-01-01 00:00:00', 1);
insert into `tiny_id_info` (id, biz_type, begin_id, max_id, step, delta, remainder, create_time, update_time, version)
values (3, 'course_join', 1, 1, 100, 1, 0, '2023-01-01 00:00:00', '2023-01-01 00:00:00', 1);
insert into `tiny_id_info` (id, biz_type, begin_id, max_id, step, delta, remainder, create_time, update_time, version)
values (4, 'course_list', 1, 1, 100, 1, 0, '2023-01-01 00:00:00', '2023-01-01 00:00:00', 1);
insert into `tiny_id_info` (id, biz_type, begin_id, max_id, step, delta, remainder, create_time, update_time, version)
values (5, 'course_share', 1, 1, 100, 1, 0, '2023-01-01 00:00:00', '2023-01-01 00:00:00', 1);
insert into `tiny_id_info` (id, biz_type, begin_id, max_id, step, delta, remainder, create_time, update_time, version)
values (6, 'course_ware', 1, 1, 100, 1, 0, '2023-01-01 00:00:00', '2023-01-01 00:00:00', 1);
insert into `tiny_id_info` (id, biz_type, begin_id, max_id, step, delta, remainder, create_time, update_time, version)
values (7, 'home_info', 1, 1, 100, 1, 0, '2023-01-01 00:00:00', '2023-01-01 00:00:00', 1);
insert into `tiny_id_info` (id, biz_type, begin_id, max_id, step, delta, remainder, create_time, update_time, version)
values (8, 'user', 1, 1, 100, 1, 0, '2023-01-01 00:00:00', '2023-01-01 00:00:00', 1);
insert into `tiny_id_info` (id, biz_type, begin_id, max_id, step, delta, remainder, create_time, update_time, version)
values (9, 'schedule', 1, 1, 100, 1, 0, '2023-01-01 00:00:00', '2023-01-01 00:00:00', 1);
insert into `tiny_id_info` (id, biz_type, begin_id, max_id, step, delta, remainder, create_time, update_time, version)
values (10, 'msg_sys', 1, 1, 100, 1, 0, '2023-01-01 00:00:00', '2023-01-01 00:00:00', 1);
insert into `tiny_id_info` (id, biz_type, begin_id, max_id, step, delta, remainder, create_time, update_time, version)
values (11, 'msg_home', 1, 1, 100, 1, 0, '2023-01-01 00:00:00', '2023-01-01 00:00:00', 1);
insert into `tiny_id_info` (id, biz_type, begin_id, max_id, step, delta, remainder, create_time, update_time, version)
values (12, 'issue', 1, 1, 100, 1, 0, '2023-01-01 00:00:00', '2023-01-01 00:00:00', 1);
insert into `tiny_id_info` (id, biz_type, begin_id, max_id, step, delta, remainder, create_time, update_time, version)
values (13, 'issue_reply', 1, 1, 100, 1, 0, '2023-01-01 00:00:00', '2023-01-01 00:00:00', 1);

insert into `tiny_id_token` (id, token, biz_type, remark, create_time, update_time)
values (1, '0f673adf80504e2eaa552f5d791b644c', 'course_comment', '1', '2023-01-01 00:00:00', '2023-01-01 00:00:00');
insert into `tiny_id_token` (id, token, biz_type, remark, create_time, update_time)
values (2, '0f673adf80504e2eaa552f5d791b644c', 'course_info', '1', '2023-01-01 00:00:00', '2023-01-01 00:00:00');
insert into `tiny_id_token` (id, token, biz_type, remark, create_time, update_time)
values (3, '0f673adf80504e2eaa552f5d791b644c', 'course_join', '1', '2023-01-01 00:00:00', '2023-01-01 00:00:00');
insert into `tiny_id_token` (id, token, biz_type, remark, create_time, update_time)
values (4, '0f673adf80504e2eaa552f5d791b644c', 'course_list', '1', '2023-01-01 00:00:00', '2023-01-01 00:00:00');
insert into `tiny_id_token` (id, token, biz_type, remark, create_time, update_time)
values (5, '0f673adf80504e2eaa552f5d791b644c', 'course_share', '1', '2023-01-01 00:00:00', '2023-01-01 00:00:00');
insert into `tiny_id_token` (id, token, biz_type, remark, create_time, update_time)
values (6, '0f673adf80504e2eaa552f5d791b644c', 'course_ware', '1', '2023-01-01 00:00:00', '2023-01-01 00:00:00');
insert into `tiny_id_token` (id, token, biz_type, remark, create_time, update_time)
values (7, '0f673adf80504e2eaa552f5d791b644c', 'home_info', '1', '2023-01-01 00:00:00', '2023-01-01 00:00:00');
insert into `tiny_id_token` (id, token, biz_type, remark, create_time, update_time)
values (8, '0f673adf80504e2eaa552f5d791b644c', 'user', '1', '2023-01-01 00:00:00', '2023-01-01 00:00:00');
insert into `tiny_id_token` (id, token, biz_type, remark, create_time, update_time)
values (9, '0f673adf80504e2eaa552f5d791b644c', 'schedule', '1', '2023-01-01 00:00:00', '2023-01-01 00:00:00');
insert into `tiny_id_token` (id, token, biz_type, remark, create_time, update_time)
values (10, '0f673adf80504e2eaa552f5d791b644c', 'msg_sys', '1', '2023-01-01 00:00:00', '2023-01-01 00:00:00');
insert into `tiny_id_token` (id, token, biz_type, remark, create_time, update_time)
values (11, '0f673adf80504e2eaa552f5d791b644c', 'msg_home', '1', '2023-01-01 00:00:00', '2023-01-01 00:00:00');
insert into `tiny_id_token` (id, token, biz_type, remark, create_time, update_time)
values (12, '0f673adf80504e2eaa552f5d791b644c', 'issue', '1', '2023-01-01 00:00:00', '2023-01-01 00:00:00');
insert into `tiny_id_token` (id, token, biz_type, remark, create_time, update_time)
values (13, '0f673adf80504e2eaa552f5d791b644c', 'issue_reply', '1', '2023-01-01 00:00:00', '2023-01-01 00:00:00');