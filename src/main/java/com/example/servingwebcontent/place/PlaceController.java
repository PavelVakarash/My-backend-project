package com.example.servingwebcontent.place;

import com.example.servingwebcontent.artist.ArtistDTO;
import com.example.servingwebcontent.artist.ArtistService;
import com.example.servingwebcontent.event.EventDTO;
import com.example.servingwebcontent.event.EventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("places")
public class PlaceController {

    private PlaceService placeService;
    private ArtistService artistService;

    @Autowired
    public void setArtistService(ArtistService artistService) {
        this.artistService = artistService;
    }

    @Autowired
    public void setPlaceService(PlaceService placeService) {
        this.placeService = placeService;
    }

    private EventService eventsService;

    @Autowired
    public void setEventsService(EventService eventsService) {
        this.eventsService = eventsService;
    }

    @PostMapping(value = "")
    @Operation(summary = "Create new placeDTO", description = "Creates a new placeDTO with the provided details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "New NewPlaceDTO successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid placeDTO details provided")
    })
    public int createPlace(@RequestBody NewPlaceDTO newPlaceDTO)
    {
        // TODO save to database
      return placeService.createPlace(newPlaceDTO);
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Get place", description = " Details of a specific place identified by placeId.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully operation"),
            @ApiResponse(responseCode = "404", description = "NewPlaceDTO not found")
    })
    public PlaceDTO getPlace(@PathVariable int id){
        return placeService.getPlace(id);
    }

    // GET /places/{placeId}/events - get all events for the place(with placeId) - Enpoint API
    @GetMapping(value = "/{placeId}/events")
    public List<EventDTO> getEventsByPlace(@PathVariable int placeId){
       return eventsService.getEventsByPlace(placeId);
    }

    // Endpoint: places/{placeId}/artists
    @GetMapping(value = "/{placeId}/artists")
    public List<ArtistDTO> getArtistByPlaceId(@PathVariable int placeId){
        return artistService.getArtistByPlaceId(placeId);
    }

    @GetMapping(value = "/by-city/{city}")
    public List<PlaceDTO> getPlacesByCity(@PathVariable String city){
        return placeService.getPlacesByCityName(city);
    }

    @GetMapping(value = "/by-city/{city}/address/{address}")
    public List<PlaceDTO> getPlacesByCityWithAddress(@PathVariable String city,@PathVariable String address){
        return placeService.getPlacesByCityWithAddress(city, address);
    }

    @GetMapping(value = "/by-city/{city}/or/address/{address}")
    public List<PlaceDTO> getPlacesByCityOrAddress(@PathVariable String city,@PathVariable String address){
        return placeService.getPlacesByCityOrAddress(city, address);
    }

}
