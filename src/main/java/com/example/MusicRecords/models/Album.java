package com.example.MusicRecords.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "albuns")
public class Album {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String nome;
  private int numeroDeMusicas;
  private LocalDate dataLancamento;
  @ManyToOne
  @JoinColumn(name = "artista_id")
  private Artista artista;
  @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<Musica> musicas = new ArrayList<>();

  public Album() {
  }

  public Album(String nome, int numeroDeMusicas, String dataLancamento) {
    this.nome = nome;
    this.numeroDeMusicas = numeroDeMusicas;
    this.dataLancamento = LocalDate.parse(dataLancamento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
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

  public void setListMusica(List<Musica> musicas) {
    musicas.forEach(m -> m.setAlbum(this));
    this.musicas = musicas;
  }

  public void setMusica(Musica musica) {
    musica.setAlbum(this);
    this.musicas.add(musica);
  }
}
