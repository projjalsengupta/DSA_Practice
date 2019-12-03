package amazon.linkedlist;

import java.util.Scanner;

public class Palindrome {
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
        System.out.println(lPalin(head));
    }

    private static int lPalin(ListNode A) {
        if (A == null) {
            return 0;
        }
        if (A.next == null) {
            return 1;
        }
        int count = 0;
        ListNode temp = A;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        count = (count / 2);
        temp = A;
        ListNode prev = null;
        while (count-- > 0) {
            prev = temp;
            temp = temp.next;
        }
        if (prev != null) {
            prev.next = null;
        }
        ListNode B = temp;
        temp = temp.next;
        B.next = null;
        while (temp != null) {
            ListNode temp2 = temp.next;
            temp.next = B;
            B = temp;
            temp = temp2;
        }
        while (A != null && B != null) {
            if (A.val != B.val) {
                return 0;
            }
            A = A.next;
            B = B.next;
        }
        return 1;
    }

    private static void print(ListNode A) {
        while (A != null) {
            System.out.println(A.val + " ");
            A = A.next;
        }
        System.out.println();
    }

}
