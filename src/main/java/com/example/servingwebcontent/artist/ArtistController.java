package com.example.servingwebcontent.artist;

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

    public List<ArtistDTO> listArtists(@RequestParam(name = "genre", required = false, defaultValue = "all") String genre, Model model)
    {
        return service.getArtists(genre);
    }

    @GetMapping(value = "/{artistId}")
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
    @DeleteMapping(value = "/{artistId}")
    @Operation(summary = "Delete artist", description = "Delete specific artist identified by artistId.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ArtistDTO successfully deleted"),
            @ApiResponse(responseCode = "404", description = "ArtistDTO not found")
    })
    public ArtistDTO deleteArtist(@PathVariable int id)
    {
        // TODO: Add real remove
        return service.deleteArtist(id);
    }

    // Update
    @PutMapping(value = "/{artistId}")
    @Operation(summary = "Update artist", description = "Update the details of a specific artist identified by artistId.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ArtistDTO successfully updated"),
            @ApiResponse(responseCode = "404", description = "ArtistDTO not found")
    })
    public ArtistDTO updateArtist(@PathVariable int id, @RequestBody ArtistDTO artistDTO)
    {
        // TODO: update eventDTO in database
        return service.updateArtist(id, artistDTO);
    }

    @PostMapping(value = "")
    @Operation(summary = "Create new artistDTO", description = "Creates a new artistDTO with the provided details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "New ArtistDTO successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid artistDTO details provided")
    })
    public ArtistDTO createArtist(@RequestBody ArtistDTO artistDTO) {
        // TODO save to database
        return service.createArtist(artistDTO);
    }
}

// http://localhost:8080/artists?genre=Rock

