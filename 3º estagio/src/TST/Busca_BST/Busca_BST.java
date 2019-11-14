package TST.Busca_BST;

import java.util.Arrays;
import java.util.Scanner;

public class Busca_BST {
    public static void main(String[] args) {
        BST bst = new BST();

        Scanner sc = new Scanner(System.in);
        String stringLista = sc.nextLine();
        int numero = sc.nextInt();
        String[] lista = stringLista.split(" ");

        for (int i = 0; i < lista.length; i++) {
            bst.add(Integer.parseInt(lista[i]));
        }
        System.out.println(Arrays.asList(bst.search(numero)));
    }
}
