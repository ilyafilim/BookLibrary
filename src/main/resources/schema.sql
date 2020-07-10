drop table if exists authors;
drop table if exists genres;
drop table if exists books;

create table authors (
    id bigserial,
    name varchar(256),
    primary key (id)
);

create table genres (
    id bigserial,
    name varchar(256),
    primary key (id)
);

create table books (
    id bigserial,
    name varchar(256),
    author_id bigint references authors (id) on delete cascade,
    genre_id bigint references genres (id) on delete cascade,
    primary key (id)
);