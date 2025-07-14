package com.frankmoley.lil.roomwebapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.frankmoley.lil.roomwebapp.data.repository.EmployeeRepository;
import com.frankmoley.lil.roomwebapp.data.repository.RoomRepository;

@SpringBootApplication
public class RoomWebAppApplication {

  public static void main(String[] args) {
    SpringApplication.run(RoomWebAppApplication.class, args);
  }

  @Bean
  public CommandLineRunner run(RoomRepository roomRepository, EmployeeRepository employeeRepository){
    return args -> {
      roomRepository.findAll().forEach(System.out::println);
      employeeRepository.findAll().forEach(System.out::println);
    };
  }

}
