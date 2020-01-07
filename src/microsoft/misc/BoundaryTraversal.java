package microsoft.misc;

public class BoundaryTraversal {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right.right = new Node(25);

        printBoundary(root);
    }

    public static void printBoundary(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        printLeftBoundary(node.left);
        printLeaves(node.left);
        printLeaves(node.right);
        printRightBoundary(node.right);
    }

    private static void printLeftBoundary(Node root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            System.out.print(root.data + " ");
            printLeftBoundary(root.left);
        } else if (root.right != null) {
            System.out.print(root.data + " ");
            printLeftBoundary(root.right);
        }
    }

    private static void printRightBoundary(Node root) {
        if (root == null) {
            return;
        }
        if (root.right != null) {
            printRightBoundary(root.right);
            System.out.print(root.data + " ");
        } else if (root.left != null) {
            printRightBoundary(root.left);
            System.out.print(root.data + " ");
        }
    }

    private static void printLeaves(Node root) {
        if (root == null) {
            return;
        }
        printLeaves(root.left);
        if (root.left == null && root.right == null) {
            System.out.print(root.data + " ");
        }
        printLeaves(root.right);
    }
}
