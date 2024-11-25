package com.example.MusicRecords.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "artistas")
public class Artista {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String nome;
  @Enumerated(EnumType.STRING)
  private TipoArtista tipoArtista;
  @Enumerated(EnumType.STRING)
  private Genero genero;
  @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<Album> albuns = new ArrayList<>();
  @Column(columnDefinition = "text")
  private String descricao;

  public Artista() {
  }

  public Artista(String nome, String tipoArtista, String genero) {
    this.nome = nome;
    this.tipoArtista = TipoArtista.classificacao(tipoArtista);
    this.genero = Genero.classificacao(genero);
  }

  public Artista(DadosArtista dadosArtista) {
    this.nome = dadosArtista.nome();
    this.tipoArtista = TipoArtista.classificacao(dadosArtista.tipoArtista());
    this.genero = Genero.classificacao(dadosArtista.genero());
    this.descricao = dadosArtista.descricao();
  }

  @Override
  public String toString() {
    return "Artista: " + this.nome + " - " + this.tipoArtista + " - Genero: " + this.genero + "\nDescrição: "
        + this.descricao + "\nÁlbuns:\n" + albuns.stream().map(Album::toString).collect(Collectors.joining("\n"));
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

  public String getDescricao() {
    return this.descricao;
  }

  public void setAlbum(List<Album> albuns) {
    albuns.forEach(a -> a.setArtista(this));
    this.albuns = albuns;
  }

}
