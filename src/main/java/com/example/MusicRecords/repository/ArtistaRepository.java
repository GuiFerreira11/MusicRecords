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

  @Query("SELECT b FROM Artista a JOIN a.albuns b WHERE a = :artistaSelecionado")
  List<Album> listarAlbuns(Artista artistaSelecionado);

  @Query("SELECT b FROM Artista a JOIN a.albuns b WHERE a = :artistaSelecionado AND b.nome ILIKE%:nomeAlbum%")
  Album buscarAlbum(Artista artistaSelecionado, String nomeAlbum);

  @Query("Select a FROM Artista a")
  List<Artista> listarTodosArtistas();

  @Query("SELECT m FROM Artista a JOIN a.albuns b JOIN b.musicas m ")
  List<Musica> listarTodasAsMusicas();

  @Query("SELECT m FROM Artista a JOIN a.albuns b JOIN b.musicas m WHERE a = :artistaSelecionado")
  List<Musica> listarMusicasPorArtista(Artista artistaSelecionado);

}
