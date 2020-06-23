package ru.ilyafilim.booklibrary.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.ilyafilim.booklibrary.domain.Author;
import ru.ilyafilim.booklibrary.domain.Book;
import ru.ilyafilim.booklibrary.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Repository
@SuppressWarnings({"ConstantConditions"})
public class BookDaoJdbc implements BookDao {

    private final NamedParameterJdbcOperations jdbc;

    public BookDaoJdbc(NamedParameterJdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public int count() {
        return jdbc.getJdbcOperations().queryForObject("select count(*) from books;", Integer.class);
    }

    @Override
    public void insert(Book book) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("name", book.getName());
        params.put("author", book.getAuthor().getId());
        params.put("genre", book.getGenre().getId());
        jdbc.update("insert into books (name, author_id, genre_id) values (:name, :author, :genre);", params);
    }

    @Override
    public void update(Book book) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", book.getId());
        params.put("name", book.getName());
        jdbc.update("update books set name = :name where id = :id;", params);
    }

    @Override
    public void deleteById(long id) {
        jdbc.update("delete from books where id = :id;", Collections.singletonMap("id", id));
    }

    @Override
    public Book getById(long id) {
        return jdbc.queryForObject("select b.id as book_id, b.name as book_name, a.id as author_id, a.name as author_name, g.id as genre_id, g.name as genre_name " +
                "from books b " +
                "left join authors a on b.author_id = a.id " +
                "left join genres g on b.genre_id = g.id " +
                "where b.id = :id;", Collections.singletonMap("id", id), new BookMapper());
    }

    @Override
    public List<Book> getAll() {
        return jdbc.query("select b.id as book_id, b.name as book_name, a.id as author_id, a.name as author_name, g.id as genre_id, g.name as genre_name from books b left join authors a on b.author_id = a.id left join genres g on b.genre_id = g.id;", new BookMapper());
    }

    private static class BookMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("book_id");
            String name = resultSet.getString("book_name");
            Author author = new Author(resultSet.getLong("author_id"), resultSet.getString("author_name"));
            Genre genre = new Genre(resultSet.getLong("genre_id"), resultSet.getString("genre_name"));
            return new Book(id, name, author, genre);
        }
    }
}
