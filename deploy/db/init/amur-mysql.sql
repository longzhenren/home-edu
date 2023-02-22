CREATE DATABASE IF NOT EXISTS `homeedu`;
use `homeedu`;
CREATE TABLE IF NOT EXISTS `user_info`
(
    `id`            bigint NOT NULL,
    `name`          varchar(64)  DEFAULT NULL,
    `email`         varchar(128) DEFAULT NULL,
    `phone`         varchar(32)  DEFAULT NULL,
    `avatar_url`    varchar(255) DEFAULT NULL,
    `home_id`       bigint       DEFAULT NULL,
    `sex`           varchar(32)  DEFAULT NULL,
    `age`           int          DEFAULT NULL,
    `relative_type` int          DEFAULT NULL,
    `create_time`   datetime     DEFAULT NULL,
    `like_count`    int          DEFAULT NULL,
    `fav_count`     int          DEFAULT NULL,
    `version`       int          DEFAULT NULL,
    `description`   varchar(512) DEFAULT NULL,
    `update_time`   datetime     DEFAULT NULL,
    `deleted`       tinyint(1)   DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `idx_user_home_id` (`home_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `user_auth`
(
    `id`          bigint NOT NULL,
    `password`    varchar(128) DEFAULT NULL,
    `permissions` json         DEFAULT NULL,
    `roles`       json         DEFAULT NULL,
    `create_time` datetime     DEFAULT NULL,
    `update_time` datetime     DEFAULT NULL,
    `version`     int          DEFAULT NULL,
    `deleted`     tinyint(1)   DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `user_permission`
(
    `id`          bigint NOT NULL,
    `user_id`     bigint     DEFAULT NULL,
    `role_id`     bigint     DEFAULT NULL,
    `create_time` datetime   DEFAULT NULL,
    `update_time` datetime   DEFAULT NULL,
    `version`     int        DEFAULT NULL,
    `deleted`     tinyint(1) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `idx_user_role_user_id` (`user_id`),
    KEY `idx_user_role_role_id` (`role_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `user_fav`
(
    `id`              bigint NOT NULL,
    `user_ids`        json       DEFAULT NULL,
    `home_ids`        json       DEFAULT NULL,
    `course_ids`      json       DEFAULT NULL,
    `course_ware_ids` json       DEFAULT NULL,
    `course_list_ids` json       DEFAULT NULL,
    `user_map`        json       DEFAULT NULL,
    `create_time`     datetime   DEFAULT NULL,
    `update_time`     datetime   DEFAULT NULL,
    `version`         int    NOT NULL,
    `deleted`         tinyint(1) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `course_comment`
(
    `id`            bigint NOT NULL,
    `course_id`     bigint       DEFAULT NULL,
    `user_id`       bigint       DEFAULT NULL,
    `content`       varchar(255) DEFAULT NULL,
    `reply`         varchar(255) DEFAULT NULL,
    `reply_user_id` varchar(255) DEFAULT NULL,
    `reply_time`    varchar(255) DEFAULT NULL,
    `like_count`    bigint(20)   DEFAULT NULL,
    `score`         double       DEFAULT NULL,
    `create_time`   datetime     DEFAULT NULL,
    `update_time`   datetime     DEFAULT NULL,
    `version`       int          DEFAULT NULL,
    `deleted`       tinyint(1)   DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `idx_course_comment_user_id` (`user_id`),
    KEY `idx_course_comment_course_id` (`course_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
CREATE TABLE IF NOT EXISTS `course_info`
(
    `id`            bigint NOT NULL,
    `name`          varchar(255) DEFAULT NULL,
    `description`   varchar(255) DEFAULT NULL,
    `home_id`       bigint       DEFAULT NULL,
    `cover_url`     varchar(255) DEFAULT NULL,
    `teacher_ids`   json         DEFAULT NULL,
    `student_ids`   json         DEFAULT NULL,
    `issue_ids`     json         DEFAULT NULL,
    `status`        varchar(255) DEFAULT NULL,
    `start_time`    datetime     DEFAULT NULL,
    `end_time`      datetime     DEFAULT NULL,
    `open`          bit(1)       DEFAULT NULL,
    `like_count`    bigint       DEFAULT NULL,
    `fav_count`     bigint       DEFAULT NULL,
    `comment_count` bigint       DEFAULT NULL,
    `score`         double       DEFAULT NULL,
    `score_count`   bigint       DEFAULT NULL,
    `create_time`   datetime     DEFAULT NULL,
    `update_time`   datetime     DEFAULT NULL,
    `version`       int          DEFAULT NULL,
    `deleted`       tinyint(1)   DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `idx_course_info_home_id` (`home_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `course_join`
(
    `id`          bigint NOT NULL AUTO_INCREMENT,
    `user_id`     bigint     DEFAULT NULL,
    `course_id`   bigint     DEFAULT NULL,
    `create_time` datetime   DEFAULT NULL,
    `update_time` datetime   DEFAULT NULL,
    `version`     int        DEFAULT NULL,
    `deleted`     tinyint(1) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `idx_course_join_user_id` (`user_id`),
    KEY `idx_course_join_course_id` (`course_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `course_list`
(
    `id`          bigint NOT NULL,
    `home_id`     bigint       DEFAULT NULL,
    `course_ids`  json         DEFAULT NULL,
    `title`       varchar(255) DEFAULT NULL,
    `description` varchar(255) DEFAULT NULL,
    `cover_url`   varchar(255) DEFAULT NULL,
    `open`        bit(1)       DEFAULT NULL,
    `create_time` datetime     DEFAULT NULL,
    `update_time` datetime     DEFAULT NULL,
    `version`     int          DEFAULT NULL,
    `deleted`     tinyint(1)   DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `idx_course_list_home_id` (`home_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `course_share`
(
    `id`          varchar(36) NOT NULL,
    `course_id`   bigint       DEFAULT NULL,
    `inviter_id`  bigint       DEFAULT NULL,
    `invite_as`   varchar(255) DEFAULT NULL,
    `expire_time` datetime     DEFAULT NULL,
    `create_time` datetime     DEFAULT NULL,
    `update_time` datetime     DEFAULT NULL,
    `version`     int          DEFAULT NULL,
    `deleted`     tinyint(1)   DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `idx_course_share_course_id` (`course_id`),
    KEY `idx_course_share_inviter_id` (`inviter_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `course_ware`
(
    `id`                    varchar(32) NOT NULL,
    `course_id`             bigint(20)   DEFAULT NULL,
    `file_name`             varchar(255) DEFAULT NULL,
    `description`           varchar(255) DEFAULT NULL,
    `file_url`              varchar(255) DEFAULT NULL,
    `additional_properties` json         DEFAULT NULL,
    `create_time`           datetime     DEFAULT NULL,
    `update_time`           datetime     DEFAULT NULL,
    `version`               int          DEFAULT NULL,
    `deleted`               tinyint(1)   DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `idx_course_ware_course_id` (`course_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;
