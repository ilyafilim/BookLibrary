package ru.ilyafilim.booklibrary.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.ilyafilim.booklibrary.domain.Author;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
@Import(AuthorRepositoryJpaImpl.class)
class AuthorRepositoryJpaImplTest {

    private final long FIRST_AUTHOR_ID = 1L;
    @Autowired
    AuthorRepositoryJpa authorJpa;
    private final static int COUNT_OF_AUTHORS = 2;
    private final static String NAME_OF_FIRST_AUTHOR = "Rick Dalton";
    private final static String NEW_NAME_OF_FIRST_AUTHOR = "Dalt Rickson";

    @Test
    void count() {
        assertEquals(authorJpa.count(), COUNT_OF_AUTHORS);
    }

    @Test
    void save() {
        Author author = new Author(0, "Nick Brown");
        authorJpa.save(author);
        Author authorFromJpa = authorJpa.findById(3L).orElse(null);
        assertEquals(author, authorFromJpa);
    }

    @Test
    void findById() {
        Author author = new Author(FIRST_AUTHOR_ID, NAME_OF_FIRST_AUTHOR);
        Author authorFromJpa = authorJpa.findById(FIRST_AUTHOR_ID).orElse(null);
        assertEquals(author, authorFromJpa);
    }

    @Test
    void findAll() {
        assertEquals(authorJpa.findAll().size(), COUNT_OF_AUTHORS);
    }

    @Test
    void findByName() {
        Author author = authorJpa.findByName(NAME_OF_FIRST_AUTHOR).get(0);
        assertEquals(author.getName(), NAME_OF_FIRST_AUTHOR);
    }

    @Test
    void updateNameById() {
        Author author = authorJpa.findById(FIRST_AUTHOR_ID).orElse(null);
        author.setName(NEW_NAME_OF_FIRST_AUTHOR);
        authorJpa.save(author);
        Author expected = authorJpa.findById(FIRST_AUTHOR_ID).orElse(null);
        assertEquals(expected.getName(), NEW_NAME_OF_FIRST_AUTHOR);
    }

    @Test
    void deleteById() {
        authorJpa.deleteById(FIRST_AUTHOR_ID);
        Author author = authorJpa.findById(FIRST_AUTHOR_ID).orElse(null);
        assertNull(author);
    }
}