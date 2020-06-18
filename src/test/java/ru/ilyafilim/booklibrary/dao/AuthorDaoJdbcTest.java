package ru.ilyafilim.booklibrary.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.ilyafilim.booklibrary.domain.Author;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@JdbcTest
@Import(AuthorDaoJdbc.class)
class AuthorDaoJdbcTest {

    private static final int REAL_COUNT = 1;
    private static final int REAL_COUNT_AFTER_INSERT = REAL_COUNT + 1;
    private static final int NO_AUTHORS = 0;

    @Autowired
    AuthorDaoJdbc dao;

    @Test
    void count() {
        assertEquals(dao.count(), REAL_COUNT);
    }

    @Test
    void insert() {
        Author author = new Author(0, "Nick Wood");
        dao.insert(author);
        assertEquals(dao.count(), REAL_COUNT_AFTER_INSERT);
    }

    @Test
    void deleteById() {
        dao.getById(1L);
        assertEquals(dao.count(), NO_AUTHORS);
    }

    @Test
    void getById() {
        Author expected = new Author(1, "Cliff Booth");
        Author fromDb = dao.getById(1L);
        assertEquals(expected.getId(), fromDb.getId());
        assertEquals(expected.getName(), fromDb.getName());
    }

    @Test
    void getAll() {
        List<Author> authorList = dao.getAll();
        assertTrue(authorList.size() > 0);
    }
}