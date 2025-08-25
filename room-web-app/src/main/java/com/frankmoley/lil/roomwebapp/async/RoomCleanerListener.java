package com.frankmoley.lil.roomwebapp.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.frankmoley.lil.roomwebapp.service.RoomService;
import com.frankmoley.lil.roomwebapp.web.model.Room;

@Component
public class RoomCleanerListener {
    private static final Logger LOG = LoggerFactory.getLogger(RoomCleanerListener.class);

    private final ObjectMapper mapper;
    private final RoomService roomService;

    public RoomCleanerListener(ObjectMapper mapper, RoomService roomService) {
        this.mapper = mapper;
        this.roomService = roomService;
    }

    public void receiveMessage(String message) {
        try {
            AsyncPayload payload = this.mapper.readValue(message, AsyncPayload.class);
            if ("ROOM".equals(payload.getModel())) {
                Room room = this.roomService.getRoomById(payload.getId());
                LOG.info("Room {}:{} needs to be cleaned", room.getNumber(), room.getName());
            } else {
                LOG.warn("Unknown model type: {}", payload.getModel());
            }
        } catch (JsonProcessingException e) {
            LOG.error("Unable to process message: {}", message, e);
        }
    }
}
