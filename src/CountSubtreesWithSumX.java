public class CountSubtreesWithSumX {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(-10);
        root.right = new Node(3);
        root.left.left = new Node(9);
        root.left.right = new Node(8);
        root.right.left = new Node(-4);
        root.right.right = new Node(7);

        System.out.println(countSubtreesWithSumX(root, 7));
    }

    private static int count = 0;

    private static int countSubtreesWithSumXUtil(Node root, int x) {
        if (root == null) {
            return 0;
        }
        int leftSubtreeSum = countSubtreesWithSumXUtil(root.left, x);
        int rightSubtreeSum = countSubtreesWithSumXUtil(root.right, x);
        int sum = leftSubtreeSum + rightSubtreeSum + root.data;
        if (sum == x) {
            count++;
        }
        return sum;
    }

    private static int countSubtreesWithSumX(Node root, int x) {
        count = 0;
        countSubtreesWithSumXUtil(root, x);
        return count;
    }
}
