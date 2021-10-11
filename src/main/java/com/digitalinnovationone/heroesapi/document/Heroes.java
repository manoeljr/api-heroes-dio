package com.digitalinnovationone.heroesapi.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Heroes {
    @Id
    private String id;
    private String name;
    private String universe;
    private int films;
}
