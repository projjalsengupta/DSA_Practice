public class HasPathSum {
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
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);

        System.out.println(hasPathSum(root, 22));
    }

    private static int hasPathSum(TreeNode A, int sum) {
        if (A == null) {
            return 0;
        }
        int ans = 0;
        if (A.left != null) {
            ans |= hasPathSimUtil(A.left, A.val, sum);
        }
        if (A.right != null) {
            ans |= hasPathSimUtil(A.right, A.val, sum);
        }
        return ans;
    }

    private static int hasPathSimUtil(TreeNode A, int currentSum, int sum) {
        if (A.left == null && A.right == null) {
            return ((currentSum + A.val) == sum) ? 1 : 0;
        }
        int ans = 0;
        if (A.left != null) {
            ans |= hasPathSimUtil(A.left, currentSum + A.val, sum);
        }
        if (A.right != null) {
            ans |= hasPathSimUtil(A.right, currentSum + A.val, sum);
        }
        return ans;
    }
}
