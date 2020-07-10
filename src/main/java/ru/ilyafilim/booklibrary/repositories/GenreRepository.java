package ru.ilyafilim.booklibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ilyafilim.booklibrary.domain.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
