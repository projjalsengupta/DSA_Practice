package amazon.linkedlist;

import java.util.Scanner;

public class AddTwoNumbersAsList {
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
        print(addTwoNumbers(A, B));
    }

    private static ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode C = new ListNode(0);
        ListNode iterator = C;
        int carry = 0;
        while (A != null & B != null) {
            int sum = A.val + B.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            iterator.next = new ListNode(sum);
            A = A.next;
            B = B.next;
            iterator = iterator.next;
        }
        while (A != null) {
            int sum = A.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            iterator.next = new ListNode(sum);
            A = A.next;
            iterator = iterator.next;
        }
        while (B != null) {
            int sum = B.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            iterator.next = new ListNode(sum);
            B = B.next;
            iterator = iterator.next;
        }
        if (carry > 0) {
            iterator.next = new ListNode(carry);
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
