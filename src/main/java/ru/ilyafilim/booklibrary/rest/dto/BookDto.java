package ru.ilyafilim.booklibrary.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ilyafilim.booklibrary.domain.Book;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private long id;
    private String name;
    private AuthorDto author;
    private GenreDto genre;

    public static BookDto toDto(Book book) {
        return new BookDto(book.getId()
                , book.getName()
                , AuthorDto.toDto(book.getAuthor())
                , GenreDto.toDto(book.getGenre()));
    }
}
