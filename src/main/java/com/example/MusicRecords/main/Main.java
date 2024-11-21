package com.example.MusicRecords.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.example.MusicRecords.models.Album;
import com.example.MusicRecords.models.Artista;
import com.example.MusicRecords.models.DadosArtista;
import com.example.MusicRecords.models.Musica;
import com.example.MusicRecords.repository.ArtistaRepository;
import com.example.MusicRecords.service.Converter;
import com.example.MusicRecords.service.Gemini;

public class Main {

  private ArtistaRepository repository;
  private Converter converter = new Converter();

  private Scanner scanner = new Scanner(System.in);

  public Main(ArtistaRepository repository) {
    this.repository = repository;
  }

  public void exibeMenu() {
    int option = -1;

    while (option != 0) {

      String menu = """
          ***** Music Records *****

          1 - Cadastrar artista
          2 - Cadastrar música
          3 - Listar músicas
          4 - Buscar músicas por artistas
          5 - Pesquisar dados sobre um artista

          0 - Sair
          """;

      System.out.println(menu);

      option = scanner.nextInt();
      scanner.nextLine();

      switch (option) {
        case 1:
          cadastrarArtista();
          break;
        case 2:
          cadastrarMusica();
          break;
        case 3:
          listarMusicas();
          break;
        case 4:
          buscarMusicaPorArtista();
          break;
        case 5:
          dadosArtista();
          break;
        case 0:
          System.out.println("Encerrando aplicação ...");
          break;
        default:
          System.out.println("Opção inválida, tente novamente!");
      }
    }
  }

  private void cadastrarArtista() {
    System.out.println("Digite o nome do artista");
    String nomeArtista = scanner.nextLine();
    String json = Gemini.obterDadosArtista(nomeArtista);
    System.out.println(json);
    DadosArtista dadosArtista = converter.convertFromJson(json, DadosArtista.class);
    Artista artista = new Artista(dadosArtista);
    List<Album> albuns = dadosArtista.albuns().stream()
        .map(a -> new Album(a.nome(), a.anoLancamento()))
        .collect(Collectors.toList());
    artista.setAlbum(albuns);
    repository.save(artista);
    System.out.println("Artista cadastrado com sucesso!");
    System.out.println(artista);
  }

  private void cadastrarMusica() {
    System.out.println("Qual o nome do artista que canta essa musica?");
    String nomeArtista = scanner.nextLine();
    Optional<Artista> artista = repository.buscarArtista(nomeArtista);
    if (artista.isPresent()) {
      Artista artistaSelecionado = artista.get();
      System.out.println("De qual album é essa música?");
      String nomeAlbum = scanner.nextLine();
      Optional<Album> album = repository.buscarAlbum(artistaSelecionado, nomeAlbum);
      if (album.isPresent()) {
        Album albumSelecionado = album.get();
        System.out.println("Qual o nome da música?");
        String nome = scanner.nextLine();
        Musica musica = new Musica(nome);
        albumSelecionado.setMusica(musica);
        repository.save(artistaSelecionado);
        System.out.println("Musica cadastrada com sucesso!");
        System.out.println(musica);
      }
    }
  }

  private void dadosArtista() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'dadosArtista'");
  }

  private void buscarMusicaPorArtista() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'buscarMusicaPorArtista'");
  }

  private void listarMusicas() {
    List<Musica> musicas = new ArrayList<>();
    musicas = repository.listarTodasAsMusicas();
    musicas.forEach(System.out::println);
  }

}
