package com.example.servingwebcontent.genre;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class NewGenreDTO {

    @Schema(description = "Name of the genre")
    private String name;
}
