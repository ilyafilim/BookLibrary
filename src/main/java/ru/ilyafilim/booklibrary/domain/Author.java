package ru.ilyafilim.booklibrary.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "authors")
public class Author {

    @MongoId
    private String id;
    @Field
    @NonNull
    private String name;
}
