package facade.cli;

import java.util.Scanner;

import helpers.Menu;

public class CliFacade {
    Menu menu = new Menu();

    public void run() {
        int option;

        try (Scanner read = new Scanner(System.in)) {
            do {
                menu.startMenu();
                option = read.nextInt();

                switch (option) {
                    case 1:
                        Operations.peopleOptions();
                        break;
                    case 2:
                        //TODO IMPLEMENTAR DADOS DA LOJA
                        //Operations.storeOptions();
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } while (option != 0);
        } catch (Exception e) {
            System.out.println("[ERROR]: " + e.getMessage());
        }
    }
}
