package helpers;

public class Menu {
    public void printStartMenu() {
        System.out.println();
        System.out.println("=== MENU INICIAL ===");
        System.out.println("1 - Opções de cliente");
        System.out.println("2 - Opções da loja");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }

    public void printPeopleMenu() {
        System.out.println();
        System.out.println("### MENU DE CLIENTES ###");
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Listar clientes");
        System.out.println("0 - Voltar ao menu anterior");
        System.out.print("Escolha: ");
    }

    public void printStoreMenu() {
        System.out.println();
        System.out.println("### MENU DA LOJA ###");
        System.out.println("1 - Cadastrar jogo");
        System.out.println("2 - Listar jogos");
        System.out.println("3 - Listar jogos pelo genêro");
        System.out.println("4 - Listar jogos pelo ano");
        System.out.println("5 - Listar jogos pelo valor");
        System.out.println("6 - Realizar compra");
        System.out.println("7 - Compras de um cliente");
        System.out.println("0 - Voltar ao menu anterior");
        System.out.print("Escolha: ");
    }
}
