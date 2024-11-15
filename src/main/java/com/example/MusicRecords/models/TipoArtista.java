package com.example.MusicRecords.models;

public enum TipoArtista {
  SOLO("solo"),
  DUPLA("dupla"),
  BANDA("banda");

  private String tipoArtista;

  TipoArtista(String tipoArtista) {
    this.tipoArtista = tipoArtista;
  }

  public static TipoArtista classificacao(String texto){
    for (TipoArtista tipoArtista : TipoArtista.values()){
      if (tipoArtista.tipoArtista.equalsIgnoreCase(texto)) {
        return tipoArtista;
      }

    }
    throw new IllegalArgumentException("Tipo de artista não cadastrado " + texto);
  }
}
