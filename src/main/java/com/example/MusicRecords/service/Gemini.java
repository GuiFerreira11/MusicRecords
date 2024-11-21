package com.example.MusicRecords.service;

import java.time.Duration;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.chat.request.ResponseFormat;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import io.github.cdimascio.dotenv.Dotenv;

public class Gemini {

  private static String consultaGemini(String texto) {

    Dotenv dotenv = Dotenv.load();
    String apiKey = dotenv.get("API_KEY_GEMINI");
    ChatLanguageModel gemini = GoogleAiGeminiChatModel.builder()
        .apiKey(apiKey)
        .modelName("gemini-1.5-flash-8b")
        .topK(40)
        .timeout(Duration.ofSeconds(120))
        .responseFormat(ResponseFormat.JSON)
        .build();

    String response = gemini.generate(texto);
    return response;
  }

  public static String obterDadosArtista(String texto) {

    String promptParaBusca = """
        Estou fazendo uma pesquisa sobre bandas/artistas, preciso de informações no formato JSON como descrição do artista, tipo de música, tipo de artista, e uma lista de álbuns lançados pelo artista como nome e o ano de lançamento no formato aaaa para cada disco.

        a banda/artista procurada é: """
        + texto + """

            use esse json schema:
            artista = {
            "nome_artista": {
            "type": "string"
            },
            "descricao": {
            "type": "string"
            },
            "tipo_artista": {
            "type": "string",
            "enum": [
            "solo",
            "dupla",
            "banda"
            ]
            },
            "tipo_musica": {
            "type": "string",
            "enum": [
            "rock",
            "pop",
            "rap",
            "funk",
            "sertanejo",
            "mpb",
            "samba",
            "pagode",
            "forro"
            ]
            },
            "albuns": [
            {
            "nome_album: {
            "type": "string"
            },
            "ano_lancamento": {
            "type": "string"
            }
            }
            ]
            }

            Return artista
                              """;
    return consultaGemini(promptParaBusca);
  }

}
