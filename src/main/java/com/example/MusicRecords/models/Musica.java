package com.example.MusicRecords.models;

public class Musica{

  private String nome;
  private int duracaoEmMinutos;
  private Album album;

  public Musica(String nome, int duracaoEmMinutos){
    this.nome = nome;
    this.duracaoEmMinutos = duracaoEmMinutos;
  }

  @Override
  public String toString(){
    return "Música: " + this.nome + " - Duração em minutos: " + duracaoEmMinutos;
  }

  public String getNome() {
    return nome;
  }

  public int getDuracaoEmMinutos() {
    return duracaoEmMinutos;
  }

  public Album getAlbum() {
    return album;
  }

  public void setAlbum(Album album){
    this.album = album;
  }


}
