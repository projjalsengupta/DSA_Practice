import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class CreateTreeFromInorderPostorder {
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
        System.out.println("Postorder");
        System.out.println(postorder(root));
    }

    private static TreeNode buildTree(ArrayList<Integer> in, ArrayList<Integer> post) {
        postIndex = post.size() - 1;
        return buildTree(in, post, 0, in.size() - 1);
    }

    private static TreeNode buildTree(ArrayList<Integer> in, ArrayList<Integer> post, int i, int j) {
        if (j < i || postIndex < 0) {
            return null;
        }
        TreeNode node = new TreeNode(post.get(postIndex--));
        int index = in.indexOf(node.val);
        node.right = buildTree(post, in, index + 1, j);
        node.left = buildTree(post, in, i, index - 1);

        return node;
    }

    private static int postIndex = 0;

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
