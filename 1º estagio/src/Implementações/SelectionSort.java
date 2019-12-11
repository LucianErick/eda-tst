package Implementações;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort implements Sorting {
    @Override
    public void sort(Object[] element) {
        int[] array = new int[element.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) element[i];
        }
        selectionSort(array);
    }

    public void selectionSort(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            int index_lower = i;
            for (int j = i + 1; j < vector.length; j++)
                if (vector[j] < vector[index_lower])
                    index_lower = j;
        int aux = vector[i];
        vector[i] = vector[index_lower];
        vector[index_lower] = aux;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        SelectionSort selection = new SelectionSort();
        int[] array = new int[random.nextInt(35)];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1500);
        }
        System.out.println(Arrays.toString(array));
        selection.selectionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
