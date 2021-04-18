public class ReverseKPartsLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next = new Node(9);

        head = reverse(head, 3);
        print(head);
    }

    public static Node reverse(Node node, int k) {
        if (node == null) {
            return null;
        }
        Node head = node;
        Node tail = node;
        node = node.next;
        head.next = null;
        int tempK = k;
        k--;
        while (node != null && k-- > 0) {
            Node temp = head;
            head = node;
            node = node.next;
            head.next = temp;
        }
        tail.next = reverse(node, tempK);
        return head;
    }

    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + "");
            head = head.next;
        }
    }
}
