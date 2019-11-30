package amazon.math;

import java.util.Scanner;

public class ExcelColumnNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String A = scanner.nextLine();
        System.out.println(titleToNumber(A));
    }

    private static int titleToNumber(String A) {
        int total = 0;
        int pow = 0;
        for (int i = A.length() - 1; i >= 0; i--) {
            int num = A.charAt(i) - 'A' + 1;
            num *= Math.pow(26, pow++);
            total += num;
        }
        return total;
    }
}
