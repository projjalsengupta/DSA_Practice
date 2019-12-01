package amazon.bitmanipulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DivideIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        System.out.println(divide(A, B));
    }

    private static int divide(int A, int B) {
        if (A == Integer.MIN_VALUE && B == -1) {
            return Integer.MAX_VALUE;
        } else if (B == 1) {
            return A;
        }
        int sign = (A < 0) ^ (B < 0) ? -1 : 1;
        if (A == Integer.MIN_VALUE) {
            A = Integer.MAX_VALUE;
        } else {
            A = Math.abs(A);
        }
        B = Math.abs(B);
        int res = 0;
        while (A >= B) {
            A -= B;
            res++;
        }
        return sign * res;
    }
}
