package microsoft.misc;

import java.util.Scanner;

public class CountNumberOfPaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            System.out.println(countPaths(m, n, 1, 1));
        }
    }

    private static int countPaths(int m, int n, int currentM, int currentN) {
        if (currentM == m && currentN == n) {
            return 1;
        }
        if (currentM > m || currentN > n) {
            return 0;
        }
        return countPaths(m, n, currentM + 1, currentN) + countPaths(m, n, currentM, currentN + 1);
    }
}
