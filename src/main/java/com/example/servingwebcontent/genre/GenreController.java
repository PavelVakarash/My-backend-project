package com.example.servingwebcontent.genre;

import com.example.servingwebcontent.artist.ArtistDTO;
import com.example.servingwebcontent.artist.ArtistService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("genres")
public class GenreController {

    private GenreService genreService;

    @Autowired
    public void setGenreService(GenreService genreService) {
        this.genreService = genreService;
    }

    private ArtistService artistsService;

    @Autowired
    public void setArtistService(ArtistService artistsService) {
        this.artistsService = artistsService;
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Get genre", description = " Details of a specific genre identified by genreId.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully operation"),
            @ApiResponse(responseCode = "404", description = "NewGenreDTO not found")
    })
    public GenreDTO getGenre(@PathVariable int id)
    {
        return genreService.getGenre(id);
    }

    @PostMapping(value = "")
    @Operation(summary = "Create new genreDTO", description = "Creates a new genreDTO with the provided details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "New NewGenreDTO successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid genreDTO details provided")
    })
    public int createGenre(@RequestBody NewGenreDTO newGenreDTO)
    {
        // TODO save to database
       return genreService.createGenre(newGenreDTO);
    }

    @GetMapping(value = "/{genreId}/artists")
    public List<ArtistDTO> getArtistsByGenre(@PathVariable int genreId){
        return artistsService.getArtistsByGenre(genreId);
    }

    @GetMapping(value = "/by-name/{name}")
    public List<GenreDTO> getGenresByName(@PathVariable String name){
        return genreService.getGenresByName(name);
    }
}
