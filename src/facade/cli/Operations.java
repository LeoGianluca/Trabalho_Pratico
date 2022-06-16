package facade.cli;

import java.util.Scanner;

import model.Client;
import repository.ClientRepositoryFile;

public class Operations {
    public static void peopleMenu() {
        System.out.println("MENU DE CLIENTES");
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Listar clientes");
        System.out.println("3 - Relatório de consumo do cliente");
        System.out.println("0 - Voltar ao menu anterior");
        System.out.print("Escolha: ");
    }

    public static void storeMenu() {
        System.out.println("MENU DA LOJA");
        System.out.println("1 - Cadastrar produto");
        System.out.println("2 - Listar produtos");
        System.out.println("0 - Voltar ao menu anterior");
        System.out.print("Escolha: ");
    }

    public static void peopleOptions() {
        ClientRepositoryFile client = new ClientRepositoryFile();

        try (Scanner read = new Scanner(System.in)) {
            int option;

            do {
                peopleMenu();
                option = read.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("\t CADASTRAR CLIENTE");
                        formPeople();
                        break;
                    case 2:
                        System.out.println("\t LISTA DE CLIENTES");
                        client.readAll();
                        break;
                    default:
                        break;
                }
            } while (option != 0);
        } catch (Exception e) {
            System.out.println("[ERROR]: " + e.getMessage());
        }
    }

    private static void formPeople() throws Exception {
        try (Scanner read = new Scanner(System.in)){
            System.out.print("Digite o nome do cliente: ");
            String name = read.nextLine();

            System.out.print("Digite o documento do cliente: ");
            String document = read.nextLine();

            ClientRepositoryFile clientRepository = new ClientRepositoryFile();

            Client client = new Client(name, document);

            clientRepository.create(client);
        } catch (Exception e) {
            System.out.println("[ERROR]: " + e.getMessage());
        }
    }
}
