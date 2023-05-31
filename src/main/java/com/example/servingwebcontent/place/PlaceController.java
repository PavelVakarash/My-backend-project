package com.example.servingwebcontent.place;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("places")
public class PlaceController {

    private PlaceService placeService;

    @Autowired
    public void setPlaceService(PlaceService placeService) {
        this.placeService = placeService;
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
}
