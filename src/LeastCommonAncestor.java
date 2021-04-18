public class LeastCommonAncestor {
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);

        System.out.println(lca(root, 4, 6));
    }

    private static int lca(TreeNode A, int B, int C) {
        TreeNode treeNode = lcaNode(A, B, C);
        if (treeNode != null) {
            return treeNode.val;
        }
        return -1;
    }

    private static TreeNode lcaNode(TreeNode A, int B, int C) {
        if (A == null) {
            return null;
        }
        if (A.val == B || A.val == C) {
            return A;
        }
        TreeNode node1 = lcaNode(A.left, B, C);
        TreeNode node2 = lcaNode(A.right, B, C);
        if (node1 != null && node2 != null) {
            return A;
        }
        return (node1 == null) ? node2 : node1;
    }
}
