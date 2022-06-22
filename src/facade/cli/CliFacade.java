package facade.cli;

import helpers.Menu;
import model.Client;
import repository.ClientRepositoryFile;
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

        printMainMenu();
    }

    public void storeOptions() {
        GameSinglePlayerRepositoryFile singlePlayer = new GameSinglePlayerRepositoryFile();

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
                    break;
                case 3:
                    System.out.println("\t LISTA DE JOGOS POR GENÊRO");

                    try (Scanner readFormStore = new Scanner(System.in)) {
                        System.out.print("Genêro do jogo: ");
                        String genre = readFormStore.nextLine();

                        singlePlayer.filterGender(genre);
                    } catch (Exception e) {
                        System.out.println("[ERROR]: Filtrar valores " + e.getMessage());
                    }

                    break;
                case 4:
                    System.out.println("\t LISTA DE JOGOS POR ANO");

                    try (Scanner readFormStore = new Scanner(System.in)) {
                        System.out.print("Ano do jogo: ");
                        String releaseYear = readFormStore.nextLine();

                        singlePlayer.filterRelease(releaseYear);
                    } catch (Exception e) {
                        System.out.println("[ERROR]: Filtrar valores " + e.getMessage());
                    }

                    break;
                case 5:
                    System.out.println("\t LISTA DE JOGOS POR VALOR");

                    try (Scanner readFormStore = new Scanner(System.in)) {
                        System.out.print("Insira o valor máximo do jogo: ");
                        float price = readFormStore.nextFloat();

                        singlePlayer.filterPrice(price);
                    } catch (Exception e) {
                        System.out.println("[ERROR]: Filtrar valores " + e.getMessage());
                    }

                    break;
                default:
                    System.out.println("\n\t Até mais!");
                    break;
            }

            menu.printStoreMenu();

            option = scanner.nextInt();
        }

        printMainMenu();
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
            String name = scanner.nextLine();

            System.out.print("Digite o ano do jogo: ");
            String releaseYear = scanner.nextLine();

            System.out.print("Digite o genêro do jogo: ");
            String genre = scanner.nextLine();

            System.out.print("Tipo do jogo, digite (1) para SinglePlayer e (2) para MultiPlayer: ");
            String type = scanner.nextLine();
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

//              menu.printStartMenu();
//              option = scanner.nextInt();
        }
    }

}
