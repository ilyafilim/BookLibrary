package ru.ilyafilim.booklibrary.dao;

import ru.ilyafilim.booklibrary.domain.Genre;

import java.util.List;

public interface GenreDao {

    int count();

    void insert(Genre genre);

    void update(Genre genre);

    void deleteById(long id);

    Genre getById(long id);

    List<Genre> getAll();
}
