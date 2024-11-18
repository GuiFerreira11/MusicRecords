package com.example.MusicRecords.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.example.MusicRecords.models.Album;
import com.example.MusicRecords.models.Artista;
import com.example.MusicRecords.models.Musica;
import com.example.MusicRecords.repository.ArtistaRepository;

public class Main {

  private ArtistaRepository repository;

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
          2 - Cadastrar album
          3 - Cadastrar música
          4 - Listar músicas
          5 - Buscar músicas por artistas
          6 - Pesquisar dados sobre um artista

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
          cadastrarAlbum();
          break;
        case 3:
          cadastrarMusica();
          break;
        case 4:
          listarMusicas();
          break;
        case 5:
          buscarMusicaPorArtista();
          break;
        case 6:
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

  private void cadastrarArtista() {
    System.out.println("Digite o nome do artista");
    String nome = scanner.nextLine();
    System.out.println("Digite o tipo de artista (solo, dupla ou banda)");
    String tipoArtista = scanner.nextLine();
    System.out.println("Digite o genero musical do artista");
    String genero = scanner.nextLine();
    Artista artista = new Artista(nome, tipoArtista, genero);
    repository.save(artista);
    System.out.println("Artista cadastrado com sucesso!");
    System.out.println(artista);
  }

  private void cadastrarAlbum() {
    System.out.println("Para qual artista deseja cadastrar um album?");
    String nomeArtista = scanner.nextLine();
    Optional<Artista> artista = repository.buscarArtista(nomeArtista);
    if (artista.isPresent()) {
      Artista artistaSelecionado = artista.get();
      System.out.println("Digite o nome do albúm que deseja salvar");
      String nome = scanner.nextLine();
      System.out.println("Digite a quantidade de músicas que o albúm tem");
      int numeroDeMusicas = scanner.nextInt();
      scanner.nextLine();
      System.out.println("Digite a data de lançamento do album (dd/mm/aaaa)");
      String dataLancamento = scanner.nextLine();
      Album album = new Album(nome, numeroDeMusicas, dataLancamento);
      artistaSelecionado.setAlbum(album);
      repository.save(artistaSelecionado);
      System.out.println("Album cadastrado com sucesso!");
      System.out.println(album);
    }
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
        System.out.println("Qual a duração da música, em segundos?");
        int duracao = scanner.nextInt();
        scanner.nextLine();
        Musica musica = new Musica(nome, duracao);
        albumSelecionado.setMusica(musica);
        repository.save(artistaSelecionado);
        System.out.println("Musica cadastrada com sucesso!");
        System.out.println(musica);
      }
    }
  }

}
