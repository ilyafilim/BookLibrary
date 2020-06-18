create table if not exists authors
(
    id   integer primary key autoincrement,
    name text unique not null
);

create table if not exists genres
(
    id   integer primary key autoincrement,
    name text unique not null
);

create table if not exists books
(
    id   integer primary key autoincrement,
    name text unique not null,
    author_id integer not null,
    genre_id integer not null,
    foreign key (author_id) references authors(id),
    foreign key (genre_id) references genres(id)
);