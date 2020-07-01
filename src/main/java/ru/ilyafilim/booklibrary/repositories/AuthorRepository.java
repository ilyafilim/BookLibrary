package ru.ilyafilim.booklibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ilyafilim.booklibrary.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
