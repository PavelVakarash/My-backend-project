package com.example.servingwebcontent.place;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceService {

    private PlaceRepository placeRepository;

    private static final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public void setPlaceRepository(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public int createPlace(NewPlaceDTO newPlaceDTO){
        Place place = modelMapper.map(newPlaceDTO, Place.class);
       return placeRepository.save(place).getId();
    }

    public PlaceDTO getPlace(int id){
       Place place = placeRepository.findById(id).get();
       PlaceDTO result = modelMapper.map(place, PlaceDTO.class);
       return result;
    }
}
