package com.example.servingwebcontent.artist;

import jakarta.persistence.*;
import lombok.*;

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

    @NonNull
    private String genre;
}
