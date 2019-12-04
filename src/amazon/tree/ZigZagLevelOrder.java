package amazon.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagLevelOrder {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(zigzagLevelOrder(root));
    }

    private static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean rev = false;
        while (!q.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            Queue<TreeNode> tempQ = new LinkedList<>();
            while (!q.isEmpty()) {
                TreeNode node = q.poll();
                list.add(node.val);
                if (node.left != null) {
                    tempQ.add(node.left);
                }
                if (node.right != null) {
                    tempQ.add(node.right);
                }
            }
            q = tempQ;
            if (rev) {
                Collections.reverse(list);
            }
            rev = !rev;
            res.add(list);
        }
        return res;
    }
}
