package amazon.tree;

public class IsIdentical {
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
        TreeNode A = new TreeNode(3);
        A.left = new TreeNode(2);
        A.right = new TreeNode(4);
        A.left.left = new TreeNode(1);
        A.left.right = new TreeNode(3);

        TreeNode B = new TreeNode(3);
        B.left = new TreeNode(2);
        B.right = new TreeNode(4);
        B.left.left = new TreeNode(1);
        B.left.right = new TreeNode(3);

        System.out.println(isIdentical(A, B));
    }

    private static int isIdentical(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return 1;
        }
        if (A != null && B != null && A.val == B.val) {
            return isIdentical(A.left, B.left) & isIdentical(A.right, B.right);
        }
        return 0;
    }
}
