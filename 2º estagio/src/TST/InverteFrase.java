import java.util.Arrays;
import java.util.Scanner;

public class InverteFrase {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String frase = sc.nextLine();
        frase = frase + " ";

        int tamanho = 0;
        for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);
            if (c == ' ')
                tamanho += 1;
        }

        String palavra = "";
        String[] palavras = new String[tamanho];
        int iterador = 0;

        for (int i = 0; i < frase.length(); i++) {
            char char_atual = frase.charAt(i);

            if (char_atual == ' ') {
                palavras[iterador] = palavra;
                iterador++;
                palavra = "";
            }
            else {
                palavra += char_atual;
            }
        }

        String saida = "";
        for (int i = palavras.length - 1; i >= 0; i--) {
            saida += palavras[i] + " ";
        }

        if (saida.length() > 0) {
            saida = saida.substring(0, saida.length() - 1);
        }

        System.out.println(saida);
    }
}
