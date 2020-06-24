package ru.ilyafilim.booklibrary.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.ilyafilim.booklibrary.domain.Author;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Repository
@SuppressWarnings({"ConstantConditions", "SqlDialectInspection"})
public class AuthorDaoJdbc implements AuthorDao {

    private final NamedParameterJdbcOperations jdbc;

    public AuthorDaoJdbc(NamedParameterJdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public int count() {
        return jdbc.getJdbcOperations().queryForObject("select count(*) from authors;", Integer.class);
    }

    @Override
    public void insert(Author author) {
        jdbc.update("insert into authors (name) values (:name);", Collections.singletonMap("name", author.getName()));
    }

    @Override
    public void update(Author author) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", author.getId());
        params.put("name", author.getName());
        jdbc.update("update authors set name = :name where id = :id;", params);
    }

    @Override
    public void deleteById(long id) {
        jdbc.update("delete from authors where id = :id;", Collections.singletonMap("id", id));
    }

    @Override
    public Author getById(long id) {
        return jdbc.queryForObject("select * from authors where id = :id;", Collections.singletonMap("id", id), new AuthorMapper());
    }

    @Override
    public List<Author> getAll() {
        return jdbc.query("select * from authors;", new AuthorMapper());
    }

    private static class AuthorMapper implements RowMapper<Author> {
        @Override
        public Author mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            return new Author(id, name);
        }
    }
}
