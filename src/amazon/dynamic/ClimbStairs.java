package amazon.dynamic;

import java.util.Scanner;

public class ClimbStairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        System.out.println(climbStairs(A));
    }

    private static int climbStairs(int A) {
        int[] stairs = new int[A + 1];
        stairs[0] = 1;
        stairs[1] = 1;
        for (int i = 2; i <= A; i++) {
            stairs[i] = stairs[i - 1] + stairs[i - 2];
        }
        return stairs[A];
    }
}
