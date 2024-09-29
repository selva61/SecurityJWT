create sequence bookmark_id_seq start with 1 increment by 50;
create table bookmarks (
                           id bigint primary key default nextval('bookmark_id_seq'),
                           title varchar(255) not null,
                           url varchar(255) not null,
                           created_at timestamp not null default current_timestamp,
                           updated_at timestamp
);

insert into bookmarks (id,title, url) values (1,'Google', 'https://www.google.com'),
                                                      (2,'Yahoo', 'https://www.yahoo.com'),
                                                      (3,'Bing', 'https://www.bing.com');