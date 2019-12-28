package microsoft.misc;

import java.util.Scanner;

public class PerfectSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int k = scanner.nextInt();
            System.out.println(countPerfectSums(arr, k));
        }
    }

    private static int countPerfectSums(int[] arr, int k) {

        return 0;
    }
}
