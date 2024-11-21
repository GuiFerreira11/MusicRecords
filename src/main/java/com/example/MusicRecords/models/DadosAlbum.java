package com.example.MusicRecords.models;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DadosAlbum(@JsonAlias("nome_album") String nome,
    @JsonAlias("ano_lancamento") String anoLancamento) {
}
