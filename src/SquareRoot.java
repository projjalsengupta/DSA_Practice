import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        System.out.println(sqrt(A));
    }

    private static int sqrt(int A) {
        long l = 0;
        long r = A;
        int res = 0;
        while (l <= r) {
            long m = (l + r) / 2;
            if (m * m == A || ((m * m < A) && ((m + 1) * (m + 1) > A))) {
                return (int) m;
            } else if (m * m < A) {
                l = m + 1;
                res = (int) m;
            } else if (m * m > A) {
                r = m - 1;
                res = (int) m;
            }
        }
        return res;
    }
}
