package repository;
import java.util.ArrayList;
import java.util.List;

import model.Client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ClientRepositoryFile implements ClientRepository {
    private static final String PATH = "clients.txt";

    @Override
    public void create(Client client) {
        System.out.println("[INFO]: Registrando pessoa...");

        try {
            writeFile(PATH, client.getUuid() + ";" + client.getDocument() + ";" + client.getName() + "\n");
        } catch (Exception e) {
            System.out.println("[ERROR]: " + e.getMessage());
        }
    }

    @Override
    public void delete(String uuid) {
        throw new UnsupportedOperationException("[ERROR]: Não implementado para esta interface");
    }

    @Override
    public List<Client> readAll() {
        List <Client> clients = new ArrayList<Client>();

        try {
            String ligne;
            InputStream flux = new FileInputStream("clients.txt");
            InputStreamReader lecture = new InputStreamReader(flux);
            BufferedReader buff = new BufferedReader(lecture);

            ligne = buff.readLine();
            System.out.println("UUID \t\t\t\t     | Documento \t | Nome");
            System.out.print("-----------------------------------------------------------------------\n");

            while (ligne != null) {
                String[] fields = ligne.split(";");

                Client client = new Client(fields[0], fields[1], fields[2]);

                clients.add(client);

                System.out.println(client);
                ligne = buff.readLine();
            }
            System.out.print("-----------------------------------------------------------------------\n");
            
        } catch (Exception e) { // tratando quando o arquivo nao existe
            System.err.println("[ERROR]: " + e.getMessage());
        }

        return clients;
    }

    private static boolean writeFile(String path, String line) throws Exception {
        try {
            File fFile = null;
            fFile = new File(PATH);
            FileWriter fwFile = null;

            if (fFile.exists()) {
                fwFile = new FileWriter(fFile, true);
            } else {
                fwFile = new FileWriter(fFile);
            }

            BufferedWriter bw = new BufferedWriter(fwFile);

            bw.write(line + " \n");

            bw.close();
            fwFile.close();

            System.out.println("[INFO]: Registro adicionado com sucesso...");

            return true;
        } catch (Exception e) {
            System.out.println("[ERROR]: Falha ao gravar os dados. \n Detalhes: \n" + e.getMessage());

            return false;
        }
    }
}