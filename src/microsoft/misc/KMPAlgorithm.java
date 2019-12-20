package microsoft.misc;

import java.util.Scanner;

public class KMPAlgorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String pattern = scanner.nextLine();
        System.out.println(searchPattern(line, pattern));
    }

    private static int searchPattern(String line, String pattern) {
        int[] lps = lpsArray(pattern);
        int i = 0;
        int j = 0;
        while (i < line.length()) {
            if (pattern.charAt(j) == line.charAt(i)) {
                j++;
                i++;
            }
            if (j == pattern.length()) {
                return i - j;
            } else if (i < line.length() && pattern.charAt(j) != line.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }

    private static int[] lpsArray(String pattern) {
        int[] lps = new int[pattern.length()];
        lps[0] = 0;
        int i = 0;
        int j = 1;
        while (j < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                lps[j] = i + 1;
                i++;
                j++;
            } else {
                if (i != 0) {
                    i = lps[i - 1];
                } else {
                    lps[j] = i;
                    j++;
                }
            }
        }
        return lps;
    }
}
