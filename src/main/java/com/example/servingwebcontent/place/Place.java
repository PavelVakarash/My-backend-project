package com.example.servingwebcontent.place;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NonNull;

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
}
