package ru.ilyafilim.booklibrary.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ilyafilim.booklibrary.repositories.BookRepository;
import ru.ilyafilim.booklibrary.rest.dto.BookDto;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    BookRepository repository;

    @GetMapping("/books")
    public List<BookDto> getAllPersons() {
        return repository.findAll().stream().map(BookDto::toDto)
                .collect(Collectors.toList());
    }
}
