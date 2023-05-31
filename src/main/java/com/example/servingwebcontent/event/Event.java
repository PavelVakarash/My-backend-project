package com.example.servingwebcontent.event;

import com.example.servingwebcontent.place.Place;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "event")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Event {
    //@GeneratedValue // Create ID automatically
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @NonNull
    private String name;

//    @NonNull
//    private String city; // TODO: replace to place

    @ManyToOne  // Owner
    private Place place; // place_id -> place.id
}
