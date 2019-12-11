package Implementações;


import java.util.Arrays;
import java.util.Random;

public class MergeSort implements Sorting {
    @Override
    public void sort(Object[] element) {
        int[] array = new int[element.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) element[i];
        }
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int begin, int end) {
        if (begin < end) {
            int mid = (begin + end) / 2;
            mergeSort(array, begin, mid);
            mergeSort(array, mid + 1, end);

            merge(array, begin, mid, end);
        }
    }

    private void merge(int[] array, int begin, int mid, int end) {
        // Criando um array auxiliar e copiando os elementos.
        int[] aux = new int[array.length];
        for (int i = begin; i <= end; i++) {
            aux[i] = array[i];
        }
        int i = begin;
        int j = mid + 1;
        int k = begin;

        while (i <= mid && j <= end) {
            if (aux[i] < aux[j]) {
                array[k] = aux[i];
                i++;
            } else {
                array[k] = aux[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            array[k] = aux[i];
            k++;
            i++;
        }

        while (j <= mid) {
            array[k] = aux[j];
            k++;
            j++;
        }
    }

    public static void main(String[] args) {

        Random random = new Random();
        MergeSort mergeSort = new MergeSort();
        int[] array = new int[random.nextInt(35)];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1500);
        }
        System.out.println(Arrays.toString(array));
        mergeSort.mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
