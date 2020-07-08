package ru.ilyafilim.booklibrary.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.ilyafilim.booklibrary.domain.Book;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {

    @Query("select b from Book b left join Author a on b.author = a where a.name like concat('%',:name,'%') ")
    List<Book> findLikeAuthorPartName(@Param("name") String name);
}
