package com.example.servingwebcontent.artist;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("artists")
public class ArtistController {

    static final ArrayList<Artist> artists = new ArrayList<Artist>() {{
        add(new Artist("Nazareth", "Rock"));
        add(new Artist("Led Zeppelin", "Rock"));
        add(new Artist("Louis Armstrong", "Jazz"));
        add(new Artist("Frank Sinatra", "Jazz"));
        add(new Artist("System of a Down", "Metal"));
        add(new Artist("Metallica", "Metal"));
        add(new Artist("DiDuLya", "Instrumental"));
        add(new Artist("Pink Floyd", "Instrumental"));
        add(new Artist("RadioHead", "Electronic"));
        add(new Artist("Depeche Mode", "Electronic"));
        add(new Artist("Enigma", "New Age"));
        add(new Artist("Enya", "New Age"));
    }};

    @GetMapping(value = "")
    @Operation(summary = "Get all artists", description = "A list of all artists available in the system. " +
            "Is possible to filter artists by genre. " +
            "The response includes the artist name and genre.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully operation"),
            @ApiResponse(responseCode = "400", description = "Invalid genre parameter provided")
    })

    public List<Artist> listArtists(@RequestParam(name = "genre", required = false, defaultValue = "all") String genre, Model model) {
        List<Artist> result = artists;

        if (!genre.equals("all")) {
            result = artists.stream().filter(a -> a.getGenre().equalsIgnoreCase(genre)).collect(Collectors.toList());
        }

        return result;
    }

    @GetMapping(value = "/{artistId}")
    @Operation(summary = "Get artist", description = "Details of a specific artist identified by artistId.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully operation"),
            @ApiResponse(responseCode = "404", description = "Artist not found")
    })
    public Artist getArtist(@PathVariable int artistId) {
        Artist artist = artists.get(artistId);
        return artist;
    }

    // Delete
    @DeleteMapping(value = "/{artistId}")
    @Operation(summary = "Delete artist", description = "Delete specific artist identified by artistId.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Artist successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Artist not found")
    })
    public Artist deleteArtist(@PathVariable int artistId) {
        Artist artist = artists.get(artistId);
        return artist;
    }

    // Update
    @PutMapping(value = "/{artistId}")
    @Operation(summary = "Update artist", description = "Update the details of a specific artist identified by artistId.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Artist successfully updated"),
            @ApiResponse(responseCode = "404", description = "Artist not found")
    })
    public Artist updateArtist(@PathVariable int artistId, @RequestBody Artist newArtist) {
        Artist artist = artists.get(artistId);
        artist = newArtist;
        return artist;
    }

    @PostMapping(value = "")
    @Operation(summary = "Create new artist", description = "Creates a new artist with the provided details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "New Artist successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid artist details provided")
    })
    public Artist createArtist(@RequestBody Artist artist) {
        // TODO save to database
        return artist;
    }
}

// http://localhost:8080/artists?genre=Rock

