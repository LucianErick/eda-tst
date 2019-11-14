package TST;

import java.util.Scanner;

public class EhPrimo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numero = sc.nextInt();
        System.out.print(ehPrimo(numero));
    }

    private static boolean ehPrimo(int numero) {
        for (int i = 2; i < numero / 2; i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}

