package com.example.servingwebcontent.artist;

import com.example.servingwebcontent.event.Event;
import com.example.servingwebcontent.genre.Genre;
import com.example.servingwebcontent.place.Place;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "artist")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Artist {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @NonNull
    private String name;

//    @NonNull
//    private String genre;
    @ManyToOne
    private Genre genre;

    @OneToMany(mappedBy = "artist")
    private List<Event> events;

//    @ManyToMany(mappedBy = "artists")
//    private List<Place> places;

    @ManyToMany
    @JoinTable(
            name = "event",
            joinColumns = @JoinColumn(name = "artist_id"),
            inverseJoinColumns = @JoinColumn(name = "place_id")
    )
    private List<Place> places;
}

