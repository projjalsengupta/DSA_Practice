package microsoft.misc;

public class MaxPathSum {
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
        Node root = new Node(4);
        root.left = new Node(5);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(2);
        root.right.right = new Node(7);

        System.out.println(maxPathSum(root));
    }

    private static int maxSum;

    private static int maxPathSum(Node root) {
        if (root == null) {
            return 0;
        }
        maxSum = Integer.MIN_VALUE;
        maxPathSumUtil(root);
        return maxSum;
    }

    private static int maxPathSumUtil(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSubtreeSum = maxPathSumUtil(root.left);
        int rightSubtreeSum = maxPathSumUtil(root.right);
        int sum = root.data + rightSubtreeSum + leftSubtreeSum;
        if (root.left != null && root.right != null) {
            maxSum = Math.max(maxSum, sum);
        }
        return Math.max(leftSubtreeSum, rightSubtreeSum) + root.data;
    }
}
