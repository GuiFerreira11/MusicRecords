package com.example.MusicRecords.models;

public enum Genero {
  ROCK("rock"),
  POP("pop"),
  FUNK("fun"),
  SERTANEJO("sertanejo"),
  MPB("mpb"),
  SAMBA("samba"),
  PAGODE("pagode"),
  FORRO("forró");

  private String genero;

  Genero(String genero) {
    this.genero = genero;
  }

  public static Genero classificacao(String texto) {
    for (Genero genero : Genero.values()) {
      if (genero.genero.equalsIgnoreCase(texto)) {
        return genero;
      }
    }
    throw new IllegalArgumentException("Genero musical não cadastrado " + texto);
  }
}
