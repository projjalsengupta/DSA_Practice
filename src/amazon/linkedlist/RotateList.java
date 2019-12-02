package amazon.linkedlist;

import java.util.Scanner;

public class RotateList {
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
        print(rotateRight(head, B));
    }

    private static ListNode rotateRight(ListNode A, int B) {
        if (A == null || A.next == null || B == 0) {
            return A;
        }
        int count = 0;
        ListNode temp = A;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        B = B % count;
        if (B == 0) {
            return A;
        }
        int i = 0;
        temp = A;
        ListNode tail = A;
        ListNode head = A;
        ListNode prevHead = A;
        while (temp != null) {
            tail = temp;
            if (++i == (count - B)) {
                prevHead = temp;
                head = temp.next;
            }
            temp = temp.next;
        }
        tail.next = A;
        prevHead.next = null;
        A = head;
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
