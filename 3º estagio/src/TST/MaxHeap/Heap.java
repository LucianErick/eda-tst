package TST.MaxHeap;
import java.util.Scanner;

class maxHeap {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string[] = sc.nextLine().split(" ");
        //System.out.println(Arrays.toString(string));
        int heap[] = new int[string.length];

        for(int i = 0; i < heap.length; i++) {
            heap[i] = Integer.parseInt(string[i]);
        }
        sc.close();

        boolean retorno = true;

        for (int i = 0; i < heap.length; i++) {
            if (!retorno) {
                System.out.println("false");
                break;
            }
            int filhoEsq = 2 * i + 1;
            int filhoDir = 2 * i + 2;

            if (filhoEsq < heap.length && heap[filhoEsq] > heap[i]) {
                retorno = false;
            } else if (filhoDir < heap.length && heap[filhoDir] > heap [i]) {
                retorno = false;
            }
        }
        if (retorno) {
            System.out.println("true");
        }
    }
}