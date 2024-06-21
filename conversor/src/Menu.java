import java.util.Scanner;

public class Menu {
    private static final String[] MOEDAS = {"USD", "EUR", "GBP", "JPY", "AUD", "CAD", "BRL"};
    private ConversorMoeda conversor;

    public Menu(ConversorMoeda conversor) {
        this.conversor = conversor;
    }

    public void display() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Bem-vindo ao Conversor de Moedas");
            System.out.println("Escolha a moeda de origem:");
            printMoedas();

            int fromIndex = readIndex(scanner);
            Moeda deMoeda = new Moeda(MOEDAS[fromIndex]);

            System.out.println("Escolha a moeda de destino:");
            printMoedas();

            int toIndex = readIndex(scanner);
            Moeda paraMoeda = new Moeda(MOEDAS[toIndex]);

            System.out.println("Digite o valor a ser convertido:");
            double quantia = scanner.nextDouble();

            double conversorQuantia = conversor.coversor(deMoeda, paraMoeda, quantia);
            System.out.println(quantia + " " + deMoeda + " = " + conversorQuantia + " " + paraMoeda);

            System.out.println("Deseja realizar outra conversão? (s/n)");
            String continueChoice = scanner.next();
            if (!continueChoice.equalsIgnoreCase("s")) {
                break;
            }
        }
        scanner.close();
    }

    private void printMoedas() {
        for (int i = 0; i < MOEDAS.length; i++) {
            System.out.println((i + 1) + ". " + MOEDAS[i]);
        }
    }

    private int readIndex(Scanner scanner) {
        int index = -1;
        while (index < 0 || index >= MOEDAS.length) {
            System.out.print("Escolha: ");
            if (scanner.hasNextInt()) {
                index = scanner.nextInt() - 1;
                if (index < 0 || index >= MOEDAS.length) {
                    System.out.println("Índice inválido. Escolha um número entre 1 e " + MOEDAS.length);
                }
            } else {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.next(); // limpa a entrada inválida
            }
        }
        return index;
    }
}

