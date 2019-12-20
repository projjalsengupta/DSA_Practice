package amazon.tree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class CreateTreeFromInorderPreorder {
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
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            A.add(scanner.nextInt());
        }
        for (int i = 0; i < n; i++) {
            B.add(scanner.nextInt());
        }

        TreeNode root = buildTree(A, B);
        System.out.println("Inorder");
        System.out.println(inorder(root));
        System.out.println("Preorder");
        System.out.println(preorder(root));
    }

    private static TreeNode buildTree(ArrayList<Integer> pre, ArrayList<Integer> in) {
        if (pre.isEmpty() || in.isEmpty()) {
            return null;
        }
        if (preIndex >= pre.size()) {
            return null;
        }
        TreeNode node = new TreeNode(pre.get(preIndex++));
        int index = in.indexOf(node.val);
        node.left = buildTree(pre, new ArrayList<>(in.subList(0, index)));
        node.right = buildTree(pre, new ArrayList<>(in.subList(index + 1, in.size())));
        return node;
    }

    private static int preIndex = 0;

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

//    private static ArrayList<Integer> postorder(TreeNode root) {
//        ArrayList<Integer> res = new ArrayList<>();
//        if (root == null) {
//            return res;
//        }
//        TreeNode temp = root;
//        Stack<TreeNode> stack = new Stack<>();
//        while (temp != null || !stack.isEmpty()) {
//            while (temp != null) {
//                stack.push(temp);
//                stack.push(temp);
//                temp = temp.left;
//            }
//            temp = stack.pop();
//            if (!stack.isEmpty() && stack.peek() == temp) {
//                temp = temp.right;
//            } else {
//                res.add(temp.val);
//                temp = null;
//            }
//        }
//        return res;
//    }
}
