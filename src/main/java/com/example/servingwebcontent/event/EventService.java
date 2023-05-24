package com.example.servingwebcontent.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public EventDTO getEvent(int id) {
        Optional<Event> eventOptional = eventRepository.findById(id);
        Event event = eventOptional.get();
        EventDTO eventDTO = new EventDTO(event.getName(), event.getCity());
        return eventDTO;
        }

    public void deleteEvent(int id)
    {
        eventRepository.deleteById(id);
        // TODO: remove it from the database
    }

    public void updateEvent(int id, EventDTO eventDTO)
    {
        Event event = eventRepository.findById(id).get();

        event.setName(eventDTO.getName());
        event.setCity(eventDTO.getCity());

        eventRepository.save(event);
        // TODO: update eventDTO in the database
    }

    public void createEvent(EventDTO eventDTO)
    {
        String name = eventDTO.getName();
        String city = eventDTO.getCity();

        Event event = new Event();
        event.setName(name);
        event.setCity(city);
        // TODO: save to database
        eventRepository.save(event);
    }
}
