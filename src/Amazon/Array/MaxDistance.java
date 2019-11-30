package Amazon.Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxDistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            A.add(scanner.nextInt());
        }
        System.out.println(maxDistance(A));
    }

    private static int maxDistance(final List<Integer> A) {
        int n = A.size();

        int[] lMin = new int[n];
        int[] rMax = new int[n];

        lMin[0] = A.get(0);
        for (int i = 1; i < n; i++) {
            lMin[i] = Math.min(A.get(i), lMin[i - 1]);
        }

        rMax[n - 1] = A.get(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            rMax[i] = Math.max(A.get(i), rMax[i + 1]);
        }

        int i = 0;
        int j = 0;
        int maxDiff = 0;

        while (i < n && j < n) {
            if (lMin[i] <= rMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j++;
            } else {
                i++;
            }
        }

        return maxDiff;
    }
}
