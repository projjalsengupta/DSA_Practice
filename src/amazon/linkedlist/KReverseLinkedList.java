package amazon.linkedlist;

import java.util.Scanner;

public class KReverseLinkedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ListNode head = null;
        ListNode tail = null;
        for (int i = 0; i < n; i++) {
            if (head == null) {
                head = new ListNode(scanner.nextInt());
                tail = head;
            } else {
                tail.next = new ListNode(scanner.nextInt());
                tail = tail.next;
            }
        }
        int B = scanner.nextInt();
        print(reverseList(head, B));
    }

    private static ListNode reverseList(ListNode A, int B) {
        if (A == null || A.next == null) {
            return A;
        }
        int count = B;
        ListNode current = A;
        ListNode previous = null;
        ListNode next;
        while (count-- > 0 && current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        if (current != null) {
            A.next = reverseList(current, B);
        }
        return previous;
    }

    private static void print(ListNode A) {
        while (A != null) {
            System.out.println(A.val + " ");
            A = A.next;
        }
        System.out.println();
    }
}
