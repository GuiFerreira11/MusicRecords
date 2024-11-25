package com.example.MusicRecords.models;

import java.time.Year;
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
  private Year anoLancamento;
  @ManyToOne
  @JoinColumn(name = "artista_id")
  private Artista artista;
  @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<Musica> musicas = new ArrayList<>();

  public Album() {
  }

  public Album(String nome, String dataLancamento) {
    this.nome = nome;
    this.anoLancamento = Year.parse(dataLancamento);
  }

  @Override
  public String toString() {
    return "Álbum: " + this.nome + " - Ano de Laçamento:" + this.anoLancamento;
  }

  public String getNome() {
    return nome;
  }

  public Year getAnoLancamento() {
    return anoLancamento;
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
