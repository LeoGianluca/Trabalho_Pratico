import java.util.Scanner;

public class Main {
    private static void startMenu() {
        System.out.println("Menu Inícial");
        System.out.println("1 - Login de cliente");
        System.out.println("2 - Login da loja");
        System.out.println("0 - Sair");
    }

    public static void main(String[] args) throws Exception {
        int option;
        try (Scanner read = new Scanner(System.in)) {
            do {
                startMenu();
                option = read.nextInt();

                switch (option) {
                    case 1:
                        Operations.peopleOptions();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
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
