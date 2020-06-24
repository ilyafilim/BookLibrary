package ru.ilyafilim.booklibrary.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.ilyafilim.booklibrary.dao.AuthorDaoJdbc;
import ru.ilyafilim.booklibrary.dao.BookDaoJdbc;
import ru.ilyafilim.booklibrary.dao.GenreDaoJdbc;
import ru.ilyafilim.booklibrary.domain.Author;
import ru.ilyafilim.booklibrary.domain.Book;
import ru.ilyafilim.booklibrary.domain.Genre;

@ShellComponent
public class ShellCommands {

    private final AuthorDaoJdbc authorDao;

    private final BookDaoJdbc bookDao;

    private final GenreDaoJdbc genreDao;

    public ShellCommands(AuthorDaoJdbc authorDao, BookDaoJdbc bookDao, GenreDaoJdbc genreDao) {
        this.authorDao = authorDao;
        this.bookDao = bookDao;
        this.genreDao = genreDao;
    }

    @ShellMethod(key = "author.insert", value = "Добавить автора")
    public String insertAuthor(@ShellOption({"name"}) String name) {
        authorDao.insert(new Author(0, name));
        return "ok!";
    }

    @ShellMethod(key = "author.get", value = "Получить автора по айди")
    public String getAuthor(@ShellOption({"id"}) long id) {
        return authorDao.getById(id).toString();
    }

    @ShellMethod(key = "author.list", value = "Получить всех авторов списком")
    public String getAuthors() {
        return authorDao.getAll().toString();
    }

    //

    @ShellMethod(key = "genre.insert", value = "Добавить жанр")
    public String insertGenre(@ShellOption({"name"}) String name) {
        genreDao.insert(new Genre(0, name));
        return "ok!";
    }

    @ShellMethod(key = "genre.get", value = "Получить жанр по айди")
    public String getGenre(@ShellOption({"id"}) long id) {
        return genreDao.getById(id).toString();
    }

    @ShellMethod(key = "genre.list", value = "Получить все жанры списком")
    public String getGenres() {
        return genreDao.getAll().toString();
    }

    //

    @ShellMethod(key = "book.count", value = "Узнать кол-во книг")
    public String getBookCount() {
        return bookDao.count() + "";
    }

    @ShellMethod(key = "book.insert", value = "Добавить книгу")
    public String insertBook(@ShellOption({"name"}) String name, @ShellOption({"authorId"}) long authorId, @ShellOption({"genreId"}) long genreId) {
        bookDao.insert(new Book(0, name, new Author(authorId, null), new Genre(genreId, null)));
        return "ok!";
    }

    @ShellMethod(key = "book.update", value = "Обновить название книги по айди")
    public String updateBook(@ShellOption({"id"}) long id, @ShellOption({"name"}) String name) {
        bookDao.update(new Book(id, name, null, null));
        return "ok!";
    }

    @ShellMethod(key = "book.delete", value = "Удалить книгу по айди")
    public String deleteBook(@ShellOption({"id"}) long id) {
        bookDao.deleteById(id);
        return "ok!";
    }

    @ShellMethod(key = "book.get", value = "Получить книгу по айди")
    public String getBook(@ShellOption({"id"}) long id) {
        return bookDao.getById(id).toString();
    }

    @ShellMethod(key = "book.list", value = "Получить все книги списком")
    public String getBooks() {
        return bookDao.getAll().toString();
    }
}
