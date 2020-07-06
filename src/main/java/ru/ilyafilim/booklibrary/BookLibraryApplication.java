package ru.ilyafilim.booklibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.ilyafilim.booklibrary.domain.Author;
import ru.ilyafilim.booklibrary.repositories.AuthorRepository;

import java.sql.SQLException;

@SpringBootApplication
public class BookLibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookLibraryApplication.class, args);
    }

}
