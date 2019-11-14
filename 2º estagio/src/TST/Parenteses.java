import java.util.Scanner;

public class Parenteses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String entrada = sc.nextLine();

        int i_parentesesDireita = 0;
        int i_parentesesEsquerda = 0;
        for (int i = 0; i < entrada.length(); i++) {
            char c = entrada.charAt(i);

            if (c == '(') {
                i_parentesesEsquerda++;
            }
            if (c == ')') {
                i_parentesesDireita++;
            }
        }

        if (entrada.charAt(0) == ')' || entrada.charAt(entrada.length() - 1) == '(') {
            System.out.println("N");
        }
        else if (i_parentesesDireita == i_parentesesEsquerda) {
            System.out.println("S");
        }
        else {
            System.out.println("N");
        }
    }
}
