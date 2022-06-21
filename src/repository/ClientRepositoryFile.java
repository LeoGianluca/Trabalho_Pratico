package repository;

import helpers.Archive;
import model.Client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientRepositoryFile implements ClientRepository {
    private static final String PATH = "db/clients.txt";
    final Archive archive = new Archive();

    @Override
    public void create(Client client) {
        System.out.println("[INFO]: Registrando pessoa...");

        try {
            archive.writeFile(PATH, client.getUuid() + ";" + client.getDocument() + ";" + client.getName() + "\n");
        } catch (Exception e) {
            System.out.println("[ERROR]:  Ao cadastrar cliente" + e.getMessage());
        }
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("[ERROR]: Não implementado para esta interface");
    }

    @Override
    public void readAll() {
        List<Client> clients = new ArrayList<>();

        try {
            System.out.println("UUID \t\t\t\t     | Documento \t | Nome");
            System.out.print("-----------------------------------------------------------------------\n");

            for (String line : archive.readFile(PATH)) {
                String[] fields = line.split(";");

                Client client = new Client(fields[0], fields[1], fields[2]);

                clients.add(client);

                System.out.println(client);
            }

            System.out.print("-----------------------------------------------------------------------\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
