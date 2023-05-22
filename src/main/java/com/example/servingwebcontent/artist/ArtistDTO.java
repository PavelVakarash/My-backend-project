package com.example.servingwebcontent.artist;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ArtistDTO {

    @Schema(description = "Name of the artist")
    private String name;
    @Schema(description = "Genre of the artist")
    private String genre;

}
