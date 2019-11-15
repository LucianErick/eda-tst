package BSTImpl;
import BSTImpl.Node.*;

import java.util.Deque;
import java.util.LinkedList;

public class BST {
    private Node raiz;

    public BST() {
        this.raiz = null;
    }

    private boolean isEmpty() {
        return this.raiz == null;
    }

    public void addIterativo(int elemento) {
        Node newNode = new Node(elemento);
        if (isEmpty()) {
            this.raiz = newNode;
        } else {
            Node aux = this.raiz;
            while (aux != null) {
                if (elemento > aux.getValor()) {
                    if (aux.getDireita() == null) {
                        aux.setDireita(new Node(elemento));
                        aux.getDireita().setPai(aux);
                        return;
                    } else {
                        aux = aux.getDireita();
                    }
                } else {
                    if (aux.getEsquerda() == null) {
                        aux.setEsquerda(new Node(elemento));
                        aux.getEsquerda().setPai(aux);
                        return;
                    } else {
                        aux = aux.getEsquerda();
                    }
                }
            }
        }
    }

    public void addRecursivo(int elemento) {
        if (isEmpty()) {
            this.raiz = new Node(elemento);
        } else {
            addRecursivo(this.raiz, elemento);
        }
    }

    private void addRecursivo(Node node, int valor) {
        if (valor > node.getValor()) {
            if (node.getDireita() == null) {
                node.setDireita(new Node(valor));
                return;
            }
            addRecursivo(node.getDireita(), valor);
        } else {
            if (node.getEsquerda() == null) {
                node.setEsquerda(new Node(valor));
                return;
            }
            addRecursivo(node.getEsquerda(), valor);
        }
    }

    public Node search(int elemento) {
        Node node = null;
        if (isEmpty()) {
            return node;
        } else {
            Node aux = this.raiz;
            while (aux != null) {
                if (elemento == aux.getValor()) {
                    return aux;
                }
                if (elemento > aux.getValor()) {
                    aux = aux.getDireita();
                }
                if (elemento < aux.getValor()) {
                    aux = aux.getEsquerda();
                }
            }
        }
        return null;
    }

    public Node min() {
        if (isEmpty()) {
            return null;
        } else {
            return min(this.raiz);
        }
    }

    private Node min(Node node) {
        if (node.getEsquerda() == null) {
            return node;
        } else {
            return min(node.getEsquerda());
        }
    }

    public Node max() {
        if (isEmpty()) {
            return null;
        } else {
            return max(this.raiz);
        }
    }

    private Node max(Node node) {
        if (node.getDireita() == null) {
            return node;
        } else {
            return max(node.getDireita());
        }
    }

    public Node sucessor(Node node) {
        if (node == null)
            return null;

        else if (node.getDireita() != null)
            return min(node.getDireita());

        else {
            Node aux = node.getPai();
            while (aux != null && aux.getValor() < node.getValor())
                aux = aux.getPai();

            return aux;
        }
    }

    public Node predecessor(Node node) {
        if (node == null)
            return null;

        else if (node.getEsquerda() != null)
            return max(node.getEsquerda());

        else {
            Node aux = node.getPai();
            while (aux != null && aux.getValor() > node.getValor())
                aux = aux.getPai();

            return aux;
        }
    }

    public int height() {
        return height(this.raiz);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(height(node.getEsquerda()), height(node.getDireita()));

    }

    private boolean ehFolha(Node node) {
        return (node.getDireita() == null && node.getEsquerda() == null && node.getPai() != null);
    }

    private boolean temSoUmFilhoAEsquerda(Node node) {
        return node.getDireita() == null && node.getEsquerda() != null;
    }

    private boolean temSoUmFilhoADireita(Node node) {
        return node.getDireita() != null && node.getEsquerda() == null;
    }

    private boolean temDoisFilhos(Node node) {
        return node.getDireita() != null && node.getEsquerda() != null || (node.getEsquerda() != null && node.getDireita() != null);
    }

    public void remove(Node toRemove) {
        if (ehFolha(toRemove)) {
            if (toRemove == this.raiz) {
                this.raiz = null;
            } else {
                if (toRemove.getValor() < toRemove.getPai().getValor()) {
                    toRemove.getPai().setEsquerda(null);
                } else {
                    toRemove.getPai().setDireita(null);
                }
            }
        } else if (temSoUmFilhoAEsquerda(toRemove)) {
            if (toRemove == this.raiz)  {
                this.raiz = toRemove.getEsquerda();
                this.raiz.setPai(null);
            } else {
                toRemove.getEsquerda().setPai(toRemove.getPai());
                if (toRemove.getValor() < toRemove.getPai().getValor())
                    toRemove.getPai().setEsquerda(toRemove.getEsquerda());
                else
                    toRemove.getPai().setDireita(toRemove.getEsquerda());
            }
        } else if (temSoUmFilhoADireita(toRemove)) {
            if (toRemove == this.raiz) {
                this.raiz = toRemove.getDireita();
                this.raiz.setPai(null);
            } else {
                toRemove.getDireita().setPai(toRemove.getPai());
                if (toRemove.getValor() < toRemove.getPai().getValor())
                    toRemove.getPai().setEsquerda(toRemove.getDireita());
                else
                    toRemove.getPai().setDireita(toRemove.getDireita());
            }
        } else {
            Node sucessor = sucessor(toRemove);
            toRemove.setValor(sucessor.getValor());
            remove(sucessor);
        }
    }

    public void preOrder() {
        preOrder(this.raiz);
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.getValor());
            preOrder(node.getEsquerda());
            preOrder(node.getDireita());
        }
    }

    public void inOrder() {
        inOrder(this.raiz);
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.getEsquerda());
            System.out.println(node.getValor());
            inOrder(node.getDireita());
        }
    }

    public void posOrder() {
        posOrder(this.raiz);
    }

    private void posOrder(Node node) {
        if (node != null) {
            posOrder(node.getEsquerda());
            posOrder(node.getDireita());
            System.out.println(node.getValor());
        }
    }

    public void BFS() {
        Deque<Node> queue = new LinkedList<Node>();
        if (!isEmpty()) {
            queue.addLast(this.raiz);
            while (!queue.isEmpty()) {
                Node current = queue.removeFirst();
                System.out.println(current);
                if(current.getEsquerda() != null)
                    queue.addLast(current.getEsquerda());
                if(current.getDireita() != null)
                    queue.addLast(current.getDireita());
            }
        }
    }

}
