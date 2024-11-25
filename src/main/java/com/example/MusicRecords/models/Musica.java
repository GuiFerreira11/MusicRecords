package com.example.MusicRecords.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "musicas")
public class Musica {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String nome;
  @ManyToOne
  @JoinColumn(name = "album_id")
  private Album album;

  public Musica() {
  }

  public Musica(String nome) {
    this.nome = nome;
  }

  @Override
  public String toString() {
    return "Música: " + this.nome + " - Álbum: " + this.album.getNome();
  }

  public String getNome() {
    return nome;
  }

  public Album getAlbum() {
    return album;
  }

  public void setAlbum(Album album) {
    this.album = album;
  }

}
