package amazon.linkedlist;

import java.util.Scanner;

public class MergeTwoSortedLists {
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
        ListNode A = head;
        head = null;
        tail = null;
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            if (head == null) {
                head = new ListNode(scanner.nextInt());
                tail = head;
            } else {
                tail.next = new ListNode(scanner.nextInt());
                tail = tail.next;
            }
        }
        ListNode B = head;
        print(mergeTwoLists(A, B));
    }

    private static ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode C = new ListNode(0);
        ListNode cTemp = C;
        while (A != null || B != null) {
            if (B == null || (A != null && A.val < B.val)) {
                cTemp.next = A;
                A = A.next;
            } else {
                cTemp.next = B;
                B = B.next;
            }
            cTemp = cTemp.next;
            cTemp.next = null;
        }
        return C.next;
    }

    private static void print(ListNode A) {
        while (A != null) {
            System.out.println(A.val + " ");
            A = A.next;
        }
        System.out.println();
    }
}
