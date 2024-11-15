package com.example.MusicRecords.models;

import java.time.LocalDate;
import java.util.List;

public class Album {
  private String nome;
  private int numeroDeMusicas;
  private LocalDate dataLancamento;
  private Artista artista;
  private List<Musica> musicas;

  public Album(String nome, int numeroDeMusicas, LocalDate dataLancamento) {
    this.nome = nome;
    this.numeroDeMusicas = numeroDeMusicas;
    this.dataLancamento = dataLancamento;
  }

  @Override
  public String toString() {
    return "Album: " + this.nome + " - Número de músicas: " + this.numeroDeMusicas + " - Data de Laçamento:"
        + this.dataLancamento;
  }

  public String getNome() {
    return nome;
  }

  public int getNumeroDeMusicas() {
    return numeroDeMusicas;
  }

  public LocalDate getDataLancamento() {
    return dataLancamento;
  }

  public Artista getArtista() {
    return artista;
  }

  public List<Musica> getMusicas() {
    return musicas;
  }

  public void setArtista(Artista artista) {
    this.artista = artista;
  }
   public void setMusica(List<Musica> musicas){
    musicas.forEach(m -> m.setAlbum(this));
    this.musicas = musicas;
  }
}
