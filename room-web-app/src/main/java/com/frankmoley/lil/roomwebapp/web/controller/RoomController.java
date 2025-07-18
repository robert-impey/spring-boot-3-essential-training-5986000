package com.frankmoley.lil.roomwebapp.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.frankmoley.lil.roomwebapp.data.repository.RoomRepository;
import com.frankmoley.lil.roomwebapp.web.model.Room;

import org.springframework.web.bind.annotation.GetMapping;

import com.frankmoley.lil.roomwebapp.data.entity.RoomEntity;

@Controller
@RequestMapping("/rooms")
public class RoomController {
    private final RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping
    public String getRoomsPage(Model model) {
        List<RoomEntity> roomEntities = roomRepository.findAll();
        List<Room> rooms = new ArrayList<Room>(roomEntities.size());

        roomEntities.forEach(roomEntity -> {
            Room room = new Room(roomEntity.getRoomId(), roomEntity.getName(), roomEntity.getNumber(), roomEntity.getBedInfo());
            rooms.add(room);
        });

        model.addAttribute("rooms", rooms);
        return "rooms";
    }

}
