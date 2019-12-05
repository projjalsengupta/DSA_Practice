package amazon.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LongestIncreasingSubSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> A = new ArrayList<>();
        while (n-- > 0) {
            A.add(scanner.nextInt());
        }
        System.out.println(lis(A));
    }

    private static int lis(final List<Integer> A) {
        int[] lis = new int[A.size()];
        Arrays.fill(lis, 1);
        for (int i = 1; i < lis.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A.get(i) > A.get(j)) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }
        int max = 0;
        for (int a : lis) {
            if (a > max) {
                max = a;
            }
        }
        return max;
    }
}
