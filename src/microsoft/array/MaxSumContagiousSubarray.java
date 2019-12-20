package microsoft.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxSumContagiousSubarray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> A = new ArrayList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            A.add(scanner.nextInt());
        }
        System.out.println(maxSubArray(A));
    }

    private static int maxSubArray(List<Integer> A) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (Integer a : A) {
            sum += a;
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
