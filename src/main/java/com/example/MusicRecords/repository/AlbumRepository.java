package com.example.MusicRecords.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MusicRecords.models.Album;

public interface AlbumRepository extends JpaRepository<Album, Long> {}
