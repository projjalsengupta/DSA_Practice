package amazon.strings;

import java.util.Scanner;

public class ReverseTheString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String A = scanner.nextLine();
        System.out.println(solve(A));
    }

    private static String solve(String A) {
        String[] parts = A.split("[ ]");
        StringBuilder res = new StringBuilder();
        for (int i = parts.length - 1; i >= 0; i--) {
            res.append(parts[i].trim());
            if (!parts[i].trim().equals("")) {
                res.append(" ");
            }
        }
        return res.toString().trim();
    }
}
