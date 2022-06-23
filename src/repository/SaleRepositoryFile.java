package repository;

import helpers.Archive;
import model.GameMultiplayer;
import model.GameSinglePlayer;
import model.Sale;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaleRepositoryFile implements SaleRepository {
	private static final String PATH = "db/sales.txt";

	private static final String PATH_CLIENT = "db/clients.txt";

	private static final String PATH_SINGLEPLAYER = "db/games_singleplayer.txt";

	private static final String PATH_MULTIPLAYER = "db/games_multiplayer.txt";


	Archive archive = new Archive();

	@Override
	public void create(Sale sale) {
		System.out.println("[INFO]: Registrando o jogo...");

		try {
			archive.writeFile(PATH, sale.getUuid() + ";" + sale.getUuidClient() + ";" + sale.getUuidGame() + "; \n");
		} catch (Exception e) {
			System.out.println("[ERROR]:  Ao registrar compra" + e.getMessage());
		}
	}

	@Override
	public void delete() {
		throw new UnsupportedOperationException("[ERROR]: Não implementado para esta interface");
	}

	@Override
	public void salesForClient(String uuidClient) {
		List<GameSinglePlayer> gamesSingle = new ArrayList<>();
		List<GameMultiplayer> gamesMulti = new ArrayList<>();

		try {
			System.out.println("\t\t COMPRAS REALIZADAS");
			System.out.println("UUID \t\t\t\t | Cliente  \t\t|\t\t Nome \t\t\t | Preço \t Ano \t Genêro");
			System.out.print("-----------------------------------------------------------------------\n");

			for (String linesale : archive.readFile(PATH)) {
				String[] fieldsSale = linesale.split(";");

//				if (fieldsSale[1] == uuidClient) {
//					clientDetails(uuidClient);
//				}

				for (String lineSinglePlayer : archive.readFile(PATH_SINGLEPLAYER)) {
					String[] fieldsSinglePlayer = lineSinglePlayer.split(";");

					GameSinglePlayer singleplayer = new GameSinglePlayer(fieldsSinglePlayer[0], fieldsSinglePlayer[1],
									Float.parseFloat(fieldsSinglePlayer[2]),
									fieldsSinglePlayer[3], fieldsSinglePlayer[4]);

					if (fieldsSale[2] == fieldsSinglePlayer[0]) {

						gamesSingle.add(singleplayer);

						System.out.println(singleplayer);
					}
				}

				for (String lineSinglePlayer : archive.readFile(PATH_MULTIPLAYER)) {
					String[] fieldsSinglePlayer = lineSinglePlayer.split(";");

					GameMultiplayer multiplayer = new GameMultiplayer(fieldsSinglePlayer[0], fieldsSinglePlayer[1],
									Float.parseFloat(fieldsSinglePlayer[2]), fieldsSinglePlayer[3], fieldsSinglePlayer[4],
									Integer.parseInt(fieldsSinglePlayer[5]));

					gamesMulti.add(multiplayer);

					System.out.println(multiplayer);

					if (fieldsSale[2] == fieldsSinglePlayer[0]) {

						gamesMulti.add(multiplayer);

						System.out.println(multiplayer);
					}
				}
			}
			System.out.print("-----------------------------------------------------------------------\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void clientDetails(String uuidClient) {
		try {
			for (String lineClient : archive.readFile(PATH_CLIENT)) {
				String[] fieldsClient = lineClient.split(";");

				if (uuidClient == fieldsClient[0])
					System.out.print("\n CLIENTE: " + fieldsClient[1]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
