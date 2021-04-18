public class MaxSumPath {
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
        System.out.println(maxPathSum(root));
    }

    private static int maxPathSum(TreeNode A) {
        Res res = new Res();
        maxPathSumUtil(A, res);
        return res.val;
    }

    private static class Res {
        int val = Integer.MIN_VALUE;
    }

    private static int maxPathSumUtil(TreeNode A, Res res) {
        if (A == null) {
            return 0;
        }

        int left = maxPathSumUtil(A.left, res);
        int right = maxPathSumUtil(A.right, res);

        int sum1 = left + A.val;
        int sum2 = right + A.val;
        int sum3 = left + right + A.val;
        int sum4 = A.val;

        res.val = Math.max(Math.max(sum1, Math.max(sum2, Math.max(sum3, sum4))), res.val);
        return Math.max(sum1, Math.max(sum2, sum4));
    }
}
