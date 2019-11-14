package TST;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] vetor = gerar(118);
        System.out.println("O vetor antes de ordenar é: \n" + Arrays.toString(vetor));
        quickSort(vetor, 0, vetor.length - 1);
        System.out.println("O vetor ordenado é: \n" + Arrays.toString(vetor));

    }

    private static int[] gerar(int n) {
        int[] vetor = new int[n];
        Random gerador = new Random();
        for (int i = 0; i < n; i++) {
            vetor[i] = gerador.nextInt(n);
        }
        return vetor;
    }


    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int j = separar(array, left, right);
            quickSort(array, left, j-1);
            quickSort(array, j+1, right);
        }
    }

    private static int separar(int[] array, int left, int right) {
        int i = left + 1;
        int j = right;
        int pivo = array[left];
        while (i<=j) {
            if (array[i] < pivo) i++;
            else if (array[j] > pivo) j--;
            else if (i <= j) {
                trocar(array, i, j);
                i++;
                j--;
            }
        }
        trocar(array, left, j);
        return j;
    }

    private static void trocar(int[] array, int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }
}
