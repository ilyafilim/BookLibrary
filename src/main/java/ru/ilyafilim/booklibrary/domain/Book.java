package ru.ilyafilim.booklibrary.domain;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "books")
public class Book {

    @MongoId
    private String id;
    @Field
    @NonNull
    private String name;
    @NonNull
    @DBRef(db = "authors")
    @Field
    private Author author;
    @NonNull
    @DBRef(db = "genres")
    @Field
    private Genre genre;
}
