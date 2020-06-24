package ru.ilyafilim.booklibrary.dao;

import ru.ilyafilim.booklibrary.domain.Book;

import java.util.List;

public interface BookDao {

    int count();

    void insert(Book book);

    void update(Book book);

    void deleteById(long id);

    Book getById(long id);

    List<Book> getAll();
}
