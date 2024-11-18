package com.example.MusicRecords.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.MusicRecords.models.Album;
import com.example.MusicRecords.models.Artista;
import com.example.MusicRecords.models.Musica;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

  @Query("SELECT a FROM Artista a WHERE a.nome ILIKE %:nomeArtista%")
  Optional<Artista> buscarArtista(String nomeArtista);

  @Query("SELECT d FROM Artista a JOIN a.albuns d WHERE a = :artistaSelecionado AND d.nome ILIKE %:nomeAlbum%")
  Optional<Album> buscarAlbum(Artista artistaSelecionado, String nomeAlbum);

  @Query("SELECT m FROM Artista a JOIN a.albuns d JOIN d.musicas m")
  List<Musica> listarTodasAsMusicas();

}
