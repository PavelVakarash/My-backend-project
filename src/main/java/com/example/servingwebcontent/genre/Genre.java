package com.example.servingwebcontent.genre;

import com.example.servingwebcontent.artist.Artist;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "genre")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String name;

    @OneToMany(mappedBy = "genre")
    private List<Artist> artists;
}
