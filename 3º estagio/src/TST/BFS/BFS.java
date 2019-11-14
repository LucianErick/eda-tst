package TST.BFS;
import java.util.Scanner;

public class BFS {

   public static void main(String[] args) {
        BST bst = new BST();

        Scanner sc = new Scanner(System.in);
        String stringLista = sc.nextLine();
        String[] lista = stringLista.split(" ");

        for (int i = 0; i < lista.length; i++) {
            bst.add(Integer.parseInt(lista[i]));
        }
        System.out.println();
    }
}
class BST {
    private Node root;

    BST() {
        this.root = null;
    }

    public Node getRoot() {
        return root;
    }

    private boolean isEmpty() {
        return this.root == null;
    }

    public void add(int valor) {
        Node newNode = new Node(valor);
        if (isEmpty()) {
            this.root = newNode;
        } else {
            Node aux = this.root;
            while (aux != null) {
                if (valor < aux.valor) {
                    if (aux.esquerda == null) {
                        aux.esquerda = newNode;
                        newNode.pai = aux;
                        return;
                    }
                    aux = aux.esquerda;
                }
                if (valor > aux.valor) {
                    if (aux.direita == null) {
                        aux.direita = newNode;
                        newNode.pai = aux;
                        return;
                    }
                    aux = aux.direita;
                }
            }
        }
    }

    /*public String bfs() {

    }*/
}

class Node {
    Node direita;
    Node esquerda;
    Node pai;
    int valor;

    Node(int valor) {
        this.direita = null;
        this.esquerda = null;
        this.pai = null;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.format("%s", this.valor);
    }
}
