package amazon.strings;

import java.util.Scanner;

public class ATOI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String A = scanner.nextLine();
        System.out.println(atoi(A));
    }

    private static int atoi(final String A) {
        long num = 0;
        int sign = 1;
        for (int i = 0; i < A.length(); i++) {
            char a = A.charAt(i);
            int digit = (int) a - (int) '0';

            if (digit >= 0 && digit <= 9) {
                num *= 10;
                num += digit;
                if (sign == 1 && num > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if (sign == -1 && num > Integer.MAX_VALUE) {
                    return Integer.MIN_VALUE;
                }
            } else {
                if (i == 0) {
                    if (a == '-') {
                        sign = -1;
                    } else if (a != ' ' && a != '+') {
                        return (int) (sign * num);
                    }
                } else {
                    return (int) (sign * num);
                }
            }
        }
        return (int) (sign * num);
    }
}
