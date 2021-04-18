import java.util.Scanner;

public class MaxSumContagiousSubArray {
    private static int maxSumContagiousSubArray(int[] arr) {
        int max = Integer.MIN_VALUE;
        int currentMax = 0;
        for (int value : arr) {
            currentMax += value;
            if (currentMax > max) {
                max = currentMax;
            }
            if (currentMax < 0) {
                currentMax = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(maxSumContagiousSubArray(arr));
    }
}
