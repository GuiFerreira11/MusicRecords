package com.example.MusicRecords.models;

import java.util.List;
import java.util.stream.Collectors;

public class Artista {
  private String nome;
  private TipoArtista tipoArtista;
  private Genero genero;
  private List<Album> albuns;

  public Artista(String nome, String tipoArtista, String genero) {
    this.nome = nome;
    this.tipoArtista = TipoArtista.classificacao(tipoArtista);
    this.genero = Genero.classificacao(genero);
  }

  @Override
  public String toString() {
    return "Artista: " + this.nome + " - " + this.tipoArtista + " - Genero: " + this.genero + "\n Albuns:"
        + albuns.stream().map(Album::toString).collect(Collectors.joining("\n"));
  }

  public String getNome() {
    return nome;
  }

  public TipoArtista getTipoArtista() {
    return tipoArtista;
  }

  public Genero getGenero() {
    return genero;
  }

  public List<Album> getAlbuns() {
    return albuns;
  }

  public void setAlbuns(List<Album> albuns) {
    albuns.forEach(a -> a.setArtista(this));
    this.albuns = albuns;
  }

}
