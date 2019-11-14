package TST;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] v = new int[]{9,3,5,7,2,1,4,8};
        System.out.println("Vetor Original: \n" + Arrays.toString(v) + "\n");
        mergeSort(v, 0, v.length - 1);
        System.out.println("Vetor Ordenado: \n" + Arrays.toString(v));
    }

    public static void mergeSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
        int meio = (inicio + fim) / 2;
        mergeSort(vetor, inicio, meio);
        mergeSort(vetor, meio + 1, fim);

        merge(vetor, inicio, meio, fim);
    }
}

    public static void merge(int[] vetor, int inicio, int meio, int fim) {
        int[] aux = new int[vetor.length];
        for (int i = inicio; i <= fim; i++) { // Copiando os elementos do vetor original
            aux[i] = vetor[i];                // para um vetor auxiliar.
        }

        int i = inicio;
        int j = meio + 1;
        int k = inicio;

        while ((i <= meio) && (j <= fim)) {
            if(aux[i] < aux[j]) {
                vetor[k] = aux[i];
                i++;
            } else {
                vetor[k] = aux[j];
                j++;
            }
            k++;
        }

        // Se os valores da primeira metade não foram todos usados
        // então, faz-se o append de todos os elemtos restantes.

        while (i <= meio) {
            vetor[k] = aux[i];
            k++;
            i++;
        }

        // Se os valores da segunda metade não foram todos usados
        // então, faz-se o append de todos os elementos restantes.

        while (j <= fim) {
            vetor[k] = aux[j];
            k++;
            j++;
        }
    }
}