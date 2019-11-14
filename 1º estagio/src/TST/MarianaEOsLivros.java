package TST;

import java.util.Scanner;

public class MarianaEOsLivros {
    public static void main(String[] args) {
        String saida;
        Scanner input = new Scanner(System.in);
        String[] livros = input.nextLine().split(",");

        insertionSort(livros);
        saida = " ";
        for (String livro : livros) {
            saida += livro + ", ";
        }
        System.out.print(saida.substring(0,saida.length() - 2));

    }

    private static void insertionSort(String[] livros) {
        String atual;
        String saida = " ";
        for (int i = 1; i < livros.length; i++) {
            atual = livros[i];
            int j = i;
            for (String livro : livros) {
                saida += livro + ", ";
            }
            System.out.println(saida.substring(0,saida.length() - 2));
            while ((j > 0) && ((livros[j - 1].compareTo(atual) > 0))) {
                livros[j] = livros[j - 1];
                j--;
            }
            livros[j] = atual;
            saida = " ";
        }
    }
}