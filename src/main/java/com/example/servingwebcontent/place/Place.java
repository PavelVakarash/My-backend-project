package com.example.servingwebcontent.place;

import com.example.servingwebcontent.event.Event;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Table(name = "place")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Place {
    // id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    // name
    @NonNull
    private String name;

    // address
    @NonNull
    private String address;

    // city
    @NonNull
    private String city;

    @OneToMany(mappedBy = "place")
    private List<Event> events;
}
