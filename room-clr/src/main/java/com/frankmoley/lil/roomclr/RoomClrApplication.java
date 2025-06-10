package com.frankmoley.lil.roomclr;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RoomClrApplication {

  public static void main(String[] args) {
    SpringApplication.run(RoomClrApplication.class, args);
  }

  @Bean
  public CommandLineRunner run() {
    return args -> {
      for(int i=1; i<=100;i++){
        if (i % 15 == 0) {
          System.out.println("FizzBuzz");
        } else if (i % 3 == 0) {
          System.out.println("Fizz");
        } else if (i % 5 == 0) {
          System.out.println("Buzz");
        } else {
          System.out.println(i);
        }
      }
    };
  }

}
