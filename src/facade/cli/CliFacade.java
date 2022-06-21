package facade.cli;

import helpers.Menu;
import model.Client;
import repository.ClientRepositoryFile;

import java.util.Scanner;

public class CliFacade {
    Menu menu = new Menu();

    public static void peopleOptions() {
        ClientRepositoryFile client = new ClientRepositoryFile();

        Menu menu = new Menu();

        try (Scanner readOperations = new Scanner(System.in)) {
            int option;

            do {
                menu.printPeopleMenu();

                option = readOperations.nextInt();

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
                        System.out.println("\t Até mais!");
                        break;
                }
            } while (option != 0);
        } catch (Exception e) {
            System.out.println("[ERROR]: Escolha de opções " + e);
        }
    }

    private static void formPeople() {
        try (Scanner readFormPeople = new Scanner(System.in)) {
            System.out.print("Digite o nome do cliente: ");
            String name = readFormPeople.nextLine();

            System.out.print("Digite o documento do cliente: ");
            String document = readFormPeople.nextLine();

            ClientRepositoryFile clientRepository = new ClientRepositoryFile();

            Client client = new Client(name, document);

            clientRepository.create(client);
        } catch (Exception e) {
            System.out.println("[ERROR]: Ao inserir valores " + e.getMessage());
        }
    }

    public void run() {
        int option;

        try (Scanner readStart = new Scanner(System.in)) {
            menu.printStartMenu();

            option = readStart.nextInt();

            switch (option) {
                case 0:
                    System.out.println("\nPrograma finalizado, até mais!");
                    break;
                case 1:
                    peopleOptions();
                    break;
                case 2:
                    //TODO IMPLEMENTAR DADOS DA LOJA
                    //Operations.storeOptions();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } catch (Exception e) {
            System.out.println("[ERROR]: Menu inicial " + e.getMessage());
        }
    }
}
