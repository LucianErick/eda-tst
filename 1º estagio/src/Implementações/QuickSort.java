package Implementações;

import java.util.Arrays;
import java.util.Random;

public class QuickSort implements Sorting {

    @Override
    public void sort(Object[] element) {
        int[] array = new int[element.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) element[i];
        }
        quickSort(array, 0, array.length - 1);
    }

    public void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = partition(array, left, right);
        quickSort(array, left, mid - 1);
        quickSort(array, mid + 1, right);
    }

    private int partition(int[] array, int left, int right) {
        int i = left + 1;
        int j = right;
        int p = array[left];
        while (i <= j) {
            if (array[i] <= p) {
                i++;
            } else if (array[j] > p) {
                j--;
            } else {
                array = swap(array, i, j);
            }
        }
        array = swap(array, left, j);
        return j;
    }

    private int[] swap(int[] array, int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
        return array;
    }

    public static void main(String[] args) {
        Random random = new Random();
        QuickSort quickSort = new QuickSort();
        int[] array = new int[random.nextInt(35)];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1500);
        }
        System.out.println(Arrays.toString(array));
        quickSort.quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}

