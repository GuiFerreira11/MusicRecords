package com.example.MusicRecords.main;

import com.example.MusicRecords.models.Album;
import com.example.MusicRecords.models.Artista;
import com.example.MusicRecords.models.DadosArtista;
import com.example.MusicRecords.models.Musica;
import com.example.MusicRecords.repository.AlbumRepository;
import com.example.MusicRecords.repository.ArtistaRepository;
import com.example.MusicRecords.service.Converter;
import com.example.MusicRecords.service.Gemini;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

  private ArtistaRepository artistaRepository;
  private AlbumRepository albumRepository;
  private Converter converter = new Converter();

  private Scanner scanner = new Scanner(System.in);

  public Main(ArtistaRepository artistaRepository, AlbumRepository albumRepository) {
    this.artistaRepository = artistaRepository;
    this.albumRepository = albumRepository;
  }

  public void exibeMenu() {
    int option = -1;

    String menu =
        """
        ***** Music Records *****

        1 - Cadastrar artista
        2 - Cadastrar música
        3 - Listar Artistas
        4 - Listar músicas
        5 - Buscar músicas por artistas
        6 - Pesquisar dados sobre um artista

        0 - Sair
        """;

    while (option != 0) {

      System.out.println(menu);

      if (scanner.hasNextInt()) {
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
            listarArtistas();
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
      } else {
        System.out.println("Opção inválida, tente novamente!");
        scanner.nextLine();
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
    List<Album> albuns =
        dadosArtista.albuns().stream()
            .map(a -> new Album(a.nome(), a.anoLancamento()))
            .collect(Collectors.toList());
    artista.setAlbum(albuns);
    artistaRepository.save(artista);
    System.out.println("Artista cadastrado com sucesso!");
    System.out.println(artista);
  }

  private void cadastrarMusica() {
    System.out.println("Qual o nome do artista que canta essa música?");
    String nomeArtista = scanner.nextLine();
    Optional<Artista> artista = artistaRepository.buscarArtista(nomeArtista);
    if (artista.isPresent()) {
      Artista artistaSelecionado = artista.get();
      List<Album> albuns = artistaRepository.listarAlbuns(artistaSelecionado);
      System.out.println("Selecione o álbum da música que deseja cadastrar");
      albuns.forEach(
          a -> {
            System.out.println(albuns.indexOf(a) + 1 + " - Álbum: " + a.getNome());
          });
      if (scanner.hasNextInt()) {
        int numeroAlbum = scanner.nextInt();
        scanner.nextLine();
        Album albumSelecionado =
            artistaRepository.buscarAlbum(
                artistaSelecionado, albuns.get(numeroAlbum - 1).getNome());
        System.out.println("Qual o nome da música?");
        String nome = scanner.nextLine();
        Musica musica = new Musica(nome);
        albumSelecionado.setMusica(musica);
        albumRepository.save(albumSelecionado);
        System.out.println("Música cadastrada com sucesso!");
        System.out.println(musica);
      } else {
        System.out.println("Álbum não encontrado!");
      }
    } else {
      System.out.println("Artista não encontrado!");
    }
  }

  private void listarArtistas() {
    List<Artista> artistasList = artistaRepository.listarTodosArtistas();
    artistasList.forEach(System.out::println);
  }

  private void listarMusicas() {
    List<Musica> musicasList = artistaRepository.listarTodasAsMusicas();
    musicasList.forEach(System.out::println);
  }

  private void buscarMusicaPorArtista() {
    System.out.println("Para qual artista dejesa obter a lista de músicas cadastradas?");
    String nomeArtista = scanner.nextLine();
    Optional<Artista> artista = artistaRepository.buscarArtista(nomeArtista);
    if (artista.isPresent()) {
      Artista artistaSelecionado = artista.get();
      List<Musica> musicasSelecionadas =
          artistaRepository.listarMusicasPorArtista(artistaSelecionado);
      musicasSelecionadas.forEach(System.out::println);
    } else {
      System.out.println("Artista não encontrado!");
    }
  }

  private void dadosArtista() {
    System.out.println("Para qual artista dejesa obter informações?");
    String nomeArtista = scanner.nextLine();
    Optional<Artista> artista = artistaRepository.buscarArtista(nomeArtista);
    if (artista.isPresent()) {
      Artista artistaSelecionado = artista.get();
      System.out.println(artistaSelecionado);
    } else {
      System.out.println("Artista não encontrado!");
    }
  }
}
