package TST;

import java.util.Arrays;
import java.util.Scanner;

public class MergePassoaPasso {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] listaString = sc.nextLine().split(" ");

        int[] arrayInteiros = new int[listaString.length];
        for (int i = 0; i < arrayInteiros.length; i++) {
            arrayInteiros[i] = Integer.parseInt(listaString[i]);
        }
        mergeSort(arrayInteiros, 0, arrayInteiros.length - 1);
        System.out.println(Arrays.toString(arrayInteiros));
    }

    private static void mergeSort(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int mid = (leftIndex + rightIndex) / 2;
            mergeSort(array, leftIndex, mid);
            System.out.println(Arrays.toString(array));

            mergeSort(array, mid + 1, rightIndex);

            merge(array, leftIndex, mid, rightIndex);
        }
    }

    private static void merge(int[] array, int leftIndex, int mid, int rightIndex) {
        int[] auxliar = new int[array.length];
        for (int i = 0; i <= rightIndex; i++) {
            auxliar[i] = array[i];
        }

        int i = leftIndex;
        int j = mid + 1;
        int k = leftIndex;

        while (i <= mid && j <= rightIndex) {
            if (auxliar[i] < auxliar[j]) {
                array[k] = auxliar[i];
                i++;
            } else {
                array[k] = auxliar[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            array[k] = auxliar[i];
            i++;
            k++;
        }
        while (j <= rightIndex) {
            array[k] = auxliar[j];
            j++;
            k++;
        }
    }
}
