package com.example.servingwebcontent.place;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PlaceDTO {

    private int id;
    private String name;
    private String address;
    private String city;
}
