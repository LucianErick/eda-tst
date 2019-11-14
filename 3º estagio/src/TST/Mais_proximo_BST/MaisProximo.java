package TST.Mais_proximo_BST;

import java.util.Arrays;
import java.util.Scanner;

class ValorMaisProximoBST {
    private static Scanner scan;
    private static Node root;

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        String[] values = scan.nextLine().split(" ");
        Integer element = scan.nextInt();

        for (int i = 0; i < values.length; i++) {
            insert(Integer.parseInt(values[i]));
        }
        System.out.println(Arrays.toString(preOrder()));
        System.out.println(closestValue(element));
    }

    private static int closestValue(int value) {
        int output = Integer.MAX_VALUE;
        Node aux = root;

        while (aux != null) {
            int data = aux.getValue();

            if (Math.abs(data - value) < Math.abs(output - value)) {
                output = data;
            }
            if (data < value) {
                aux = aux.getRight();
            }
            else if (data > value) {
                aux = aux.getLeft();
            }
            else if (data == value) {
                break;
            }
        }
        return output;
    }

    public static Node getRoot() {
        return root;
    }

    public static boolean isEmpty() {
        return root == null;
    }

    private static Integer[] preOrder() {
        Integer[] array = new Integer[size()];
        preOrder(root, array);
        return array;
    }

    private static void preOrder(Node node, Integer[] array) {
        if (node != null) {
            int i = 0;
            while(i < array.length && array[i] != null) {
                i++;
            }
            array[i] = node.getValue();
        }

        if (node.getLeft() != null) {
            preOrder(node.getLeft(), array);
        }

        if (node.getRight() != null) {
            preOrder(node.getRight(), array);
        }
    }

    public static void insert(Integer value) {
        Node newNode = new Node(value);

        if (isEmpty()) {
            root = new Node(value);
        }

        else {
            insertNotEmpty(value, newNode);
        }
    }

    private static void insertNotEmpty(Integer value, Node newNode) {
        Node aux = root;

        while(aux != null) {
            if (value > aux.getValue()) {
                if (aux.getRight() == null) {
                    newNode.setParent(aux);
                    aux.setRight(newNode);
                    break;
                }
                else {
                    aux = aux.getRight();
                }
            }
            else if (value < aux.getValue()) {
                if(aux.getLeft() == null) {
                    newNode.setParent(aux);
                    aux.setLeft(newNode);
                    break;
                }
                else {
                    aux = aux.getLeft();
                }
            }
            else if (value == aux.getValue()) {
                break;
            }
        }
    }

    private static int size() {
        return size(root);
    }

    private static int size(Node node) {
        if (node == null) {
            return 0;
        }
        else {
            return 1 + size(node.getLeft()) + size(node.getRight());
        }
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
}