package amazon.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SortedArrayToBalancedBST {
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
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        A.add(6);
        A.add(7);
        A.add(8);
        A.add(9);
        A.add(10);
        TreeNode root = sortedArrayToBST(A);
        System.out.println(inorder(root));
        System.out.println(preorder(root));
        System.out.println(postorder(root));
    }

    private static TreeNode sortedArrayToBST(final List<Integer> A) {
        return createBST(A, 0, A.size() - 1);
    }

    private static TreeNode createBST(final List<Integer> A, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(A.get(mid));
        node.left = createBST(A, left, mid - 1);
        node.right = createBST(A, mid + 1, right);
        return node;
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

    private static ArrayList<Integer> preorder(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode temp = root;
        Stack<TreeNode> stack = new Stack<>();
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                res.add(temp.val);
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            temp = temp.right;
        }
        return res;
    }

    private static ArrayList<Integer> postorder(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode temp = root;
        Stack<TreeNode> stack = new Stack<>();
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            if (!stack.isEmpty() && stack.peek() == temp) {
                temp = temp.right;
            } else {
                res.add(temp.val);
                temp = null;
            }
        }
        return res;
    }
}
