USE homeedu;

CREATE TABLE IF NOT EXISTS `ai_conversation` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `user_id` BIGINT NOT NULL,
    `role_type` TINYINT NOT NULL DEFAULT 1,
    `session_id` VARCHAR(64) NOT NULL,
    `module_type` VARCHAR(32) NOT NULL DEFAULT 'chat',
    `title` VARCHAR(256) DEFAULT NULL,
    `last_message` TEXT DEFAULT NULL,
    `created_time` DATETIME DEFAULT CURRENT_TIMESTAMP,
    `updated_time` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `deleted` TINYINT(1) DEFAULT 0,
    PRIMARY KEY (`id`),
    KEY `idx_ai_conv_user` (`user_id`),
    KEY `idx_ai_conv_session` (`session_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `ai_message` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `conversation_id` BIGINT NOT NULL,
    `sender` TINYINT NOT NULL DEFAULT 1,
    `content` TEXT NOT NULL,
    `model_used` VARCHAR(64) DEFAULT NULL,
    `token_count` INT DEFAULT NULL,
    `response_time_ms` BIGINT DEFAULT NULL,
    `created_time` DATETIME DEFAULT CURRENT_TIMESTAMP,
    `deleted` TINYINT(1) DEFAULT 0,
    PRIMARY KEY (`id`),
    KEY `idx_ai_msg_conv` (`conversation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `ai_learning_report` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `user_id` BIGINT NOT NULL,
    `report_type` VARCHAR(32) NOT NULL DEFAULT 'weekly',
    `knowledge_weakness` TEXT DEFAULT NULL,
    `learning_trend` TEXT DEFAULT NULL,
    `recommendations` TEXT DEFAULT NULL,
    `generated_time` DATETIME DEFAULT CURRENT_TIMESTAMP,
    `deleted` TINYINT(1) DEFAULT 0,
    PRIMARY KEY (`id`),
    KEY `idx_ai_report_user` (`user_id`),
    KEY `idx_ai_report_time` (`generated_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `ai_recommendation` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `user_id` BIGINT NOT NULL,
    `target_type` VARCHAR(32) NOT NULL,
    `target_id` BIGINT DEFAULT NULL,
    `reason` TEXT DEFAULT NULL,
    `status` TINYINT DEFAULT 0,
    `created_time` DATETIME DEFAULT CURRENT_TIMESTAMP,
    `deleted` TINYINT(1) DEFAULT 0,
    PRIMARY KEY (`id`),
    KEY `idx_ai_rec_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
