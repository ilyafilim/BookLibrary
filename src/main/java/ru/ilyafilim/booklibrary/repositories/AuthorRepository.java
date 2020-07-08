package ru.ilyafilim.booklibrary.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.ilyafilim.booklibrary.domain.Author;

@Repository
public interface AuthorRepository extends MongoRepository<Author, String> {

}
