package com.example.servingwebcontent.genre;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class GenreDTO {

    private int id;
    private String name;
}
