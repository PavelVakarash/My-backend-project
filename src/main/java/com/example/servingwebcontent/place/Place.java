package com.example.servingwebcontent.place;

import com.example.servingwebcontent.artist.Artist;
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

//    @ManyToMany
//    @JoinTable(
//            name = "event",
//            joinColumns = @JoinColumn(name = "place_id"),
//            inverseJoinColumns = @JoinColumn(name = "artist_id")
//    )
//    private List<Artist> artists;

    @ManyToMany(mappedBy = "places")
    private List<Artist> artists;
}
