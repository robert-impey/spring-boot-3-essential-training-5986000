package com.frankmoley.lil.roomwebapp.data.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "rooms")
@Data
public class RoomEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "ROOM_ID")
  private UUID roomId;
  @Column(name = "NAME")
  private String name;
  @Column(name = "NUMBER")
  private String number;
  @Column(name = "BED_INFO")
  private String bedInfo;

  @Override
  public String toString() {
    return "RoomEntity{" +
        "roomId=" + roomId +
        ", name='" + name + '\'' +
        ", number='" + number + '\'' +
        ", bedInfo='" + bedInfo + '\'' +
        '}';
  }
}
