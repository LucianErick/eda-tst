package TST;

import java.util.Scanner;

public class TemRepetido {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] listaEntrada = input.nextLine().split(" ");
        int[] arrayInteiros = new int[listaEntrada.length];
        for (int i = 0; i < listaEntrada.length; i++) {
            arrayInteiros[i] = Integer.parseInt(listaEntrada[i]);
        }

        System.out.print(temRepetido(arrayInteiros));
    }

    private static boolean temRepetido(int[] vetor) {

        for (int i = 0; i < vetor.length - 1; i++) {
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[i] == vetor[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}

