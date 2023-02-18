CREATE DATABASE IF NOT EXISTS `homeedu`;
use `homeedu`;
create table if not exists `user`
(
    id            bigint       not null
        primary key,
    name          varchar(64)  null,
    email         varchar(128) null,
    phone         varchar(32)  null,
    avatar_url    varchar(255) null,
    home_id       bigint       null,
    relative_type int          null,
    create_time   datetime     null,
    version       int          null,
    description   varchar(512) null,
    update_time   datetime     null,
    deleted       int          null,
    sex           varchar(32)  null,
    age           int          null,
    role_id       bigint       null,
    password      varchar(128) null,
    permissions   varchar(255) null,
    PRIMARY KEY (`id`),
    KEY `idx_user_home_id` (`home_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
CREATE TABLE IF NOT EXISTS `course_comment`
(
    `id`            bigint(20) NOT NULL,
    `course_id`     bigint(20)   DEFAULT NULL,
    `user_id`       bigint(20)   DEFAULT NULL,
    `content`       varchar(255) DEFAULT NULL,
    `reply`         varchar(255) DEFAULT NULL,
    `reply_user_id` bigint(20)   DEFAULT NULL,
    `reply_time`    varchar(255) DEFAULT NULL,
    `like_count`    bigint(20)   DEFAULT NULL,
    `score`         double       DEFAULT NULL,
    `create_time`   datetime     DEFAULT NULL,
    `update_time`   datetime     DEFAULT NULL,
    `version`       int          DEFAULT NULL,
    `deleted`       tinyint      DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `idx_course_comment_course_id` (`course_id`),
    KEY `idx_course_comment_user_id` (`user_id`),
    KEY `idx_course_comment_reply_user_id` (`reply_user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
CREATE TABLE IF NOT EXISTS `course_info`
(
    `id`              bigint(20) NOT NULL,
    `list_id`         bigint(20)    DEFAULT NULL,
    `title`           varchar(255)  DEFAULT NULL,
    `description`     text          DEFAULT NULL,
    `home_id`         bigint(20)    DEFAULT NULL,
    `cover_url`       varchar(255)  DEFAULT NULL,
    `teacher_ids`     varchar(512)  DEFAULT NULL,
    `student_ids`     varchar(512)  DEFAULT NULL,
    `course_ware_ids` varchar(1024) DEFAULT NULL,
#     `comment_ids`     varchar(1024) DEFAULT NULL,
    `status`          varchar(255)  DEFAULT NULL,
    `start_time`      datetime      DEFAULT NULL,
    `end_time`        datetime      DEFAULT NULL,
    `open`            tinyint(1)    DEFAULT NULL,
    `like_count`      bigint(20)    DEFAULT NULL,
    `fav_count`       bigint(20)    DEFAULT NULL,
    `comment_count`   bigint(20)    DEFAULT NULL,
    `score`           double        DEFAULT NULL,
    `create_time`     datetime      DEFAULT NULL,
    `update_time`     datetime      DEFAULT NULL,
    `version`         int           DEFAULT NULL,
    `deleted`         tinyint       DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `idx_course_info_list_id` (`list_id`),
    KEY `idx_course_info_home_id` (`home_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
CREATE TABLE IF NOT EXISTS `course_list`
(
    `id`          bigint(20) NOT NULL,
    `home_id`     bigint(20)   DEFAULT NULL,
    `course_ids`  varchar(255) DEFAULT NULL,
    `title`       varchar(255) DEFAULT NULL,
    `description` text         DEFAULT NULL,
    `cover_url`   varchar(255) DEFAULT NULL,
    `open`        tinyint(1) NOT NULL,
    `create_time` datetime     DEFAULT NULL,
    `update_time` datetime     DEFAULT NULL,
    `version`     int          DEFAULT NULL,
    `deleted`     tinyint    NOT NULL,
    PRIMARY KEY (`id`),
    KEY `idx_course_list_home_id` (`home_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE IF NOT EXISTS `course_share`
(
    `id`          bigint(20)   NOT NULL,
    `token`       varchar(255) NOT NULL,
    `course_id`   varchar(255) NOT NULL,
    `expire_time` datetime     NOT NULL,
    PRIMARY KEY (`id`),
    KEY `idx_course_share_course_id` (`course_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
CREATE TABLE IF NOT EXISTS `course_ware`
(
    `id`          bigint(20) NOT NULL,
    `course_id`   bigint(20)   DEFAULT NULL,
    `title`       varchar(255) DEFAULT NULL,
    `description` text         DEFAULT NULL,
    `icon`        varchar(255) DEFAULT NULL,
    `url`         varchar(255) DEFAULT NULL,
    `create_time` datetime     DEFAULT NULL,
    `update_time` datetime     DEFAULT NULL,
    `version`     int        NOT NULL,
    `deleted`     tinyint    NOT NULL,
    PRIMARY KEY (`id`),
    KEY `idx_course_ware_course_id` (`course_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

