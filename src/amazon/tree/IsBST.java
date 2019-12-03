package amazon.tree;

public class IsBST {
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

        System.out.println(isValidBST(root));
    }

    private static int isValidBST(TreeNode A) {
        return isValidBST(A, Integer.MIN_VALUE, Integer.MAX_VALUE) ? 1 : 0;
    }

    private static boolean isValidBST(TreeNode A, int min, int max) {
        if (A == null) {
            return true;
        }
        if (A.val > min && A.val < max) {
            return (isValidBST(A.left, min, A.val) && isValidBST(A.right, A.val, min));
        }
        return false;
    }
}
