public class NextPointerBinaryTree {
    static class TreeLinkNode {
        int val;
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;

        TreeLinkNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(3);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(4);
        root.left.left = new TreeLinkNode(1);
        root.left.right = new TreeLinkNode(3);

        connect(root);
    }

    private static void connect(TreeLinkNode root) {
        root.next = null;
        connectRecur(root);
    }

    private static void connectRecur(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.right != null) {
            root.right.next = (root.next != null) ? root.next.left : null;
        }
        connectRecur(root.left);
        connectRecur(root.right);
    }
}
