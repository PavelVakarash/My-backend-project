package com.example.servingwebcontent.event;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    static final ArrayList<EventDTO> EVENT_DTOS = new ArrayList<EventDTO>() {{
        add(new EventDTO("Opera", "London"));
        add(new EventDTO("Violin concert", "Prague"));
        add(new EventDTO("Jazz concert", "Berlin"));
        add(new EventDTO("Art exhibition", "London"));
    }};

    public List<EventDTO> getEvents(String cityFilter) {
        List<EventDTO> result = EVENT_DTOS;

        if (!cityFilter.equals("all")) {
            result = EVENT_DTOS.stream().filter(e -> e.getCity().equals(cityFilter)).collect(Collectors.toList());
        }
        return result;
    }

    public EventDTO getEvent(int id)
    {
        EventDTO eventDTO = EVENT_DTOS.get(id);
        return eventDTO;
    }

    public EventDTO deleteEvent(int id)
    {
        EventDTO eventDTO = EVENT_DTOS.get(id);
        // TODO: remove it from the database
        return eventDTO;
    }

    public EventDTO updateEvent(int id, EventDTO eventDTO)
    {
        EventDTO origEventDTO = EVENT_DTOS.get(id);
        // TODO: update eventDTO in the database
        return eventDTO;
    }

    public EventDTO createEvent(EventDTO eventDTO)
    {
        // TODO save to database
        return eventDTO;
    }
}
