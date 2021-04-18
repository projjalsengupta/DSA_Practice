import java.util.ArrayList;
import java.util.Stack;

public class FlattenBST {
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
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println(inorder(flatten(root)));
    }

    private static TreeNode flatten(TreeNode A) {
        flattenUtil(A);
        return A;
    }

    private static void flattenUtil(TreeNode A) {
        if (A == null || A.left == null && A.right == null) {
            return;
        }
        if (A.left != null) {
            flattenUtil(A.left);

            TreeNode temp = A.right;
            A.right = A.left;
            A.left = null;

            TreeNode i = A.right;
            while (i.right != null) {
                i = i.right;
            }

            i.right = temp;
        }
        flattenUtil(A.right);
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
