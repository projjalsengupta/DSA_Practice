package amazon.twopointers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            A.add(scanner.nextInt());
        }
        System.out.println(removeDuplicates(A));
    }

    private static int removeDuplicates(ArrayList<Integer> A) {
        int s = A.size();
        int elem = A.get(0);
        int k = 1;
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) != elem) {
                A.set(k++, A.get(i));
            } else {
                s--;
            }
            elem = A.get(i);
        }
        return s;
    }
}
