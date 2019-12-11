package Implementações;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort implements Sorting {
    @Override
    public void sort(Object[] element) {
        int[] array = new int[element.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) element[i];
        }
        insertionSort(array);
    }

    public void insertionSort(int[] vector) {

        for (int j = 1; j < vector.length; j++) {
            int key = vector[j];
            int i = j - 1;
            while (i >= 0 && vector[i] > key) {
                vector[i + 1] = vector[i];
                i--;
            }
            vector[i + 1] = key;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        InsertionSort insertion = new InsertionSort();
        int[] array = new int[random.nextInt(35)];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1500);
        }
        System.out.println(Arrays.toString(array));
        insertion.insertionSort(array);
        System.out.println(Arrays.toString(array));
    }


}
