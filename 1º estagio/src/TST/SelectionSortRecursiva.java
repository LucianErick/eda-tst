package TST;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSortRecursiva {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] listaEntrada = input.nextLine().split(" ");

        int[] vetorInteiros = new int[listaEntrada.length];
        for (int i = 0; i < listaEntrada.length; i++) {
            vetorInteiros[i] = Integer.parseInt(listaEntrada[i]);
        }

        selectionSort(vetorInteiros, 0);
    }

    private static void selectionSort(int[] vetor, int inicio) {
        int fim = vetor.length - 1;
        if (inicio == fim) {
            return;
        }
        int indiceMenor = inicio;
        for (int indice = inicio + 1; indice < vetor.length; indice++) {
            if (vetor[indice] < vetor[indiceMenor]) {
                indiceMenor = indice;
            }
        }
        int auxiliar = vetor[inicio];
        vetor[inicio] = vetor[indiceMenor];
        vetor[indiceMenor] = auxiliar;
        System.out.println(Arrays.toString(vetor));
        selectionSort(vetor, inicio + 1);
    }
}