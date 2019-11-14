package TST.ElementosMaiores;

import java.util.*;

class ElementosMaiores {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BST bst = new BST();

        String[] input = scan.nextLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            bst.add(Integer.parseInt(input[i]));
        }
        int target = scan.nextInt();
        bst.preOrder();
        System.out.println(Arrays.toString(bst.dfs.toArray()));
        System.out.println(bst.biggerThan(target));
    }
}

class BST {
    private Node root;
    Deque<Node> dfs;

    public BST() {
        dfs = new LinkedList<Node>();
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

    public int biggerThan(int value) {
        int count = 0;
        for (Node node : dfs) {
            if (node.getValue() > value) {
                count++;
            }
        }
        return count;
    }

    public void preOrder() {
        preOrder(this.root);
    }

    private void preOrder(Node node) {
        if (node != null) {
            dfs.addLast(node);
            preOrder(node.getLeft());
            preOrder(node.getRight());
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