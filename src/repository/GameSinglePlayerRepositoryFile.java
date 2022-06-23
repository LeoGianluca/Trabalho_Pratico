package repository;

import helpers.Archive;

import model.GameSinglePlayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameSinglePlayerRepositoryFile implements GameSinglePlayerRepository {
	private static final String PATH = "db/games_singleplayer.txt";
	Archive archive = new Archive();

	@Override
	public void create(GameSinglePlayer gameSinglePlayer) {
		System.out.println("[INFO]: Registrando o jogo...");

		try {
			archive.writeFile(PATH, gameSinglePlayer.getUuid() + ";" + gameSinglePlayer.getName() + ";" + gameSinglePlayer.getPrice() + ";"
							+ gameSinglePlayer.getReleaseYear() + ";" + gameSinglePlayer.getGenre() + "; \n");
		} catch (Exception e) {
			System.out.println("[ERROR]:  Ao cadastrar o jogo singlePlayer" + e.getMessage());
		}
	}

	@Override
	public void delete() {
		throw new UnsupportedOperationException("[ERROR]: Não implementado para esta interface");
	}


	@Override
	public void readAll() {
		List<GameSinglePlayer> games = new ArrayList<>();

		try {
			System.out.println("\t\t JOGOS SINGLE-PLAYER");
			System.out.println("UUID \t\t\t\t     | Nome \t\t\t | Preço \t Ano \t Genêro");
			System.out.print("-----------------------------------------------------------------------\n");

			for (String line : archive.readFile(PATH)) {
				String[] fields = line.split(";");

				GameSinglePlayer singleplayer = new GameSinglePlayer(fields[0], fields[1], Float.parseFloat(fields[2]), fields[3],
								fields[4]);

				games.add(singleplayer);

				System.out.println(singleplayer);
			}

			System.out.print("-----------------------------------------------------------------------\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void filterGender(String genre) {
		List<GameSinglePlayer> games = new ArrayList<>();

		try {
			System.out.println("\n\t\t JOGOS SINGLE-PLAYER DE: " + genre);
			System.out.println("UUID \t\t\t\t     | Nome \t\t\t | Preço \t Ano \t Genêro");
			System.out.print("-----------------------------------------------------------------------\n");

			for (String line : archive.readFile(PATH)) {
				String[] fields = line.split(";");

				GameSinglePlayer singleplayer = new GameSinglePlayer(fields[0], fields[1], Float.parseFloat(fields[2]), fields[3],
								fields[4]);

				if (fields[4].contains(genre)) {
					games.add(singleplayer);

					System.out.println(singleplayer);
				}
			}

			System.out.print("-----------------------------------------------------------------------\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void filterPrice(float price) {
		List<GameSinglePlayer> games = new ArrayList<>();

		try {
			System.out.println("\n\t\t JOGOS SINGLE-PLAYER PREÇO ABAIXO DE R$ " + price);
			System.out.println("UUID \t\t\t\t     | Nome \t\t\t | Preço \t Ano \t Genêro");
			System.out.print("-----------------------------------------------------------------------\n");

			for (String line : archive.readFile(PATH)) {
				String[] fields = line.split(";");

				GameSinglePlayer singleplayer = new GameSinglePlayer(fields[0], fields[1], Float.parseFloat(fields[2]), fields[3],
								fields[4]);


				if (Float.parseFloat(fields[2]) < price) {
					games.add(singleplayer);

					System.out.println(singleplayer);
				}
			}

			System.out.print("-----------------------------------------------------------------------\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void filterRelease(String release) {
		List<GameSinglePlayer> games = new ArrayList<>();

		try {
			System.out.println("\n\t\t JOGOS SINGLE-PLAYER DO ANO DE: " + release);
			System.out.println("UUID \t\t\t\t     | Nome \t\t\t | Preço \t Ano \t Genêro");
			System.out.print("-----------------------------------------------------------------------\n");

			for (String line : archive.readFile(PATH)) {
				String[] fields = line.split(";");

				GameSinglePlayer singleplayer = new GameSinglePlayer(fields[0], fields[1], Float.parseFloat(fields[2]), fields[3],
								fields[4]);

				if (fields[3].contains(release)) {
					games.add(singleplayer);

					System.out.println(singleplayer);
				}
			}

			System.out.print("-----------------------------------------------------------------------\n");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
