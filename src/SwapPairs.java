import java.util.Scanner;

public class SwapPairs {
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
        print(swapPairs(head));
    }

    private static ListNode swapPairs(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }
        ListNode head = A.next;
        ListNode prev = null;
        while (A != null && A.next != null) {
            ListNode temp = A.next;
            A.next = A.next.next;
            temp.next = A;
            if (prev != null) {
                prev.next = temp;
            }
            prev = A;
            A = A.next;
        }
        return head;
    }

    private static void print(ListNode A) {
        while (A != null) {
            System.out.println(A.val + " ");
            A = A.next;
        }
        System.out.println();
    }
}
