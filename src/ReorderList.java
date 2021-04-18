import java.util.Scanner;

public class ReorderList {
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
        print(reorderList(head));
    }

    private static ListNode reorderList(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }
        int count = 0;
        ListNode temp = A;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        count /= 2;
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
        ListNode aTemp = A;
        ListNode bTemp = B;
        while (aTemp != null && bTemp != null) {
            ListNode temp1 = aTemp.next;
            ListNode temp2 = bTemp.next;
            aTemp.next = bTemp;
            bTemp.next = temp1;
            aTemp = temp1;
            bTemp = temp2;
        }
        temp = A;
        while (temp.next != null) {
            temp = temp.next;
        }
        while (aTemp != null) {
            temp.next = aTemp;
            aTemp = aTemp.next;
        }
        while (bTemp != null) {
            temp.next = bTemp;
            bTemp = bTemp.next;
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
