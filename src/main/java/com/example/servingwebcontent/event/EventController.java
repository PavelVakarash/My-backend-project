package com.example.servingwebcontent.event;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//@Controller
@RestController
@RequestMapping("events")
public class EventController {

    static final ArrayList<Event> events = new ArrayList<Event>(){{
        add(new Event("Opera", "London"));
        add(new Event("Violin concert", "Prague"));
        add(new Event("Jazz concert", "Berlin"));
        add(new Event("Art exhibition", "London"));
    }};
    //@RequestMapping(value = "/events", method = RequestMethod.GET)
    //@GetMapping(value = "/events")
    @GetMapping(value = "")

    @Operation(summary = "Get all events", description = "A list of all events available in the system. " +
            "Is possible to filter events by city. " +
            "The response includes the event name and city.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully operation"),
            @ApiResponse(responseCode = "400", description = "Invalid city parameter provided")
    })
    public List<Event> listEvents(@RequestParam(name = "city", required = false, defaultValue = "all") String city, Model model)
    {
        List<Event> result = events;

        if (!city.equals("all")) {
            result = events.stream().filter(e -> e.getCity().equals(city)).collect(Collectors.toList());
        }
     return result;
    }

    //@GetMapping(value = "/events/{eventId}")
    @GetMapping(value = "/{eventId}")
    //@ResponseBody
    @Operation(summary = "Get event", description = " Details of a specific event identified by eventId.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully operation"),
            @ApiResponse(responseCode = "404", description = "Event not found")
    })
    public Event getEvent(@PathVariable int eventId)
    {
        Event event = events.get(eventId);
        return event;
    }

    // Delete
    //@RequestMapping(value = "/events/{eventId}", method = RequestMethod.DELETE)
    //@DeleteMapping(value = "/events/{eventId}")
    @DeleteMapping(value = "/{eventId}")
    @Operation(summary = "Delete event", description = "Delete specific event identified by eventId.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Event successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Event not found")
    })
    public Event deleteEvent(@PathVariable int eventId)
    {
        // TODO: Add real remove
        Event event = events.get(eventId);
        return event;
    }

    // Update
    //@PutMapping(value = "/events/{eventId}")
    @PutMapping(value = "/{eventId}")
    @Operation(summary = "Update event", description = "Update the details of a specific event identified by eventId.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Event successfully updated"),
            @ApiResponse(responseCode = "404", description = "Event not found")
    })
    public Event updateEvent(@PathVariable int eventId, @RequestBody Event newEvent)
    {
        Event event = events.get(eventId);
        // TODO: update event in database
        event = newEvent; // useless. just for example
        return event;
    }
    //@PostMapping(value = "/events")
    @PostMapping(value = "")
    @Operation(summary = "Create new event", description = "Creates a new event with the provided details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "New Event successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid event details provided")
    })
    public Event createEvent(@RequestBody Event event)
    {
        // TODO save to database
        return event;
    }

//      @RequestMapping(value = "/events", method = RequestMethod.GET)
//    // @GetMapping(value = "/events")
//
//    // http://localhost:8080/events?city=Berlin
//    // http://localhost:8080/events
//    public String listEventsChangeName(@RequestParam(name = "city", required = false, defaultValue = "all") String city, Model model)
//    {
//        List<Event> result = events;
//
//        if (!city.equals("all")) {
//            result = events.stream().filter(e -> e.getCity().equals(city)).collect(Collectors.toList());
//        }
//
//        model.addAttribute("events", result);
//        /**
//         if (city.equals("all")) {
//         model.addAttribute("events", events);
//         } else {
//         // Filter list by city name
//         List<Event> cityEvents = events.stream().filter(e -> e.getCity().equals(city)).collect(Collectors.toList());
//         model.addAttribute("events", cityEvents); // Pass data to view
//         }
//         **/
//        return "eventsview"; // Return name of view
//    }
}
