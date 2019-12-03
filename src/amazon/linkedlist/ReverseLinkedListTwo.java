package amazon.linkedlist;

import java.util.Scanner;

public class ReverseLinkedListTwo {
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
        int C = scanner.nextInt();
        print(reverseBetween(head, B, C));
    }

    private static ListNode reverseBetween(ListNode A, int B, int C) {
        ListNode start = A;
        int k = C - B + 1;
        if (B == 1) {
            start = null;
        }
        while (--B > 1) {
            start = start != null ? start.next : null;
        }
        ListNode head = start == null ? A : start.next;
        ListNode prev = null;
        ListNode next = null;
        ListNode current = head;
        while (k-- > 0) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head.next = next;
        if (start != null) {
            start.next = prev;
        } else {
            A = prev;
        }
        return A;
    }

    private static void print(ListNode A) {
        while (A != null) {
            System.out.println(A.val + " ");
            A = A.next;
        }
        System.out.println();
    }
}
