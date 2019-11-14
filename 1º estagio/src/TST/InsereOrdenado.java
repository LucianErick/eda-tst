package TST;

import java.util.Arrays;
import java.util.Scanner;

public class InsereOrdenado {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] listaEntrada = input.nextLine().split(" ");

        int[] vetorInteiros = new int[listaEntrada.length];
        for (int i = 0; i < listaEntrada.length; i++) {
            vetorInteiros[i] = Integer.parseInt(listaEntrada[i]);
        }

        insereOrdenado(vetorInteiros);
        System.out.println(Arrays.toString(vetorInteiros));

    }

    private static void insereOrdenado(int[] vetor) {
        int indiceUltimo = vetor.length - 1;
        int valorUltimo = vetor[indiceUltimo];
        int indiceAtual = indiceUltimo;

        while ((indiceAtual > 0) && (vetor[indiceAtual - 1] > valorUltimo)) {
            vetor[indiceAtual] = vetor[indiceAtual - 1];
            indiceAtual--;
        }
        vetor[indiceAtual] = valorUltimo;
        }
    }


