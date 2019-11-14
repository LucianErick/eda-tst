package TST;

import java.util.Scanner;

public class BuscaBinaria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arrayString = sc.nextLine().split(" ");
        int[] array = new int[arrayString.length];
        for (int i = 0; i < arrayString.length; i++) {
            array[i] = Integer.parseInt(arrayString[i]);
        }
        int target = sc.nextInt();
        buscaBinaria(array, target, 0, array.length - 1);
    }

    private static int buscaBinaria(int[] vector, int target,  int left, int right){
        if (left <= right && vector.length != 0) {

            int mid = (left + right) / 2;
            int atual = vector[mid];
            if (atual == target) {
                System.out.println(mid);
                return atual;
            }

            else if (atual < target) {
                System.out.println(mid);
                return buscaBinaria(vector, target, mid + 1, right);
            }
            else if (atual > target) {
                System.out.println(mid);
                return buscaBinaria(vector, target, left, mid - 1);
            }
        }
        System.out.println(-1);
        return -1;
    }
}
