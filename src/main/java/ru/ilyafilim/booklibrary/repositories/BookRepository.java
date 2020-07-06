package ru.ilyafilim.booklibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.ilyafilim.booklibrary.domain.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select b from Book b left join Author a on b.author = a where a.name like concat('%',:name,'%') ")
    List<Book> findLikeAuthorPartName(@Param("name") String name);
}
