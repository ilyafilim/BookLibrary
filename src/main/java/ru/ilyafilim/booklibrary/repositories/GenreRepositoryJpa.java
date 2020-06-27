package ru.ilyafilim.booklibrary.repositories;

import ru.ilyafilim.booklibrary.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreRepositoryJpa {
    int count();

    Genre save(Genre genre);

    Optional<Genre> findById(long id);

    List<Genre> findAll();

    List<Genre> findByName(String name);

    void updateNameById(long id, String name);

    void deleteById(long id);
}
