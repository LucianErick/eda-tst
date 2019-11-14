package TST;

import java.util.Scanner;

class EncontraElemento {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numero = input.nextInt();
        input.nextLine();
        String[] listaEntrada = input.nextLine().split(" ");

        String saida = "nao";
        for (int i = 0; i < listaEntrada.length; i++) {
            if (Integer.parseInt(listaEntrada[i]) == numero) {
                saida = "sim";
            }
        }

        System.out.println(saida);
    }
}
