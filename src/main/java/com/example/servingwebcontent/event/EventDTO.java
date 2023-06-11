package com.example.servingwebcontent.event;

import com.example.servingwebcontent.artist.ArtistDTO;
import com.example.servingwebcontent.genre.GenreDTO;
import com.example.servingwebcontent.place.PlaceDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EventDTO {

    @Schema(description = "Name of the event")
    private String name;
//    @Schema(description = "Location of the event")
//    private String city;
    private PlaceDTO place;
    private ArtistDTO artist;
    private GenreDTO genre;

}
