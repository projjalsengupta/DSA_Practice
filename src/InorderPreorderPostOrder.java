import java.util.ArrayList;
import java.util.Stack;

public class InorderPreorderPostOrder {
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
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        System.out.println("Inorder");
        print(inorder(root));
        System.out.println("Preorder");
        print(preorder(root));
        System.out.println("Postorder");
        print(postorder(root));
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

    private static void print(ArrayList<Integer> a) {
        for (Integer i : a) {
            System.out.println(i);
        }
    }
}
