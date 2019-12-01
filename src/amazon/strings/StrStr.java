package amazon.strings;

import java.util.Scanner;

public class StrStr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String A = scanner.nextLine();
        String B = scanner.nextLine();
        System.out.println(strStr(A, B));
    }

    private static int strStr(final String A, final String B) {
        int j = 0;
        int[] lps = computeLPSArray(B);
        int i = 0;
        while (i < A.length()) {
            if (B.charAt(j) == A.charAt(i)) {
                j++;
                i++;
            }
            if (j == B.length()) {
                return i - j;
            } else if (i < A.length() && B.charAt(j) != A.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }
        return -1;
    }

    private static int[] computeLPSArray(String B) {
        int bLen = B.length();
        int[] lps = new int[bLen];
        int i = 1;
        int j = 0;
        lps[0] = 0;
        while (i < bLen) {
            if (B.charAt(i) == B.charAt(j)) {
                lps[i] = j + 1;
                j++;
                i++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
