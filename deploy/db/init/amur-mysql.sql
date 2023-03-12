CREATE DATABASE `homeedu`;
use `homeedu`;
CREATE TABLE `user_info`
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

CREATE TABLE `user_auth`
(
    `id`          bigint NOT NULL,
    `name`        varchar(64)  DEFAULT NULL,
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

CREATE TABLE `user_fav`
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

CREATE TABLE `home_info`
(
    `id`             bigint NOT NULL,
    `name`           varchar(255) DEFAULT NULL,
    `description`    varchar(255) DEFAULT NULL,
    `avatar_url`     varchar(255) DEFAULT NULL,
    `image_urls`     json         DEFAULT NULL,
    `admin_ids`      json         DEFAULT NULL,
    `create_user_id` bigint       DEFAULT NULL,
    `member_ids`     json         DEFAULT NULL,
    `like_count`     bigint(20)   DEFAULT NULL,
    `fav_count`      bigint(20)   DEFAULT NULL,
    `open`           tinyint      DEFAULT NULL,
    `create_time`    datetime     DEFAULT NULL,
    `update_time`    datetime     DEFAULT NULL,
    `version`        int          DEFAULT NULL,
    `deleted`        tinyint(1)   DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `idx_create_time` (`create_time`),
    KEY `idx_update_time` (`update_time`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `course_comment`
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
CREATE TABLE `course_info`
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

CREATE TABLE `course_join`
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

CREATE TABLE `course_list`
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

CREATE TABLE `course_share`
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

CREATE TABLE `course_ware`
(
    `id`                    varchar(128) NOT NULL,
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
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `schedule`
(
    `id`             bigint NOT NULL,
    `user_id`        bigint       DEFAULT NULL,
    `create_user_id` bigint       DEFAULT NULL,
    `title`          varchar(255) DEFAULT NULL,
    `content`        varchar(255) DEFAULT NULL,
    `location`       varchar(255) DEFAULT NULL,
    `remark`         varchar(255) DEFAULT NULL,
    `color`          varchar(255) DEFAULT NULL,
    `all_day`        bit(1)       DEFAULT NULL,
    `can_edit`       bit(1)       DEFAULT NULL,
    `start_time`     datetime     DEFAULT NULL,
    `end_time`       datetime     DEFAULT NULL,
    `create_time`    datetime     DEFAULT NULL,
    `update_time`    datetime     DEFAULT NULL,
    `version`        int          DEFAULT NULL,
    `deleted`        tinyint(1)   DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `idx_user_id` (`user_id`),
    KEY `idx_create_user_id` (`create_user_id`),
    KEY `idx_start_time` (`start_time`),
    KEY `idx_end_time` (`end_time`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `msg_chat_user`
(
    `id`         varchar(36) NOT NULL,
    `nickName`   varchar(255) DEFAULT NULL,
    `userId`     bigint(20)   DEFAULT NULL,
    `chatId`     varchar(255) DEFAULT NULL,
    `notify`     tinyint(1)   DEFAULT NULL,
    `top`        tinyint(1)   DEFAULT NULL,
    `createTime` datetime     DEFAULT NULL,
    `updateTime` datetime     DEFAULT NULL,
    `version`    int          DEFAULT NULL,
    `deleted`    tinyint(1)   DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `idx_user_id` (`userId`),
    KEY `idx_chat_id` (`chatId`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `msg_chat`
(
    `id`            varchar(36) NOT NULL,
    `name`          varchar(255) DEFAULT NULL,
    `creatorId`     bigint(20)   DEFAULT NULL,
    `lastMessageId` varchar(36)  DEFAULT NULL,
    `createTime`    datetime     DEFAULT NULL,
    `updateTime`    datetime     DEFAULT NULL,
    `version`       int(11)      DEFAULT NULL,
    `deleted`       int(1)       DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `idx_creator_id` (`creatorId`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `msg_msg`
(
    `id`          varchar(32) NOT NULL,
    `message`     varchar(255)         DEFAULT NULL,
    `chat_id`     varchar(32)          DEFAULT NULL,
    `sender_id`   bigint(20)           DEFAULT NULL,
    `call_back`   tinyint(1)           DEFAULT NULL,
    `create_time` datetime             DEFAULT NULL,
    `update_time` datetime             DEFAULT NULL,
    `version`     int(11)     NOT NULL DEFAULT '1',
    `deleted`     tinyint(1)  NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`),
    KEY `idx_chat_id` (`chat_id`) USING BTREE,
    CONSTRAINT `fk_message_chat_id` FOREIGN KEY (`chat_id`) REFERENCES `msg_chat` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

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
  DEFAULT CHARSET = utf8mb4_0900_ai_ci;


