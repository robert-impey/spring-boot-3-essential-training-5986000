package com.frankmoley.lil.roomwebapp.async;

import java.util.UUID;

import lombok.Data;

@Data
public class AsyncPayload {
    private UUID id;
    private String model;
}
