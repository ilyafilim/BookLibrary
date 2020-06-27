package ru.ilyafilim.booklibrary.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.ilyafilim.booklibrary.domain.Author;
import ru.ilyafilim.booklibrary.domain.Book;
import ru.ilyafilim.booklibrary.domain.Genre;
import ru.ilyafilim.booklibrary.repositories.AuthorRepositoryJpa;
import ru.ilyafilim.booklibrary.repositories.BookRepositoryJpa;
import ru.ilyafilim.booklibrary.repositories.GenreRepositoryJpa;

@ShellComponent
public class ShellCommands {

    private final AuthorRepositoryJpa authorJpa;

    private final BookRepositoryJpa bookJpa;

    private final GenreRepositoryJpa genreJpa;

    public ShellCommands(AuthorRepositoryJpa authorJpa, BookRepositoryJpa bookJpa, GenreRepositoryJpa genreJpa) {
        this.authorJpa = authorJpa;
        this.bookJpa = bookJpa;
        this.genreJpa = genreJpa;
    }

    @ShellMethod(key = "author.insert", value = "Добавить автора")
    public String insertAuthor(@ShellOption({"name"}) String name) {
        authorJpa.save(new Author(0, name));
        return "ok!";
    }

    @ShellMethod(key = "author.get", value = "Получить автора по айди")
    public String getAuthor(@ShellOption({"id"}) long id) {
        return authorJpa.findById(id).toString();
    }

    @ShellMethod(key = "author.list", value = "Получить всех авторов списком")
    public String getAuthors() {
        return authorJpa.findAll().toString();
    }

    //

    @ShellMethod(key = "genre.insert", value = "Добавить жанр")
    public String insertGenre(@ShellOption({"name"}) String name) {
        genreJpa.save(new Genre(0, name));
        return "ok!";
    }

    @ShellMethod(key = "genre.get", value = "Получить жанр по айди")
    public String getGenre(@ShellOption({"id"}) long id) {
        return genreJpa.findById(id).toString();
    }

    @ShellMethod(key = "genre.list", value = "Получить все жанры списком")
    public String getGenres() {
        return genreJpa.findAll().toString();
    }

    //

    @ShellMethod(key = "book.count", value = "Узнать кол-во книг")
    public String getBookCount() {
        return bookJpa.count() + "";
    }

    @ShellMethod(key = "book.insert", value = "Добавить книгу")
    public String insertBook(@ShellOption({"name"}) String name, @ShellOption({"authorId"}) long authorId, @ShellOption({"genreId"}) long genreId) {
        bookJpa.save(new Book(0, name, new Author(authorId, null), new Genre(genreId, null)));
        return "ok!";
    }

    @ShellMethod(key = "book.update", value = "Обновить название книги по айди")
    public String updateBook(@ShellOption({"id"}) long id, @ShellOption({"name"}) String name) {
        bookJpa.save(new Book(id, name, null, null));
        return "ok!";
    }

    @ShellMethod(key = "book.delete", value = "Удалить книгу по айди")
    public String deleteBook(@ShellOption({"id"}) long id) {
        bookJpa.deleteById(id);
        return "ok!";
    }

    @ShellMethod(key = "book.get", value = "Получить книгу по айди")
    public String getBook(@ShellOption({"id"}) long id) {
        return bookJpa.findById(id).toString();
    }

    @ShellMethod(key = "book.list", value = "Получить все книги списком")
    public String getBooks() {
        return bookJpa.findAll().toString();
    }
}
