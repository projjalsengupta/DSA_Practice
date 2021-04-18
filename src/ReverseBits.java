import java.util.Scanner;

public class ReverseBits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        System.out.println(reverse(n));
    }

    private static long reverse(long a) {
        long res = 0;
        int i = 31;
        while (a > 0) {
            res += (a % 2) * Math.pow(2, i--);
            a = a / 2;
        }
        return res;
    }
}
