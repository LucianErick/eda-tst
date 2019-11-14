package TST;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {

        Integer[] array = new Integer[] {6, 41, 32, 7, 26, 4, 37, 49,
                11, 18, 36};
        System.out.println(Arrays.toString(array));
        countingSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void countingSort(Integer[] array, int leftIndex, int rightIndex) {

    // Descobrindo o maior elemento da sequencia.

        int maiorElemento = 0;
        for (int i = leftIndex; i < rightIndex; i++) {
            if (array[i] > maiorElemento) {
                maiorElemento = array[i];
            }
        }

        int[] auxiliar = new int[maiorElemento];

        // Registrando a frequencia com que um elemento aparece na sequencia.
        for (int i = leftIndex; i < array.length; i++) {
            auxiliar[array[i] - 1] += 1;
        }

        // Fazendo a soma cumulativa no array auxiliar.
        for (int i = 1; i < auxiliar.length; i++) {
            auxiliar[i] += auxiliar[i - 1];
        }

        // Colocando os elementos em ordem, a partir da análise da cumulativa.
        Integer[] arrayOrdenado = new Integer[array.length];
        for (int i = rightIndex; i >= leftIndex; i--) {
            arrayOrdenado[auxiliar[array[i] - 1] - 1] = array[i];
            auxiliar[array[i] - 1] -= 1;
        }

        for (int i = 0; i <= rightIndex; i++) {
            array[i] = arrayOrdenado[i];
        }
    }
}
