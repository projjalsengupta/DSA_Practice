package amazon.math;

import java.util.Scanner;

public class ExcelColumnTitle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        System.out.println(convertToTitle(A));
    }

    private static String convertToTitle(int A) {
        StringBuilder stringBuilder = new StringBuilder();
        while (A > 0) {
            int v = A % 26;
            char ch;
            if (v == 0) {
                ch = (char) (26 + ((int) 'A') - 1);
                A = (A / 26) - 1;
            } else {
                ch = (char) (v + ((int) 'A') - 1);
                A /= 26;
            }
            stringBuilder.append(ch);
        }
        return stringBuilder.reverse().toString();
    }
}
