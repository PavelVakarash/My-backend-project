package com.example.servingwebcontent.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    private EventRepository eventRepository;

    @Autowired
    public void setEventRepository(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    static final ArrayList<EventDTO> EVENT_DTOS = new ArrayList<EventDTO>() {{
        add(new EventDTO("Opera", "London"));
        add(new EventDTO("Violin concert", "Prague"));
        add(new EventDTO("Jazz concert", "Berlin"));
        add(new EventDTO("Art exhibition", "London"));
    }};

        public List<EventDTO> getEvents(String cityFilter)
        {
            Iterable<Event> allEvents = eventRepository.findAll();
            List<EventDTO> result = new ArrayList<EventDTO>();
            for (Event event : allEvents)
            {
                EventDTO eventDTO = new EventDTO(event.getName(), event.getCity());
                result.add(eventDTO);
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
        String name = eventDTO.getName();
        String city = eventDTO.getCity();

        Event event = new Event();
        event.setName(name);
        event.setCity(city);
        // TODO: save to database
        eventRepository.save(event);
        return eventDTO;
    }
}
