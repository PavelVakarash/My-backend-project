package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Event
{
    public Event(String name, String city)
    {
        this.name = name;
        this.city = city;
    }
    private String name;
    private String city;

    public String getName()
    {
        return name;
    }

    public String getCity()
    {
        return city;
    }
}

//@Controller
@RestController
public class EventController {

    static final ArrayList<Event> events = new ArrayList<Event>(){{
        add(new Event("Opera", "London"));
        add(new Event("Violin concert", "Prague"));
        add(new Event("Jazz concert", "Berlin"));
        add(new Event("Art exhibition", "London"));
    }};
    //@RequestMapping(value = "/events", method = RequestMethod.GET)
    @GetMapping(value = "/events")
    //@ResponseBody
    // @GetMapping(value = "/events")

    // http://localhost:8080/events?city=Berlin
    // http://localhost:8080/events

    // Resource - events
    // URL : http://localhost:8080/events
    // Representation: JSON
    // Method: GET
    public List<Event> listEvents(@RequestParam(name = "city", required = false, defaultValue = "all") String city, Model model)
    {
        List<Event> result = events;

        if (!city.equals("all")) {
            result = events.stream().filter(e -> e.getCity().equals(city)).collect(Collectors.toList());
        }

        /**
         if (city.equals("all")) {
         model.addAttribute("events", events);
         } else {
         // Filter list by city name
         List<Event> cityEvents = events.stream().filter(e -> e.getCity().equals(city)).collect(Collectors.toList());
         model.addAttribute("events", cityEvents); // Pass data to view
         }
         **/
     return result;
    }
    // Resource - Event
    // URL : http://localhost:8080/events/{Id} - index 0
    // Representation: JSON {"name":"Opera","city":"London"}
    // Method: GET
    //@RequestMapping(value = "/events/{eventId}", method = RequestMethod.GET)
    @GetMapping(value = "/events/{eventId}")
    //@ResponseBody
    public Event getEvent(@PathVariable int eventId)
    {
        Event event = events.get(eventId);
        return event;
    }

    // Delete
    //@RequestMapping(value = "/events/{eventId}", method = RequestMethod.DELETE)
    @DeleteMapping(value = "/events/{eventId}")
    public Event deleteEvent(@PathVariable int eventId)
    {
        // TODO: Add real remove
        Event event = events.get(eventId);
        return event;
    }

    // Update
    @PutMapping(value = "/events/{eventId}")
    public Event updateEvent(@PathVariable int eventId, @RequestBody Event newEvent)
    {
        Event event = events.get(eventId);
        // TODO: update event in database
        event = newEvent; // useless. just for example
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
