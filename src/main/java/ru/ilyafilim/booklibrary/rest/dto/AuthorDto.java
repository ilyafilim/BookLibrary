package ru.ilyafilim.booklibrary.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ilyafilim.booklibrary.domain.Author;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDto {

    private long id;
    private String name;

    public static AuthorDto toDto(Author author) {
        return new AuthorDto(author.getId(), author.getName());
    }
}
