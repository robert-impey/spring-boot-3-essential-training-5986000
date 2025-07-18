package com.frankmoley.lil.roomwebapp.web.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    private UUID id;
    private String name;
    private String number;
    private String info;
}
