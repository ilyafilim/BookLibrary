package ru.ilyafilim.booklibrary.repositories;

import ru.ilyafilim.booklibrary.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepositoryJpa {

    int count();

    Book save(Book book);
    Optional<Book> findById(long id);

    List<Book> findAll();
    List<Book> findByName(String name);

    void updateNameById(long id, String name);
    void deleteById(long id);

}
