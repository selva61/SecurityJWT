create sequence user_id_seq start with 1 increment by 50;

create table users (
    id bigint primary key default nextval('user_id_seq'),
    username varchar(255) not null,
    password varchar(255) not null,
    created_at timestamp not null default current_timestamp,
    updated_at timestamp
);