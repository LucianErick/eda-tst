package TST;

import java.util.Scanner;

class BuscaLinearRecursiva {

     public static void main(String[] args) {
         Scanner input = new Scanner(System.in);

         String[] listaEntrada = input.nextLine().split(" ");
         int numeroBuscado = input.nextInt();

         int[] arrayInteiros = new int[listaEntrada.length];
         for (int i = 0; i < listaEntrada.length; i++) {
             arrayInteiros[i] = Integer.parseInt(listaEntrada[i]);
         }

         System.out.println(buscaLinear(arrayInteiros, numeroBuscado, 0));
     }

     private static int buscaLinear(int[] vetor, int numero, int indice) {

          if (vetor[indice] == numero) {
              return indice;
          }

          if (indice == vetor.length - 1 && vetor[indice] != numero) {
              return -1;
          }
          return buscaLinear(vetor, numero, indice + 1);
     }
}
