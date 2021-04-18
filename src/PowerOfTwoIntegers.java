import java.util.Scanner;

public class PowerOfTwoIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        System.out.println(isPower(A));
    }

    private static int isPower(int A) {
        if (A == 1) {
            return 1;
        }
        for (int i = 2; i <= Math.sqrt(A); i++) {
            int P = (int) (Math.log(A) / Math.log(i));
            if (Math.pow(i, P) == A) {
                return 1;
            }
        }
        return 0;
    }
}
