package Rotações;

import java.util.Arrays;
import java.util.Scanner;

class Rotacoes {
    private static Scanner scan;
    private static Node root;

    public static void main(String[] args) {
        root = new Node(null);

        scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        int[] array = new int[3];

        for (int i = 0; i < array.length; i++) {
            insert(Integer.parseInt(input[i]));
        }
        rebalance(root);
    }

    public static void rebalance(Node node) {
        if (!node.isEmpty()) {
            int balance = balance(node);

            if (Math.abs(balance) > 1) {

                if (balance > 0) {

                    if (height(node.getLeft().getLeft()) < height(node.getLeft().getRight())) {
                        System.out.println("rot_esq(" + node.getLeft() + ")");
                        rotateLeft(node.getLeft());
                        System.out.println(Arrays.toString(preOrder()));
                    }
                    System.out.println("rot_dir(" + node + ")");
                    rotateRight(node);
                    System.out.println(Arrays.toString(preOrder()));
                }

                else if (balance < 0) {

                    if (height(node.getRight().getRight()) < height(node.getRight().getLeft())) {
                        System.out.println("rot_dir(" + node.getRight() + ")");
                        rotateRight(node.getRight());
                        System.out.println(Arrays.toString(preOrder()));
                    }
                    System.out.println("rot_esq(" + node + ")");
                    rotateLeft(node);
                    System.out.println(Arrays.toString(preOrder()));
                }
            }

            else {
                System.out.println("balanceada");
            }
        }
    }

    public static boolean isEmpty() {
        return root == null;
    }

    private static int size() {
        return size(root);
    }

    private static int size(Node node) {
        int out = 0;

        if (!node.isEmpty()) {
            out = 1 + size(node.getLeft()) + size(node.getRight());
        }

        return out;
    }

    private static void insert(Integer value) {
        if (value != null) {
            insert(root, null, value);
        }
    }

    private static void insert(Node node, Node parent, Integer value) {
        if (node.getValue() == null) {
            node.setValue(value);
            node.setLeft(new Node(null, node));
            node.setRight(new Node(null, node));
            node.setParent(parent);
        }

        else {
            if (node.getValue().compareTo(value) > 0) {
                insert(node.getLeft(), node, value);
            }

            else if (node.getValue().compareTo(value) < 0) {
                insert(node.getRight(), node, value);
            }
        }
    }

    private static Node[] preOrder() {
        Node[] output = new Node[size()];

        if (!isEmpty()) {
            preOrder(root, output);
        }
        return output;
    }

    private static void preOrder(Node node, Node[] array) {
        int i = 0;

        while (array[i] != null) {
            i++;
        }
        array[i] = node;

        if (!node.getLeft().isEmpty()) {
            preOrder(node.getLeft(), array);
        }

        if (!node.getRight().isEmpty()) {
            preOrder(node.getRight(), array);
        }
    }

    private static int height(Node node) {
        int height = -1;

        if (node != null) {
            int leftHeight = height(node.getLeft());
            int rightHeight = height(node.getRight());

            if (leftHeight > rightHeight) {
                height = leftHeight + 1;
            }

            else {
                height = rightHeight + 1;
            }
        }
        return height;
    }

    private static void rotateLeft(Node node) {
        Node aux = leftRotation(node);

        if (node.equals(root)) {
            root = aux;
        }

        else {
            Node parent = aux.getParent();
            if (parent != null) {
                if (parent.getLeft().equals(node)) {
                    parent.setLeft(aux);
                    aux.setParent(parent);
                }

                else {
                    parent.setRight(aux);
                    aux.setParent(parent);
                }
            }
        }
    }

    private static void rotateRight(Node node) {
        Node aux = rightRotation(node);

        if (node.equals(root)) {
            root = aux;
        }

        else {
            Node parent = aux.getParent();

            if (parent != null) {

                if (parent.getLeft().equals(node)) {
                    parent.setLeft(aux);
                    aux.setParent(parent);
                }

                else {
                    parent.setRight(aux);
                    aux.setParent(parent);
                }
            }
        }
    }

    private static Node leftRotation(Node node) {
        Node neighbour = node.getRight();

        neighbour.setParent(node.getParent());
        node.setParent(neighbour);

        node.setRight(neighbour.getLeft());
        neighbour.setLeft(node);

        return neighbour;
    }

    private static Node rightRotation(Node node) {
        Node neighbour = node.getLeft();

        neighbour.setParent(node.getParent());
        node.setParent(neighbour);

        node.setLeft(neighbour.getRight());
        neighbour.setRight(node);

        return neighbour;
    }

    private static int balance(Node node) {
        int output = -1;

        if (!node.isEmpty()) {
            int left = height(node.getLeft());
            int right = height(node.getRight());

            output = left - right;
        }
        return output;
    }
}

class Node {
    private Integer value;
    private Node parent;
    private Node left;
    private Node right;

    public Node(Integer value) {
        this.value = value;
    }

    public Node(Integer value, Node node) {
        this.value = value;
        this.parent = node;
    }

    public boolean isEmpty() {
        return this.value == null;
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }

    public Integer getValue() {
        return value;
    }

    public Node getParent() {
        return parent;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public String toString() {
        return this.value + "";
    }
}