package ru.ilyafilim.booklibrary.repositories;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.ilyafilim.booklibrary.domain.Book;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
class BookTest {

    private final static String BOOK_NAME = "Super Drama Book";
    private final static String AUTHOR_NAME = "Cliff Booth";
    private final static String GENRE_NAME = "Drama";
    @Autowired
    private BookRepository repository;

    @Test
    void testFindBook() {
        Book book = repository.getOne(2L);
        assertEquals(book.getName(), BOOK_NAME);
    }

    @Test
    public void testCount(){
        System.out.println(repository.findAll());
        Assert.assertTrue(repository.count() > 0);
    }

    @Test
    public void testDeleteAll(){
        repository.deleteAll();
        Assert.assertEquals(0, repository.count());
    }

    @Test
    public void testGetBooksByPartOfName() {
        List<Book> bookList = repository.findLikeAuthorPartName("Cliff");
        assertEquals(bookList.size(), 1);
    }
}