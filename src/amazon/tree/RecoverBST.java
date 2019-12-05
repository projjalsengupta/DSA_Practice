package amazon.tree;

import java.util.ArrayList;
import java.util.Stack;

public class RecoverBST {
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

        System.out.println(recoverTree(root));
    }

    private static ArrayList<Integer> recoverTree(TreeNode A) {
        ArrayList<Integer> traversal = inorder(A);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = traversal.size() - 1; i > 0; i--) {
            if (traversal.get(i) < traversal.get(i - 1)) {
                int j = i - 1;
                while (j >= 0 && traversal.get(i) < traversal.get(j)) {
                    j--;
                }
                res.add(traversal.get(i));
                res.add(traversal.get(j + 1));
                break;
            }
        }
        return res;
    }

    private static ArrayList<Integer> inorder(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode temp = root;
        Stack<TreeNode> stack = new Stack<>();
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            res.add(temp.val);
            temp = temp.right;
        }
        return res;
    }
}
