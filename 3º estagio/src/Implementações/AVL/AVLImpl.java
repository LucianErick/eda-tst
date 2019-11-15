package AVL;

public class AVLImpl {
    private Node root;

    public AVLImpl() {
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    private int balance(Node node) {
        if (node != null) {
            return height(node.getLeft()) - height(node.getRight());
        }
        return 0;
    }

    private boolean isLeftPending(Node node) {
        return balance(node) == 1;
    }
    private boolean isRightPending(Node node) {
        return balance(node) == -1;
    }
    private boolean isBalanced(Node node) {
        return balance(node) == 0;
    }
    private boolean isUnbalanced(Node node) {
        return Math.abs(balance(node)) >= 2;
    }
    private boolean isEmpty() {
        return this.root == null;
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            this.root = newNode;
        } else {
            insert(this.root, value);
        }
    }

    private void insert(Node node, int value) {
        Node newNode = new Node(value);
        if (node.getValue() < value) {
            if (node.getRight() == null) {
                node.setRight(newNode);
                newNode.setParent(node);
                return;
            }
            insert(node.getRight(), value);
        } else {
            if (node.getLeft() == null) {
                node.setLeft(newNode);
                newNode.setParent(node);
                return;
            }
            insert(node.getLeft(), value);
        }
    }

    private void rightRotation(Node grandpa) {

        Node parent = grandpa.getLeft(); // Define o nó pai

        grandpa.setLeft(parent.getRight()); // A esquerda do avô é nula
        parent.setRight(grandpa); // O avô passa a ser direita do pai

        parent.setParent(grandpa.getParent()); // O pai do pai passa a ser o pai do avô
        grandpa.setParent(parent); // O pai do avô passa a ser o pai

        // Se à esquerda do pai do pai for o avô:
        if (parent.getParent().getLeft().equals(grandpa)) {
            parent.getParent().setLeft(parent); // A esquerda do pai do pai passa a ser o próprio pai.
        } else {
            parent.getParent().setRight(parent); // Senão, a direita do pai do pai passa a ser o pai.
        }
    }

    private void leftRotation(Node grandpa) {
        Node parent = grandpa.getRight(); // Define o nó pai

        grandpa.setRight(parent.getLeft()); // A direita do avô é nula
        parent.setLeft(grandpa);

        parent.setParent(grandpa.getParent()); // o pai do pai passa a ser o pai do avô
        grandpa.setParent(parent);

        if (parent.getParent().getLeft().equals(grandpa)) {
            parent.getParent().setLeft(parent);
        } else {
            parent.getParent().setRight(parent);
        }
    }
    private void rightAndLeftRotation(Node grandpa) {
        Node parent = grandpa.getRight();
        Node son = parent.getLeft();

        son.setRight(parent);
        son.setLeft(grandpa);

        parent.setParent(son);
        parent.setLeft(null);

        grandpa.setRight(null);
        son.setParent(grandpa.getParent());
        if (grandpa.getParent().getLeft().equals(grandpa)) {
            grandpa.getParent().setLeft(son);
        } else {
            grandpa.getParent().setRight(son);
        }
        grandpa.setParent(son);
    }

    private void leftAndRightRotation(Node grandpa) {
        Node parent = grandpa.getLeft();
        Node son = parent.getRight();

        son.setLeft(parent);
        son.setRight(grandpa);

        parent.setParent(son);
        parent.setRight(null);

        grandpa.setLeft(null);
        son.setParent(grandpa.getParent());
        if (grandpa.getParent().getLeft().equals(grandpa)) {
            grandpa.getParent().setLeft(son);
        } else {
            grandpa.getParent().setRight(son);
        }
        grandpa.setParent(son);
    }
}
