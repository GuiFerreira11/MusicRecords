package com.example.MusicRecords;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.MusicRecords.main.Main;
import com.example.MusicRecords.repository.ArtistaRepository;

@SpringBootApplication
public class MusicRecordsApplication implements CommandLineRunner{

  @Autowired
  private ArtistaRepository repository;

  public static void main(String[] args) {
    SpringApplication.run(MusicRecordsApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    Main main = new Main(repository);
    main.exibeMenu();
  }
}
