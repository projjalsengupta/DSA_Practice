package amazon.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth {
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
        root.left.right = new TreeNode(3);

        System.out.println(minDepth(root));
    }

    private static int minDepth(TreeNode A) {
        if (A == null) {
            return 0;
        }
        int minDepth = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        while (!q.isEmpty()) {
            Queue<TreeNode> tempQueue = new LinkedList<>();
            while (!q.isEmpty()) {
                TreeNode node = q.poll();
                if (node.left == null && node.right == null) {
                    return minDepth;
                }
                if (node.left != null) {
                    tempQueue.add(node.left);
                }
                if (node.right != null) {
                    tempQueue.add(node.right);
                }
            }
            q = tempQueue;
            minDepth++;
        }
        return minDepth;
    }
}
