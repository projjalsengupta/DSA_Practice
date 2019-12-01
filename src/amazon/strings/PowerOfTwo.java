package amazon.strings;

import java.math.BigInteger;
import java.util.Scanner;

public class PowerOfTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String A = scanner.nextLine();
        System.out.println(power(A));
    }

    private static int power(String A) {
        if (A.equals("1")) {
            return 0;
        }
        BigInteger bigInteger = new BigInteger(A);
        BigInteger two = new BigInteger("2");
        while (bigInteger.compareTo(new BigInteger("1")) > 0) {
            BigInteger[] val = bigInteger.divideAndRemainder(two);
            if (val[1].equals(new BigInteger("1"))) {
                return 0;
            }
            bigInteger = val[0];
        }
        return 1;
    }
}
