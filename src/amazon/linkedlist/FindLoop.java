package amazon.linkedlist;

import java.util.HashSet;

public class FindLoop {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next.next;

        print(detectCycle(head));
    }

    private static ListNode detectCycle(ListNode a) {
        HashSet<ListNode> nodes = new HashSet<>();
        while (a != null) {
            if (nodes.contains(a)) {
                return a;
            }
            nodes.add(a);
            a = a.next;
        }
        return null;
    }

    private static void print(ListNode A) {
        if (A != null) {
            System.out.println(A.val);
        }
    }
}
