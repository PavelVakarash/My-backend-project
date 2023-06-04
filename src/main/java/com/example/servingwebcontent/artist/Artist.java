package com.example.servingwebcontent.artist;

import com.example.servingwebcontent.event.Event;
import com.example.servingwebcontent.genre.Genre;
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
}

