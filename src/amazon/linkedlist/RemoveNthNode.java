package amazon.linkedlist;

import java.util.Scanner;

public class RemoveNthNode {
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
        print(removeNthFromEnd(head, B));
    }

    private static ListNode removeNthFromEnd(ListNode A, int B) {
        if (A == null) {
            return A;
        }
        int count = 0;
        ListNode temp = A;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        if (B >= count) {
            return A.next;
        }
        temp = A;
        ListNode temp2 = temp;
        int i = 0;
        while (i++ < (count - B)) {
            temp2 = temp;
            temp = temp.next;
        }
        temp2.next = temp.next;
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
