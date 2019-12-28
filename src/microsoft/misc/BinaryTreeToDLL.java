package microsoft.misc;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeToDLL {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BToDLL {
        Node head = null;

        Node bToDLL(Node root) {
            if (root == null) {
                return null;
            }
            ArrayList<Node> list = new ArrayList<>();
            Stack<Node> s = new Stack<>();
            while (root != null || !s.isEmpty()) {
                while (root != null) {
                    s.push(root);
                    root = root.left;
                }
                root = s.pop();
                list.add(root);
                root = root.right;
            }
            head = list.get(0);
            for (int i = 0; i < list.size(); i++) {
                Node current = list.get(i);
                if (i == 0) {
                    current.left = null;
                } else {
                    current.left = list.get(i - 1);
                }
                if (i == list.size() - 1) {
                    current.right = null;
                } else {
                    current.right = list.get(i + 1);
                }
            }
            return head;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
        inOrder(root);
        System.out.println();
        BToDLL util = new BToDLL();
        printDLL(util.bToDLL(root));
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void printDLL(Node head) {
        if (head == null) {
            return;
        }
        Node prev = head;
        while (head != null) {
            System.out.print(head.data + " ");
            prev = head;
            head = head.right;
        }
        System.out.println();
        while (prev != null) {
            System.out.print(prev.data + " ");
            prev = prev.left;
        }
    }
}
