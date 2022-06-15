import java.util.Scanner;

public class Operations {
    public static void peopleMenu() {
        System.out.println("Menu de Clientes");
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Listar clientes");
        System.out.println("0 - Voltar ao menu anterior");
        System.out.print("Escolha: ");
    }

    public static void peopleOptions() {
        try (Scanner read = new Scanner(System.in)) {
            int option;

            peopleMenu();
            option = read.nextInt();

            do {
                switch (option) {
                    case 1:
                        System.out.println("Cadastrar cliente");
                        break;
                    case 2:
                        System.out.println("Listar clientes");
                        People.readAllPeople();
                        break;
                    default:
                        break;
                }
            } while (option != 0);
        }
    }
}
