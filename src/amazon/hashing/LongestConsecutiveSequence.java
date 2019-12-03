package amazon.hashing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            A.add(scanner.nextInt());
        }
        System.out.println(longestConsecutive(A));
    }

    private static int longestConsecutive(final List<Integer> A) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (Integer a : A) {
            if (a > max) {
                max = a;
            }
            if (a < min) {
                min = a;
            }
        }
        boolean[] hash = new boolean[max - min + 1];
        for (Integer a : A) {
            hash[a - min] = true;
        }
        int counter = 0;
        int res = 0;
        for (boolean b : hash) {
            if (b) {
                counter++;
            } else {
                counter = 0;
            }
            if (counter > res) {
                res = counter;
            }
        }
        return res;
    }
}
