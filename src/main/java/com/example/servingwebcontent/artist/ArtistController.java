package com.example.servingwebcontent.artist;

import com.example.servingwebcontent.event.EventDTO;
import com.example.servingwebcontent.event.EventService;
import com.example.servingwebcontent.genre.GenreDTO;
import com.example.servingwebcontent.genre.GenreService;
import com.example.servingwebcontent.place.PlaceDTO;
import com.example.servingwebcontent.place.PlaceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("ARTIST_DTOS")
public class ArtistController {

    private ArtistService service;
    private EventService eventsService;
    private PlaceService placeService;
    private GenreService genreService;

    @Autowired
    public void setGenreService(GenreService genreService) {
        this.genreService = genreService;
    }

    @Autowired
    public void setPlaceService(PlaceService placeService) {
        this.placeService = placeService;
    }

    @Autowired
    public void setEventsService(EventService eventsService) {
        this.eventsService = eventsService;
    }

    @Autowired
    public void setService(ArtistService service) {
        this.service = service;
    }

    @GetMapping(value = "")
    @Operation(summary = "Get all ARTIST_DTOS", description = "A list of all ARTIST_DTOS available in the system. " +
            "Is possible to filter ARTIST_DTOS by genre. " +
            "The response includes the artist name and genre.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully operation"),
            @ApiResponse(responseCode = "400", description = "Invalid genre parameter provided")
    })

    public List<ArtistDTO> listArtists(@RequestParam(name = "name", required = false, defaultValue = "all") String name, Model model)
    {
        return service.getArtists(name);
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Get artist", description = "Details of a specific artist identified by artistId.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully operation"),
            @ApiResponse(responseCode = "404", description = "ArtistDTO not found")
    })
    public ArtistDTO getArtist(@PathVariable int id)
    {
        return service.getArtist(id);
    }

    // Delete
    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete artist", description = "Delete specific artist identified by artistId.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ArtistDTO successfully deleted"),
            @ApiResponse(responseCode = "404", description = "ArtistDTO not found")
    })
    public void deleteArtist(@PathVariable int id)
    {
        // TODO: Add real remove
        service.deleteArtist(id);
    }

    // Update
    @PutMapping(value = "/{id}")
    @Operation(summary = "Update artist", description = "Update the details of a specific artist identified by artistId.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ArtistDTO successfully updated"),
            @ApiResponse(responseCode = "404", description = "ArtistDTO not found")
    })
    public void updateArtist(@PathVariable int id, @RequestBody NewArtistDTO artistDTO)
    {
        // TODO: update eventDTO in database
        service.updateArtist(id, artistDTO);
    }

    @PostMapping(value = "")
    @Operation(summary = "Create new artistDTO", description = "Creates a new artistDTO with the provided details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "New ArtistDTO successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid artistDTO details provided")
    })
    public int createArtist(@RequestBody NewArtistDTO newArtistDTO) {
        // TODO save to database
        return service.createArtist(newArtistDTO);
    }

    @GetMapping(value = "/{artistId}/events")
    public List<EventDTO> getEventsByArtist(@PathVariable int artistId){
        return eventsService.getEventsByArtist(artistId);
    }

    // Endpoint: /artists/{id}/places)
    @GetMapping(value = "/{artistId}/places")
    public List<PlaceDTO> getPlaceByArtistId(@PathVariable int artistId){
        return placeService.getPlaceByArtistId(artistId);
    }

    // endpoint api: GET artist/by-genre/{genre}
    @GetMapping(value = "artist/by-genre/{name}")
    public List<ArtistDTO> getArtistsByGenreName(@PathVariable String name){
        return service.getArtistsByGenreName(name);
    }
}

// http://localhost:8080/artists?genre=Rock

