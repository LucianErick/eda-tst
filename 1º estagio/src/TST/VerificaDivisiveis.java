package TST;

import java.util.Scanner;

public class VerificaDivisiveis {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] listaEntrada = input.nextLine().split(" ");
        int[] arrayInteiros = new int[listaEntrada.length];
        for (int i = 0; i < listaEntrada.length; i++) {
            arrayInteiros[i] = Integer.parseInt(listaEntrada[i]);
        }
        System.out.println(verificaDivisiveis(arrayInteiros));
    }

    private static boolean verificaDivisiveis(int[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            for (int j = i + 1; j < vetor.length; j++) {
                if ((vetor[i] % vetor[j] == 0) || (vetor[j] % vetor[i] == 0)) {
                    if (vetor[i] % vetor[j] == 0){
                        System.out.println(String.format("%d é divisível por %d!!!", vetor[i], vetor[j]));
                    }
                    if (vetor[j] % vetor[i] == 0){
                        System.out.println(String.format("%d é divisível por %d!!!", vetor[j], vetor[i]));
                    }

                    return true;
                }
            }
        }
        return false;
    }
}
