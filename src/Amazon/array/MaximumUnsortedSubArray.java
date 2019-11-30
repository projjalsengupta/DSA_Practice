package Amazon.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MaximumUnsortedSubArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            A.add(scanner.nextInt());
        }
        print(subUnsort(A));
    }

    private static ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>(A);
        Collections.sort(B);
        int start = -1;
        int end = -1;
        for (int i = 0; i < A.size(); i++) {
            if (!A.get(i).equals(B.get(i))) {
                if (start == -1) {
                    start = i;
                } else {
                    end = i;
                }
            }
        }
        if (start != -1 && end != -1) {
            res.add(start);
            res.add(end);
        }
        if (res.isEmpty()) {
            res.add(-1);
        }
        return res;
    }

    private static void print(ArrayList<Integer> A) {
        for (Integer a : A) {
            System.out.println(a);
        }
    }
}
