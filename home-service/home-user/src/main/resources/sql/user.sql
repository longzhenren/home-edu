use homeedu;
create table user
(
    id            int          not null,
    name          varchar(64)  null,
    email         varchar(128) null,
    phone         varchar(32)  null,
    avatar_url    varchar(256) null,
    home_id       int          null,
    relative_type int          null,
    create_time   datetime     null,
    version       int          null,
    description   varchar(512) null
);

create index user_id_index
    on user (id);

alter table user
    add constraint user_pk
        primary key (id);

