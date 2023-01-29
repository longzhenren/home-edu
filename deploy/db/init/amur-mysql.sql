# create databases
CREATE DATABASE IF NOT EXISTS `homeedu`;
create table if not exists homeedu
(
    id            bigint       not null
        primary key,
    name          varchar(64)  null,
    email         varchar(128) null,
    phone         varchar(32)  null,
    avatar_url    varchar(256) null,
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
    permissions   varchar(256) null
);

create index user_id_index
    on homeedu.user (id);

