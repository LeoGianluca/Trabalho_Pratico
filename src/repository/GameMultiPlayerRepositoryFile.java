package repository;

import helpers.Archive;

import model.GameMultiplayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameMultiPlayerRepositoryFile implements GameMultiPlayerRepository {
	private static final String PATH = "db/games_multiplayer.txt";
	Archive archive = new Archive();

	@Override
	public void create(GameMultiplayer gameMultiPlayer) {
		System.out.println("[INFO]: Registrando o jogo...");

		try {
			archive.writeFile(PATH, gameMultiPlayer.getUuid() + ";" + gameMultiPlayer.getName() + ";" + gameMultiPlayer.getPrice() + ";" + gameMultiPlayer.getReleaseYear() + ";" + gameMultiPlayer.getGenre() + ";" + gameMultiPlayer.getMaxPlayers() + "; \n");
		} catch (Exception e) {
			System.out.println("[ERROR]:  Ao cadastrar o jogo multiPlayer" + e.getMessage());
		}
	}

	@Override
	public void delete() {
		throw new UnsupportedOperationException("[ERROR]: Não implementado para esta interface");
	}


	@Override
	public void readAll() {
		List<GameMultiplayer> games = new ArrayList<>();

		try {
			System.out.println("\t\t JOGOS MULTI-PLAYER");
			System.out.println("UUID \t\t\t\t     | Nome \t\t\t | Preço \t Ano \t Genêro \t Num. Jogadores");
			System.out.print("-----------------------------------------------------------------------\n");

			for (String line : archive.readFile(PATH)) {
				String[] fields = line.split(";");

				GameMultiplayer multiplayer = new GameMultiplayer(fields[0], fields[1], Float.parseFloat(fields[2]), fields[3], fields[4], Integer.parseInt(fields[5]));

				games.add(multiplayer);

				System.out.println(multiplayer);
			}

			System.out.print("-----------------------------------------------------------------------\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void filterGender(String genre) {
		List<GameMultiplayer> games = new ArrayList<>();

		try {
			System.out.println("\n\t\t JOGOS MULTI-PLAYER DE: " + genre);
			System.out.println("UUID \t\t\t\t     | Nome \t\t\t | Preço \t Ano \t Genêro \t Num. Jogadores");
			System.out.print("-----------------------------------------------------------------------\n");

			for (String line : archive.readFile(PATH)) {
				String[] fields = line.split(";");

				GameMultiplayer multiplayer = new GameMultiplayer(fields[0], fields[1], Float.parseFloat(fields[2]), fields[3], fields[4], Integer.parseInt(fields[5]));

				if (fields[4].contains(genre)) {
					games.add(multiplayer);

					System.out.println(multiplayer);
				}
			}

			System.out.print("-----------------------------------------------------------------------\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void filterPrice(float price) {
		List<GameMultiplayer> games = new ArrayList<>();

		try {
			System.out.println("\n\t\t JOGOS MULTI-PLAYER PREÇO ABAIXO DE R$ " + price);
			System.out.println("UUID \t\t\t\t     | Nome \t\t\t | Preço \t Ano \t Genêro \t Num. Jogadores");
			System.out.print("-----------------------------------------------------------------------\n");

			for (String line : archive.readFile(PATH)) {
				String[] fields = line.split(";");

				GameMultiplayer multiplayer = new GameMultiplayer(fields[0], fields[1], Float.parseFloat(fields[2]), fields[3], fields[4], Integer.parseInt(fields[5]));

				if (Float.parseFloat(fields[2]) < price) {
					games.add(multiplayer);

					System.out.println(multiplayer);
				}
			}

			System.out.print("-----------------------------------------------------------------------\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void filterRelease(String release) {
		List<GameMultiplayer> games = new ArrayList<>();

		try {
			System.out.println("\n\t\t JOGOS MULTI-PLAYER DO ANO DE: " + release);
			System.out.println("UUID \t\t\t\t     | Nome \t\t\t | Preço \t Ano \t Genêro \t Num. Jogadores");
			System.out.print("-----------------------------------------------------------------------\n");

			for (String line : archive.readFile(PATH)) {
				String[] fields = line.split(";");

				GameMultiplayer multiplayer = new GameMultiplayer(fields[0], fields[1], Float.parseFloat(fields[2]), fields[3], fields[4], Integer.parseInt(fields[5]));

				if (fields[3].contains(release)) {
					games.add(multiplayer);

					System.out.println(multiplayer);
				}
			}

			System.out.print("-----------------------------------------------------------------------\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
