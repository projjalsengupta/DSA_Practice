package amazon.dynamic;

import java.util.Scanner;

public class EditDistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String A = scanner.nextLine();
        String B = scanner.nextLine();
        System.out.println(minDistance(A, B));
    }

    private static int minDistance(String A, String B) {
        int[][] lookup = new int[A.length() + 1][B.length() + 1];
        for (int i = 0; i < lookup.length; i++) {
            for (int j = 0; j < lookup[i].length; j++) {
                if (i == 0) {
                    lookup[i][j] = j;
                } else if (j == 0) {
                    lookup[i][j] = i;
                } else if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    lookup[i][j] = lookup[i - 1][j - 1];
                } else {
                    lookup[i][j] = 1 + Math.min(lookup[i][j - 1], Math.min(lookup[i - 1][j], lookup[i - 1][j - 1]));
                }
            }
        }
        return lookup[lookup.length - 1][lookup[0].length - 1];
    }
}
