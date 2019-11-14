package TST;

import java.util.Arrays;
import java.util.Scanner;

class SelectionSort {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] listaEntrada = input.nextLine().split(" ");

        int[] arrayInteiros = new int[listaEntrada.length];
        for (int i = 0; i < listaEntrada.length; i++) {
            arrayInteiros[i] = Integer.parseInt(listaEntrada[i]);
        }

        Selection_Sort(arrayInteiros);

    }

    private static void Selection_Sort(int[] v) {
        boolean trocou;
        for (int i = 0; i < v.length - 1; i++) {
            trocou = false;
            int indiceMenor = i;
            for (int j = i + 1; j < v.length; j++)
                if (v[j] < v[indiceMenor])
                    indiceMenor = j;
            if (indiceMenor != i) {
                int aux = v[i];
                v[i] = v[indiceMenor];
                v[indiceMenor] = aux;
                trocou = true;
            }
            if (trocou) {
                System.out.println(Arrays.toString(v));
            }
        }
    }
}
