package microsoft.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DiameterOfATree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
        System.out.println(diameter(root));
    }

    private static int res = 0;

    private static int diameterUtil(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftSubtreeLength = diameterUtil(root.left);
        int rightSubtreeLength = diameterUtil(root.right);
        int distance = leftSubtreeLength + rightSubtreeLength + 1;
        if (distance > res) {
            res = distance;
        }
        return Math.max(leftSubtreeLength + 1, rightSubtreeLength + 1);
    }

    private static int diameter(Node root) {
        res = 0;
        diameterUtil(root);
        return res;
    }
}
