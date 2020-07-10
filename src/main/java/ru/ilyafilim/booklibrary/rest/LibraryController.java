package ru.ilyafilim.booklibrary.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.ilyafilim.booklibrary.domain.Author;
import ru.ilyafilim.booklibrary.domain.Book;
import ru.ilyafilim.booklibrary.domain.Genre;
import ru.ilyafilim.booklibrary.repositories.AuthorRepository;
import ru.ilyafilim.booklibrary.repositories.BookRepository;
import ru.ilyafilim.booklibrary.repositories.GenreRepository;

import java.util.List;

@Controller
public class LibraryController {

    final BookRepository bookRepository;

    final AuthorRepository authorRepository;

    final GenreRepository genreRepository;

    public LibraryController(BookRepository bookRepository, AuthorRepository authorRepository, GenreRepository genreRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
    }

    @GetMapping("/edit")
    public String editBook(@RequestParam("id") long id, Model model) {
        Book book = bookRepository.findById(id).orElseThrow(NotFoundException::new);
        List<Author> authors = authorRepository.findAll();
        List<Genre> genres = genreRepository.findAll();
        model.addAttribute("book", book);
        model.addAttribute("authors", authors);
        model.addAttribute("genres", genres);
        return "edit";
    }

    @PostMapping("/edit")
    public String saveBook(
            @RequestParam("id") long id,
            @RequestParam("name") String name,
            @RequestParam("author") long authorId,
            @RequestParam("genre") long genreId) {
        Author author = authorRepository.findById(authorId).orElseThrow(NullPointerException::new);
        Genre genre = genreRepository.findById(genreId).orElseThrow(NullPointerException::new);
        bookRepository.save(new Book(id, name, author, genre));
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteBook(
            @RequestParam(required=false, name = "id") long id,
            @RequestParam(required=false, name = "return") String buttonBack,
            @RequestParam(required=false, name = "submit") String buttonSubmit,
            Model model) {
        if (buttonBack == null && buttonSubmit == null) {
            Book book = bookRepository.findById(id).orElseThrow(NotFoundException::new);
            model.addAttribute(book);
            return "delete";
        }
        if (buttonSubmit != null) {
            bookRepository.deleteBookById(id);
        }
        return "redirect:/index.html";
    }

    @GetMapping("/add")
    public String addBook(Model model) {
        List<Author> authors = authorRepository.findAll();
        List<Genre> genres = genreRepository.findAll();
        model.addAttribute("authors", authors);
        model.addAttribute("genres", genres);
        return "add";
    }

    @PostMapping("/add")
    public String saveBook(
            @RequestParam("name") String name,
            @RequestParam("author") long authorId,
            @RequestParam("genre") long genreId) {
        Author author = authorRepository.findById(authorId).orElseThrow(NullPointerException::new);
        Genre genre = genreRepository.findById(genreId).orElseThrow(NullPointerException::new);
        bookRepository.save(new Book(0, name, author, genre));
        return "redirect:/index.html";
    }
}
