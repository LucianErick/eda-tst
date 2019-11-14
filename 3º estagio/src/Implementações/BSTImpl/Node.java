package Implementações.BSTImpl;

public class Node {
    private Node direita;
    private Node esquerda;
    private Node pai;
    private int valor;      // Para simplificar, trabalharei usando valores inteiros.

    public Node(int valor) {
        this.direita = null;
        this.esquerda = null;
        this.pai = null;
        this.valor = valor;
    }

    public Node getDireita() {
        return direita;
    }

    public Node getEsquerda() {
        return esquerda;
    }

    public Node getPai() {
        return pai;
    }

    public int getValor() {
        return valor;
    }

    public void setDireita(Node direita) {
        this.direita = direita;
    }

    public void setEsquerda(Node esquerda) {
        this.esquerda = esquerda;
    }

    public void setPai(Node pai) {
        this.pai = pai;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.format("%s" ,getValor());
    }
}
