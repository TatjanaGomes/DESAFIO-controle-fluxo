import java.util.InputMismatchException;
import java.util.Scanner;

class ParametrosInvalidosException extends Exception {
    public ParametrosInvalidosException(String message) {
        super(message);
    }
}
public class Contador {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        int paramOne = getInputNumber("Digite o primeiro parâmetro:", terminal);
        int paramTwo = getInputNumber("Digite o segundo parâmetro:", terminal);

        try {
            count(paramOne, paramTwo);
        } catch (ParametrosInvalidosException exception) {
            System.out.println(exception.getMessage());
        }
    }

    static int getInputNumber(String message, Scanner scanner) {
        int number;
        while (true) {
            try {
                System.out.println(message);
                number = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.next(); 
            }
        }
        return number;
    }

    static void count(int paramOne, int paramTwo) throws ParametrosInvalidosException {
        if (paramOne > paramTwo) {
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro");
        }

        int count = paramTwo - paramOne;
        for (int i = 1; i < count + 1; i++) {
            System.out.println("Imprimindo o número " + i);
        }

        System.out.println("Total de iterações entre " + paramOne + " e " + paramTwo + " foi de: " + count);
    }
}