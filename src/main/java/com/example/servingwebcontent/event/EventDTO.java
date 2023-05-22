package com.example.servingwebcontent.event;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EventDTO {
//    public EventDTO(String name, String city) {
//        this.name = name;
//        this.city = city;
//    }

    @Schema(description = "Name of the event")
    private String name;
    @Schema(description = "Location of the event")
    private String city;

//    public String getName() {
//        return name;
//    }
//
//    public String getCity() {
//        return city;
//    }
}
