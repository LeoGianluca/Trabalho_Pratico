package facade.cli;

import helpers.Menu;
import model.Client;
import model.GameMultiplayer;
import model.GameSinglePlayer;
import model.Sale;
import repository.ClientRepositoryFile;
import repository.GameMultiPlayerRepositoryFile;
import repository.GameSinglePlayerRepositoryFile;
import repository.SaleRepositoryFile;

import java.util.Scanner;

public class CliFacade {
	private final Menu menu = new Menu();

	static Scanner scanner = new Scanner(System.in);

	ClientRepositoryFile clientRepository = new ClientRepositoryFile();

	GameSinglePlayerRepositoryFile gameSinglePlayerFile = new GameSinglePlayerRepositoryFile();

	GameMultiPlayerRepositoryFile gameMultiPlayerFile = new GameMultiPlayerRepositoryFile();

	SaleRepositoryFile saleRepositoryFile = new SaleRepositoryFile();

	public void peopleOptions() {

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
		menu.printStoreMenu();

		int option = scanner.nextInt();

		while (option != 0) {
			switch (option) {
				case 1:
					System.out.println("\n\t CADASTRAR JOGO");
					formGame(scanner);
					break;
				case 2:
					System.out.println("\t LISTA DE JOGOS");
					gameSinglePlayerFile.readAll();
					gameMultiPlayerFile.readAll();
					break;
				case 3:
					System.out.println("\t LISTA DE JOGOS POR GENÊRO");

					System.out.print("Genêro do jogo: ");
					String genre = scanner.next();

					gameSinglePlayerFile.filterGender(genre);
					gameMultiPlayerFile.filterGender(genre);
					break;
				case 4:
					System.out.println("\t LISTA DE JOGOS POR ANO");

					System.out.print("Ano do jogo: ");
					String releaseYear = scanner.next();

					gameSinglePlayerFile.filterRelease(releaseYear);
					gameMultiPlayerFile.filterRelease(releaseYear);
					break;
				case 5:
					System.out.println("\t LISTA DE JOGOS POR VALOR");

					System.out.print("Insira o valor máximo do jogo: ");
					float price = scanner.nextFloat();

					gameSinglePlayerFile.filterPrice(price);
					gameMultiPlayerFile.filterPrice(price);
					break;
				case 6:
					System.out.println("\t REALIZAR COMPRA DE JOGOS");
					System.out.println("\t OBS: Para comprar copie e cole o UUID do cliente e o UUID do jogo");

					clientRepository.readAll();

					gameSinglePlayerFile.readAll();
					gameMultiPlayerFile.readAll();

					formSale(scanner);

					break;
				case 7:
					System.out.println("\t BUSCAR JOGOS DE UM CLIENTE");
					System.out.println("\t OBS: Para buscar copie e cole o UUID do cliente");

					clientRepository.readAll();

					System.out.print("UUID do cliente: ");
					String uuidClient = scanner.next();

					saleRepositoryFile.salesForClient(uuidClient);
					break;
				default:
					System.out.println("\n\t Até mais!");
					break;
			}

			menu.printStoreMenu();

			option = scanner.nextInt();
		}
	}

	private void formSale(Scanner scanner) {
		try {
			System.out.print("UUID do cliente: ");
			String uuidClient = scanner.next();

			System.out.print("UUID do cliente: ");
			String uuidGame = scanner.next();

			Sale sale = new Sale(uuidClient, uuidGame);
			saleRepositoryFile.create(sale);

		} catch (Exception e) {
			System.out.println("[ERROR]: Ao inserir valores " + e.getMessage());
		}
	}

	private void formPeople(Scanner scanner) {
		try {
			System.out.print("Digite o nome do cliente: ");
			String name = scanner.next();

			System.out.print("Digite o documento do cliente: ");
			String document = scanner.next();

			Client client = new Client(name, document);

			clientRepository.create(client);
		} catch (Exception e) {
			System.out.println("[ERROR]: Ao inserir valores " + e.getMessage());
		}
	}

	private void formGame(Scanner scanner) {
		try {

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

				GameMultiplayer gameMultiPlayer = new GameMultiplayer(name, price, releaseYear, genre, maxPlayers);

				gameMultiPlayerFile.create(gameMultiPlayer);
			} else {
				GameSinglePlayer singlePlayer = new GameSinglePlayer(name, price, releaseYear, genre);

				gameSinglePlayerFile.create(singlePlayer);
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
