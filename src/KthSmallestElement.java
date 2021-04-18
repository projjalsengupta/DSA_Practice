import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class KthSmallestElement {
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
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println(kthsmallest(root, 2));
    }

    private static int kthsmallest(TreeNode A, int B) {
        ArrayList<Integer> list = inorder(A);
        return list.get(B - 1);
    }

    private static ArrayList<Integer> inorder(TreeNode A) {
        ArrayList<Integer> list = new ArrayList<>();
        if (A == null) {
            return list;
        }
        TreeNode temp = A;
        Stack<TreeNode> s = new Stack<>();
        while (temp != null || !s.isEmpty()) {
            while (temp != null) {
                s.push(temp);
                temp = temp.left;
            }
            temp = s.pop();
            list.add(temp.val);
            temp = temp.right;
        }
        return list;
    }
}
