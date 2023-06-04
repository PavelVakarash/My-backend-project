package com.example.servingwebcontent.event;

import com.example.servingwebcontent.artist.Artist;
import com.example.servingwebcontent.artist.ArtistRepository;
import com.example.servingwebcontent.place.Place;
import com.example.servingwebcontent.place.PlaceRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private static final ModelMapper modelMapper = new ModelMapper();


    private EventRepository eventRepository;
    private PlaceRepository placeRepository;
    private ArtistRepository artistRepository;

    @Autowired
    public void setArtistRepository(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Autowired
    public void setPlaceRepository(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Autowired
    public void setEventRepository(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

        public List<EventDTO> getEvents(String cityFilter)
        {
            //1. GET Entity
            List<Event> allEvents = eventRepository.findAll();
            //2. Move data to DTO
            List<EventDTO> result = modelMapper.map(allEvents, new TypeToken<List<EventDTO>>(){}.getType());
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

    public void updateEvent(int id, NewEventDTO eventDTO)
    {
        // 1. Get from database
        Optional<Event> eventOptional = eventRepository.findById(id);
        Event event = eventOptional.get();
        // 2. Update with new data
        event.setName(eventDTO.getName());
        Place place = placeRepository.findById(eventDTO.getPlaceId()).get();
        event.setPlace(place);
        Artist artist = artistRepository.findById(eventDTO.getArtistId()).get();
        event.setArtist(artist);
        // 3. Save to database
        eventRepository.save(event);
        // TODO: update eventDTO in the database
    }

    public int createEvent(NewEventDTO newEventDTO)
    {
        // TODO: save to database
        int placeId = newEventDTO.getPlaceId();
        Place place = placeRepository.findById(placeId).get();
        int artistId = newEventDTO.getArtistId();
        Artist artist = artistRepository.findById(artistId).get();
        Event event = new Event();
        event.setName(newEventDTO.getName());
        event.setPlace(place);
        event.setArtist(artist);
        return eventRepository.save(event).getId();
    }

    public List<EventDTO> getEventsByPlace(int placeId){
           Place place = placeRepository.findById(placeId).get();
           List<Event> eventsForPlace = place.getEvents();
           List<EventDTO> result = modelMapper.map(eventsForPlace, new TypeToken<List<EventDTO>>(){}.getType());
           return result;
    }
}
