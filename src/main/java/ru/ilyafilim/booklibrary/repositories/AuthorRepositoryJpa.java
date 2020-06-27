package ru.ilyafilim.booklibrary.repositories;

import ru.ilyafilim.booklibrary.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepositoryJpa {

    int count();

    Author save(Author author);

    Optional<Author> findById(long id);

    List<Author> findAll();

    List<Author> findByName(String name);

    void updateNameById(long id, String name);

    void deleteById(long id);
}
