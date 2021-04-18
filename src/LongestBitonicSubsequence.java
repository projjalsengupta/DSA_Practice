import java.util.Scanner;

public class LongestBitonicSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            lbs = 0;
            longestBitonicSubsequence(arr, 0, -1, 0, true);
            System.out.println(lbs);
        }
    }

    private static int lbs = 0;
    private static int prevMaxLbs = 0;

    private static void longestBitonicSubsequence(int[] arr, int count, int prevIndex, int newIndex, boolean increasing) {
        lbs = Math.max(lbs, count);
        if (newIndex >= arr.length) {
            return;
        }
        if (increasing) {
            if (prevIndex != -1) {
                if (arr[prevIndex] < arr[newIndex]) {
                    longestBitonicSubsequence(arr, count + 1, newIndex, newIndex + 1, true);
                } else {
                    longestBitonicSubsequence(arr, count, prevIndex, newIndex + 1, true);
                    longestBitonicSubsequence(arr, count + 1, newIndex, newIndex + 1, false);
                }
            } else {
                longestBitonicSubsequence(arr, count + 1, newIndex, newIndex + 1, true);
            }
        } else {
            if (arr[prevIndex] > arr[newIndex]) {
                longestBitonicSubsequence(arr, count + 1, newIndex, newIndex + 1, true);
            }
        }
    }
}
