package com.example.servingwebcontent.event;

import com.example.servingwebcontent.place.Place;
import com.example.servingwebcontent.place.PlaceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    private static final ModelMapper modelMapper = new ModelMapper();


    private EventRepository eventRepository;
    private PlaceRepository placeRepository;

    @Autowired
    public void setPlaceRepository(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

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
                EventDTO eventDTO = new EventDTO(event.getName(), event.getPlace().getCity());
                result.add(eventDTO);
            }
            return result;
        }

    public EventDTO getEvent(int id) {
        Event event = eventRepository.findById(id).get();

        return modelMapper.map(event, EventDTO.class);
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
        event.getPlace().setCity(eventDTO.getCity());

        eventRepository.save(event);
        // TODO: update eventDTO in the database
    }

    public int createEvent(NewEventDTO newEventDTO)
    {
        // TODO: save to database
        int placeId = newEventDTO.getPlaceId();
        Place place = placeRepository.findById(placeId).get();
        Event event = new Event();
        event.setName(newEventDTO.getName());
        event.setPlace(place);
        return eventRepository.save(event).getId();
    }
}
