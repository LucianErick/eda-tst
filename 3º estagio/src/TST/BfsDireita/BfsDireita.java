package TST.BfsDireita;

import java.util.Deque;
import java.util.LinkedList;

class BST {
    private Node root;
    Deque<Node> bfs;

    public BST() {
        bfs = new LinkedList<Node>();
    }

    private boolean isEmpty() {
        return this.root == null;
    }

    public void add(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            this.root = newNode;
        } else {
            Node aux = this.root;
            while (aux != null) {
                if (value > aux.getValue()) {
                    if (aux.getRight() == null) {
                        aux.setRight(newNode);
                        newNode.setParent(aux);
                        return;
                    } else {
                        aux = aux.getRight();
                    }
                } else {
                    if (aux.getLeft() == null) {
                        aux.setLeft(newNode);
                        newNode.setParent(aux);
                        return;
                    } else {
                        aux = aux.getLeft();
                    }
                }
            }
        }
    }

    public void printBFS() {
        Deque<Node> queue = new LinkedList<Node>();
        if (!isEmpty()) {
            queue.addLast(this.root);
            while (!queue.isEmpty()) {
                Node current = queue.removeFirst();
                bfs.addLast(current);
                if (current.getRight() != null) {
                    queue.addLast(current.getRight());
                }
                if (current.getLeft() != null) {
                    queue.addLast(current.getLeft());
                }
            }
        }
    }
}

class Node {
    private Node right;
    private Node left;
    private Node parent;
    private int value;

    public Node(int value) {
        this.value = value;
    }

    public Node getRight() {
        return right;
    }

    public Node getLeft() {
        return left;
    }

    public Node getParent() {
        return parent;
    }

    public int getValue() {
        return value;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s", getValue());
    }
}