package facade.cli;

import helpers.Menu;
import model.Client;
import repository.ClientRepositoryFile;
import repository.GameSinglePlayerRepositoryFile;

import java.util.Scanner;

public class CliFacade {
    Menu menu = new Menu();

    public static void peopleOptions() {
        ClientRepositoryFile client = new ClientRepositoryFile();

        Menu menu = new Menu();

        try (Scanner readOperations = new Scanner(System.in)) {
            menu.printPeopleMenu();

            int option = readOperations.nextInt();

            switch (option) {
                case 1:
                    System.out.println("\n\t CADASTRAR CLIENTE");
                    formPeople();
                    break;
                case 2:
                    System.out.println("\n\t LISTA DE CLIENTES");
                    client.readAll();
                    break;
                default:
                    System.out.println("\n\t Até mais!");
                    break;
            }
        } catch (Exception e) {
            System.out.println("[ERROR]: Escolha de opções " + e);
        }

    }

    public static void storeOptions() {
        GameSinglePlayerRepositoryFile singlePlayer = new GameSinglePlayerRepositoryFile();

        Menu menu = new Menu();

        while1:
        while (true) {
            try (Scanner readOperations = new Scanner(System.in)) {
                int option;

                menu.printStoreMenu();

                option = readOperations.nextInt();

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
                        break while1;
                }

            } catch (Exception e) {
                System.out.println("[ERROR]: Escolha de opções " + e);
            }
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

    private static void formGame() {
        try (Scanner readFormStore = new Scanner(System.in)) {
            System.out.print("Digite o nome do jogo: ");
            String name = readFormStore.nextLine();

            System.out.print("Digite o ano do jogo: ");
            String releaseYear = readFormStore.nextLine();

            System.out.print("Digite o genêro do jogo: ");
            String genre = readFormStore.nextLine();

            System.out.print("Tipo do jogo, digite (1) para SinglePlayer e (2) para MultiPlayer: ");
            String type = readFormStore.nextLine();


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
                    storeOptions();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } catch (Exception e) {
            System.out.println("[ERROR]: Menu inicial " + e.getMessage());
        }
    }
}
