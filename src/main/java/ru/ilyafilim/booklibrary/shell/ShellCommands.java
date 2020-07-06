package ru.ilyafilim.booklibrary.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.ilyafilim.booklibrary.domain.Author;
import ru.ilyafilim.booklibrary.domain.Book;
import ru.ilyafilim.booklibrary.domain.Genre;
import ru.ilyafilim.booklibrary.repositories.AuthorRepository;
import ru.ilyafilim.booklibrary.repositories.BookRepository;
import ru.ilyafilim.booklibrary.repositories.GenreRepository;

@ShellComponent
public class ShellCommands {

    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;

    private final GenreRepository genreRepository;

    public ShellCommands(AuthorRepository authorRepository, BookRepository bookRepository, GenreRepository genreRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
    }

    @ShellMethod(key = "author.insert", value = "Добавить автора")
    public String insertAuthor(@ShellOption({"name"}) String name) {
        authorRepository.save(new Author(0, name));
        return "ok!";
    }

    @ShellMethod(key = "author.get", value = "Получить автора по айди")
    public String getAuthor(@ShellOption({"id"}) long id) {
        return authorRepository.findById(id).toString();
    }

    @ShellMethod(key = "author.list", value = "Получить всех авторов списком")
    public String getAuthors() {
        return authorRepository.findAll().toString();
    }

    //

    @ShellMethod(key = "genre.insert", value = "Добавить жанр")
    public String insertGenre(@ShellOption({"name"}) String name) {
        genreRepository.save(new Genre(0, name));
        return "ok!";
    }

    @ShellMethod(key = "genre.get", value = "Получить жанр по айди")
    public String getGenre(@ShellOption({"id"}) long id) {
        return genreRepository.findById(id).toString();
    }

    @ShellMethod(key = "genre.list", value = "Получить все жанры списком")
    public String getGenres() {
        return genreRepository.findAll().toString();
    }

    //

    @ShellMethod(key = "book.count", value = "Узнать кол-во книг")
    public String getBookCount() {
        return bookRepository.count() + "";
    }

    @ShellMethod(key = "book.insert", value = "Добавить книгу")
    public String insertBook(@ShellOption({"name"}) String name, @ShellOption({"authorId"}) long authorId, @ShellOption({"genreId"}) long genreId) {
        bookRepository.save(new Book(0, name, new Author(authorId, null), new Genre(genreId, null)));
        return "ok!";
    }

    @ShellMethod(key = "book.update", value = "Обновить название книги по айди")
    public String updateBook(@ShellOption({"id"}) long id, @ShellOption({"name"}) String name) {
        bookRepository.save(new Book(id, name, null, null));
        return "ok!";
    }

    @ShellMethod(key = "book.delete", value = "Удалить книгу по айди")
    public String deleteBook(@ShellOption({"id"}) long id) {
        bookRepository.deleteById(id);
        return "ok!";
    }

    @ShellMethod(key = "book.get", value = "Получить книгу по айди")
    public String getBook(@ShellOption({"id"}) long id) {
        return bookRepository.findById(id).toString();
    }

    @ShellMethod(key = "book.list", value = "Получить все книги списком")
    public String getBooks() {
        return bookRepository.findAll().toString();
    }
}
