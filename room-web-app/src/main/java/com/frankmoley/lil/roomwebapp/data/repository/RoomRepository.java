package com.frankmoley.lil.roomwebapp.data.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frankmoley.lil.roomwebapp.data.entity.RoomEntity;

public interface RoomRepository extends JpaRepository<RoomEntity, UUID> {
    // Additional query methods can be defined here if needed

}
