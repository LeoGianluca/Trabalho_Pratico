package facade.cli;

import helpers.Menu;
import model.Client;
import model.GameMultiplayer;
import model.GameSinglePlayer;
import repository.ClientRepositoryFile;
import repository.GameMultiPlayerRepositoryFile;
import repository.GameSinglePlayerRepositoryFile;

import java.util.Scanner;

public class CliFacade {
	private Menu menu = new Menu();

	static Scanner scanner = new Scanner(System.in);

	public void peopleOptions() {
		ClientRepositoryFile clientRepository = new ClientRepositoryFile();

		menu.printPeopleMenu();

		int option = scanner.nextInt();

		while (option != 0) {
			switch (option) {
				case 1:
					System.out.println();
					System.out.println(">>> CADASTRAR CLIENTE");
					formPeople(scanner);
					break;
				case 2:
					System.out.println();
					System.out.println(">>> LISTA DE CLIENTES");
					clientRepository.readAll();
					break;
				case 3:
					System.out.println();
					System.out.println(">>> RELATORIO DE CLIENTES");
					//clientRepository.readAll();
					break;
				default:
					System.out.println();
					System.out.println("[ERROR]: Escolha uma opção válida do menu de opções");
					break;
			}

			menu.printPeopleMenu();

			option = scanner.nextInt();
		}
	}

	public void storeOptions() {
		GameSinglePlayerRepositoryFile singlePlayer = new GameSinglePlayerRepositoryFile();
		GameMultiPlayerRepositoryFile multiPlayer = new GameMultiPlayerRepositoryFile();

		menu.printStoreMenu();

		int option = scanner.nextInt();

		while (option != 0) {
			switch (option) {
				case 1:
					System.out.println("\n\t CADASTRAR JOGO");
					formGame();
					break;
				case 2:
					System.out.println("\t LISTA DE JOGOS");
					singlePlayer.readAll();
					multiPlayer.readAll();
					break;
				case 3:
					System.out.println("\t LISTA DE JOGOS POR GENÊRO");

					System.out.print("Genêro do jogo: ");
					String genre = scanner.next();

					singlePlayer.filterGender(genre);
					multiPlayer.filterGender(genre);
					break;
				case 4:
					System.out.println("\t LISTA DE JOGOS POR ANO");

					System.out.print("Ano do jogo: ");
					String releaseYear = scanner.next();

					singlePlayer.filterRelease(releaseYear);
					multiPlayer.filterRelease(releaseYear);
					break;
				case 5:
					System.out.println("\t LISTA DE JOGOS POR VALOR");

					System.out.print("Insira o valor máximo do jogo: ");
					float price = scanner.nextFloat();

					singlePlayer.filterPrice(price);
					multiPlayer.filterPrice(price);
					break;
				default:
					System.out.println("\n\t Até mais!");
					break;
			}

			menu.printStoreMenu();

			option = scanner.nextInt();
		}
	}

	private void formPeople(Scanner scanner) {
		try {
			System.out.print("Digite o nome do cliente: ");
			String name = scanner.next();

			System.out.print("Digite o documento do cliente: ");
			String document = scanner.next();

			ClientRepositoryFile clientRepository = new ClientRepositoryFile();

			Client client = new Client(name, document);

			clientRepository.create(client);
		} catch (Exception e) {
			System.out.println("[ERROR]: Ao inserir valores " + e.getMessage());
		}
	}

	private void formGame() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Digite o nome do jogo: ");
			String name = scanner.next();

			System.out.print("Digite o ano do jogo: ");
			String releaseYear = scanner.next();

			System.out.print("Digite o genêro do jogo: ");
			String genre = scanner.next();

			System.out.print("Tipo do jogo, digite (1) para SinglePlayer e (2) para MultiPlayer: ");
			int type = scanner.nextInt();

			System.out.print("Digite o preço do jogo: ");
			float price = scanner.nextFloat();

			if (type == 2) {
				System.out.print("Máximo de jogadores: ");
				int maxPlayers = scanner.nextInt();

				GameMultiPlayerRepositoryFile multiPlayerRepository = new GameMultiPlayerRepositoryFile();
				GameMultiplayer gameMultiPlayer = new GameMultiplayer(name, price, releaseYear, genre, maxPlayers);

				multiPlayerRepository.create(gameMultiPlayer);
			} else {
				GameSinglePlayerRepositoryFile singlePlayerRepository = new GameSinglePlayerRepositoryFile();
				GameSinglePlayer singlePlayer = new GameSinglePlayer(name, price, releaseYear, genre);

				singlePlayerRepository.create(singlePlayer);
			}

		} catch (Exception e) {
			System.out.println("[ERROR]: Ao inserir valores " + e.getMessage());
		}
	}

	public void printMainMenu() {
		menu.printStartMenu();

		int option = scanner.nextInt();

		while (option != 0) {
			switch (option) {
				case 1:
					peopleOptions();
					break;
				case 2:
					storeOptions();
					break;
				default:
					System.out.println("Opção inválida.");
			}

			menu.printStartMenu();
			option = scanner.nextInt();
		}
	}
}
