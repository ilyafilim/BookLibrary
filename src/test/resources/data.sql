insert or ignore into authors (name) values ('Cliff Booth');
insert or ignore into genres (name) values ('Drama');
insert or ignore into books (name, author_id, genre_id) VALUES ('The Excellent Book', 1, 1);