package com.example.servingwebcontent.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    @Query("SELECT e FROM Event e INNER JOIN e.place p WHERE p.city = :city")
    List<Event> findFilteredByCity(@Param("city") String city);

    @Query("SELECT e FROM Event e INNER JOIN e.genre g WHERE g.name = :name")
    List<Event> findByGenreName(@Param("name") String name);
}
