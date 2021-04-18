import java.util.HashSet;

public class Intersection {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        A.next = new ListNode(2);

        ListNode B = new ListNode(3);
        B.next = new ListNode(4);
        B.next.next = new ListNode(5);

        ListNode C = new ListNode(6);
        C.next = new ListNode(7);
        C.next.next = new ListNode(8);

        A.next.next = C;
        B.next.next.next = C;

        print(getIntersectionNode(A, B));
    }

    private static ListNode getIntersectionNode(ListNode a, ListNode b) {
        HashSet<ListNode> nodes = new HashSet<>();
        while (a != null) {
            nodes.add(a);
            a = a.next;
        }
        while (b != null) {
            if (nodes.contains(b)) {
                return b;
            }
            nodes.add(b);
            b = b.next;
        }
        return null;
    }

    private static void print(ListNode A) {
        if (A != null) {
            System.out.println(A.val);
        }
    }
}
