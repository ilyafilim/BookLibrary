package ru.ilyafilim.booklibrary.dao;

import ru.ilyafilim.booklibrary.domain.Author;

import java.util.List;

public interface AuthorDao {

    int count();

    void insert(Author author);

    void update(Author author);

    void deleteById(long id);

    Author getById(long id);

    List<Author> getAll();
}
