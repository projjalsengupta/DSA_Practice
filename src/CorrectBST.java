import java.util.ArrayList;

public class CorrectBST {
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
        root.left = new Node(5); //Swapped node
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(2); //Swapped node
        root.right.right = new Node(7);

        inOrder(correctBST(root));
    }

    private static Node correctBST(Node root) {
        ArrayList<Node> inOrder = new ArrayList<>();
        inOrder(root, inOrder);
        Node fNode = null;
        Node sNode = null;
        for (int i = 0; i < inOrder.size(); i++) {
            int prev = inOrder.get(Math.max(i - 1, 0)).data;
            int current = inOrder.get(i).data;
            int next = inOrder.get(Math.min(i + 1, inOrder.size() - 1)).data;
            if (prev < current && next < current && fNode == null) {
                fNode = inOrder.get(i);
            } else if (prev > current && next > current) {
                sNode = inOrder.get(i);
            }
        }
        if (fNode != null && sNode != null) {
            int temp = fNode.data;
            fNode.data = sNode.data;
            sNode.data = temp;
        }
        return root;
    }

    private static void inOrder(Node root, ArrayList<Node> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root);
        inOrder(root.right, list);
    }

    private static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data);
        inOrder(root.right);
    }
}
