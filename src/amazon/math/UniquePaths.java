package amazon.math;

import java.util.Scanner;

public class UniquePaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        System.out.println(uniquePaths(m, n));
    }

    private static int uniquePaths(int A, int B) {
        if (A == 1 || B == 1) {
            return 1;
        }

        int m = A - 1;
        int n = B - 1;

        return (int) ((factorialByFactorial(m + n, m) / factorial(n)));
    }

    private static long factorial(int num) {
        long ans = 1;
        while (num > 1) {
            ans *= num--;
        }
        return ans;
    }

    private static long factorialByFactorial(int b, int s) {
        long ans = 1;
        while (b > s) {
            ans *= b--;
        }
        return ans;
    }
}
