package TST;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] listaEntrada = input.nextLine().split(" ");
        int[] arrayInteiros = new int[listaEntrada.length];
        for (int i = 0; i < listaEntrada.length; i++) {
            arrayInteiros[i] = Integer.parseInt(listaEntrada[i]);
        }

        System.out.println(Arrays.toString(arrayInteiros));
        bubbleSort(arrayInteiros);
        System.out.println(Arrays.toString(arrayInteiros));
    }

    private static void bubbleSort(int[] vetor) {
        int aux;
        boolean trocou = false;

        for (int i = 0; i < vetor.length - i; i++) {
            for (int j = 0; j < vetor.length - 1; j++) {
                if (vetor[j + 1] < vetor[j]) {
                    // INICIO DO SWAP
                    aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                    trocou = true;
                    // FIM DO SWAP
                }
            }
            if (!trocou) {
                break;
            }
        }
    }
}

