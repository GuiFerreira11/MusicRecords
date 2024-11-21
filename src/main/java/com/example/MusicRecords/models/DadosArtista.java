package com.example.MusicRecords.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DadosArtista(@JsonAlias("nome_artista") String nome,
    String descricao,
    @JsonAlias("tipo_artista") String tipoArtista,
    @JsonAlias("tipo_musica") String genero,
    List<DadosAlbum> albuns) {

}
