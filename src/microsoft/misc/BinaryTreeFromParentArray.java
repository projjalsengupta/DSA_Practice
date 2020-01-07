package microsoft.misc;

import java.util.*;

public class BinaryTreeFromParentArray {
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

    public static void main(String[] args) {
        int[] arr = new int[]{1, 13, 31, 7, 17, 33, 27, 1, 5, 15, 19, 3, 33, 17, 19, 21, 23, 25, 31, 11, 29, 13, 27, 7, 25, -1, 23, 15, 3, 11, 21, 5, 9, 9};
        levelOrder(createTree(arr, arr.length));
    }

    public static Node createTree(int[] arr, int n) {
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(new Node(i));
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }
        Node root = null;
        for (Integer i : map.keySet()) {
            if (i == -1) {
                root = nodes.get(map.get(i).get(0));
            } else {
                for (int j = 0; j < map.get(i).size(); j++) {
                    if (nodes.get(i).left == null) {
                        nodes.get(i).left = nodes.get(map.get(i).get(j));
                    } else {
                        nodes.get(i).right = nodes.get(map.get(i).get(j));
                    }
                }
            }
        }
        return root;
    }

    private static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null) {
                q.add(temp.right);
            }
        }
    }
}
