package ru.ilyafilim.booklibrary.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.ilyafilim.booklibrary.domain.Genre;

@Repository
public interface GenreRepository extends MongoRepository<Genre, String> {

}
