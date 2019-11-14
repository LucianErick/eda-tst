package TST.Busca_BST;

class BST {
    private Node root;

    public BST() {
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
        }

        else {
            Node aux = this.root;
            while (aux != null) {
                if (valor < aux.valor) {
                    if (aux.esquerda == null) {
                        aux.esquerda = newNode;
                        return;
                    }
                    aux = aux.esquerda;
                }

                if (valor > aux.valor) {
                    if (aux.direita == null) {
                        aux.direita = newNode;
                        return;
                    }
                    aux = aux.direita;
                }
            }
        }
    }

    public String[] search(int numero) {
        String saida = "";
        String[] lista;
        if (!isEmpty()) {
            Node aux = this.root;
            while (aux != null) {
                if (aux.valor == numero) {
                    saida += aux.valor + ",";
                    break;
                }
                if (aux.valor > numero) {
                    saida += aux.valor + ",";
                    if (aux.esquerda != null) {
                        aux = aux.esquerda;
                    } else break;
                }
                if (aux.valor < numero) {
                    saida += aux.valor + ",";
                    if (aux.direita != null) {
                        aux = aux.direita;
                    } else break;
                }
            }
        }
        lista = saida.split(",");
        return lista;
    }
}
