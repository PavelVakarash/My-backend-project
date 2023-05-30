package com.example.servingwebcontent.event;

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

    @NonNull
    private String city;
}
