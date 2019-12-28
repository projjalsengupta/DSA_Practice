package microsoft.misc;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectLevelNodes {
    static class Node {
        int data;
        Node left;
        Node right;
        Node nextRight;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.nextRight = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
        connect(root);
    }

    public static void connect(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Queue<Node> tempQ = new LinkedList<>();
            while (!q.isEmpty()) {
                Node node = q.poll();
                node.nextRight = q.peek();
                if (node.left != null) {
                    tempQ.add(node.left);
                }
                if (node.right != null) {
                    tempQ.add(node.right);
                }
            }
            q = tempQ;
        }
    }
}
