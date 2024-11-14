package com.example.MusicRecords;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.MusicRecords.main.Main;

@SpringBootApplication
public class MusicRecordsApplication implements CommandLineRunner{

  public static void main(String[] args) {
    SpringApplication.run(MusicRecordsApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    Main main = new Main();
    main.exibeMenu();
  }
}
