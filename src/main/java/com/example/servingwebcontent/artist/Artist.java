package com.example.servingwebcontent.artist;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
class Artist {

    @Schema(description = "Name of the artist")
    private String name;
    @Schema(description = "Genre of the artist")
    private String genre;

}
