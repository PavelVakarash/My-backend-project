package com.example.servingwebcontent.event;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class NewEventDTO {
    private String name;
    private int placeId;
}
