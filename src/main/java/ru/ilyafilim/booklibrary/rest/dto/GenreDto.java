package ru.ilyafilim.booklibrary.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ilyafilim.booklibrary.domain.Genre;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenreDto {

    private long id;
    private String name;

    public static GenreDto toDto(Genre genre) {
        return new GenreDto(genre.getId(), genre.getName());
    }
}
