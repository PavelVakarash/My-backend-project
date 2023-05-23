package com.example.servingwebcontent.event;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("EVENT_DTOS")
public class EventController {

    private EventService service;

    @Autowired
    public void setService(EventService service) {
        this.service = service;
    }

    @GetMapping(value = "")

    @Operation(summary = "Get all EVENT_DTOS", description = "A list of all EVENT_DTOS available in the system. " +
            "Is possible to filter EVENT_DTOS by city. " +
            "The response includes the event name and city.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully operation"),
            @ApiResponse(responseCode = "400", description = "Invalid city parameter provided")
    })
    public List<EventDTO> listEvents(@RequestParam(name = "city", required = false, defaultValue = "all") String city, Model model)
    {
        return service.getEvents(city);
    }

    @GetMapping(value = "/{eventId}")
    //@ResponseBody
    @Operation(summary = "Get event", description = " Details of a specific event identified by eventId.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully operation"),
            @ApiResponse(responseCode = "404", description = "EventDTO not found")
    })
    public EventDTO getEvent(@PathVariable int id)
    {
        return service.getEvent(id);
    }

    @DeleteMapping(value = "/{eventId}")
    @Operation(summary = "Delete event", description = "Delete specific event identified by eventId.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "EventDTO successfully deleted"),
            @ApiResponse(responseCode = "404", description = "EventDTO not found")
    })
    public EventDTO deleteEvent(@PathVariable int id)
    {
        // TODO: Add real remove
        return service.deleteEvent(id);
    }

    @PutMapping(value = "/{eventId}")
    @Operation(summary = "Update event", description = "Update the details of a specific eventDTO identified by eventId.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "EventDTO successfully updated"),
            @ApiResponse(responseCode = "404", description = "EventDTO not found")
    })
    public EventDTO updateEvent(@PathVariable int id, @RequestBody EventDTO eventDTO)
    {
        // TODO: update eventDTO in database
        return service.updateEvent(id, eventDTO);
    }

    @PostMapping(value = "")
    @Operation(summary = "Create new eventDTO", description = "Creates a new eventDTO with the provided details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "New EventDTO successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid eventDTO details provided")
    })
    public EventDTO createEvent(@RequestBody EventDTO eventDTO)
    {
        // TODO save to database
        return service.createEvent(eventDTO);
    }
}
