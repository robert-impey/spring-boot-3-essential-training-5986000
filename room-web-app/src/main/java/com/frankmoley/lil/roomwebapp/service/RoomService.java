package com.frankmoley.lil.roomwebapp.service;

import com.frankmoley.lil.roomwebapp.data.entity.RoomEntity;
import com.frankmoley.lil.roomwebapp.data.repository.RoomRepository;
import com.frankmoley.lil.roomwebapp.web.model.Room;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        List<RoomEntity> roomEntities = this.roomRepository.findAll();
        List<Room> rooms = new ArrayList<>(roomEntities.size());

        roomEntities.forEach(e -> rooms.add(getRoomFromEntity(e)));

        return rooms;
    }

    public Room getRoomById(UUID id) {
        Optional<RoomEntity> roomEntity = this.roomRepository.findById(id);

        return roomEntity.map(this::getRoomFromEntity).orElse(null);
    }

    public Room addRoom(Room room) {
        RoomEntity entity = getEntityFromRoom(room);
        entity = roomRepository.save(entity);
        return getRoomFromEntity(entity);
    }

    public Room updateRoom(Room room) {
        return addRoom(room);
    }

    public void deleteRoom(UUID id) {
        this.roomRepository.deleteById(id);
    }

    private Room getRoomFromEntity(RoomEntity roomEntity) {
        return new Room(roomEntity.getRoomId(), roomEntity.getName(), roomEntity.getNumber(), roomEntity.getBedInfo());
    }

    private RoomEntity getEntityFromRoom(Room room) {
        return new RoomEntity(room.getId(), room.getName(), room.getNumber(), room.getInfo());
    }
}
