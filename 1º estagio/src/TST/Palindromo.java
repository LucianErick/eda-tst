package TST;

import java.util.Scanner;

public class Palindromo {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String entrada = input.nextLine().trim();

        char[] arrayChar = entrada.toCharArray();
        System.out.print(palindromo(arrayChar));
    }

    private static boolean palindromo(char[] arrayChar) {
        String stringNormal = "";
        String stringInvertida = "";
        for (int i = 0; i < arrayChar.length; i++) {
            stringNormal += arrayChar[i];
        }
        for (int i = arrayChar.length - 1; i >= 0; i--) {
            stringInvertida += arrayChar[i];
        }
        if (stringNormal.equals(stringInvertida)) {
            return true;
        }
        return false;
    }
}
