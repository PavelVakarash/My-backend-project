package com.example.servingwebcontent.place;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer> {
    List<Place> findByCity(String city);

    List<Place> findByCityAndAddress(String city, String address);
    List<Place> findByCityOrAddress(String city, String address);
}
