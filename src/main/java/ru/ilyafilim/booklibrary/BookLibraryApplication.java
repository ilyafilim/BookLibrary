package ru.ilyafilim.booklibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.SQLException;

@SpringBootApplication
public class BookLibraryApplication {

    public static void main(String[] args) throws SQLException {
        ApplicationContext context = SpringApplication.run(BookLibraryApplication.class, args);

        /*AuthorDao authorDao = context.getBean(AuthorDao.class);

        Author author = authorDao.getById(2L);

        System.out.println(author.getName());*/
    }

}
