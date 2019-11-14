package TST.Busca_BST;

class Node {
    Node direita;
    Node esquerda;
    int valor;

    public Node(int valor) {
        this.direita = null;
        this.esquerda = null;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.format("%s", this.valor);
    }
}
