package helpers;

public class Menu {
    public void startMenu() {
        System.out.println("Menu Inícial");
        System.out.println("1 - Opções de cliente");
        System.out.println("2 - Opções da loja");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }

    public void peopleMenu() {
        System.out.println("MENU DE CLIENTES");
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Listar clientes");
        System.out.println("3 - Relatório de consumo do cliente");
        System.out.println("0 - Voltar ao menu anterior");
        System.out.print("Escolha: ");
    }

    public void storeMenu() {
        System.out.println("MENU DA LOJA");
        System.out.println("1 - Cadastrar jogo");
        System.out.println("2 - Listar jogos");
        System.out.println("0 - Voltar ao menu anterior");
        System.out.print("Escolha: ");
    }
}