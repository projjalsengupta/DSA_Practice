public class IsSymmetric {
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

        System.out.println(isSymmetric(root));
    }

    private static int isSymmetric(TreeNode A) {
        if (A == null) {
            return 1;
        }
        return isSymmetricUtil(A.left, A.right);
    }

    private static int isSymmetricUtil(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return 1;
        }
        if (A != null && B != null && A.val == B.val) {
            return isSymmetricUtil(A.left, B.right) & isSymmetricUtil(A.right, B.left);
        }
        return 0;
    }
}
