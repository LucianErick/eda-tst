package TST;

import java.util.Arrays;
import java.util.Scanner;

public class TrocaVizinhos {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] listaEntrada = input.nextLine().split(" ");
        int[] arrayInteiros = new int[listaEntrada.length];
        for (int i = 0; i < listaEntrada.length; i++) {
            arrayInteiros[i] = Integer.parseInt(listaEntrada[i]);
        }
        trocaVizinhos(arrayInteiros);
    }

    private static void trocaVizinhos(int[] vetor) {
        int fim; // Variável que define qual a ultima posição a ser acessada no for.
        if (vetor.length % 2 != 0) {
            fim = vetor.length - 2;
        } else {
            fim = vetor.length - 1;
        }

        int aux = 0; // variável auxiliar.
        for (int i = 0; i < fim; i = i + 2) {
            // SWAP == TROCA
            aux = vetor[i];
            vetor[i] = vetor[i + 1];
            vetor[i + 1] = aux;
            // FIM DO SWAP
        }
        System.out.println(Arrays.toString(vetor));
    }
}
