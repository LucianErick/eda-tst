package TST;

import java.util.Scanner;

class TriploMaisUm {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        System.out.println(maiorSequencia(num1, num2));
    }

    private static int maiorSequencia(int num1, int num2) {
        int maior = 0;
        for (int numero = num1 + 1; numero < num2; numero++) {
            int tamanho = 0;
            while (numero > 1) {
                if ((numero % 2) == 0) {
                    numero = numero / 2;
                } else {
                    numero = (numero * 3) + 1;
                }
                tamanho++;
            }
            if (tamanho > maior) { maior = tamanho; }
            tamanho = 0;
        }
        return maior;
    }
}
