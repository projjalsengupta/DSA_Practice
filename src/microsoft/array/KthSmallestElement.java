package microsoft.array;

import java.util.Scanner;

public class KthSmallestElement {
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
            System.out.println(kthSmallestElem(arr, k, 0, arr.length - 1));
        }
    }

    private static int partition(int[] arr, int left, int right) {
        if (left >= 0 && left < arr.length && right >= 0 && right < arr.length) {
            int i = left;
            int pivotIndex = ((int) (Math.random()) * (right - left)) + left;
            int temp = arr[right];
            arr[right] = arr[pivotIndex];
            arr[pivotIndex] = temp;
            int pivot = arr[right];
            for (int j = left; j <= right - 1; j++) {
                if (arr[j] < pivot) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    i++;
                }
            }
            temp = arr[i];
            arr[i] = arr[right];
            arr[right] = temp;
            return i;
        } else {
            return -1;
        }
    }

    private static int kthSmallestElem(int[] arr, int k, int left, int right) {
        int pos = partition(arr, left, right);
        if (pos == -1) {
            return -1;
        }
        if (pos == k - 1) {
            return arr[pos];
        } else if (pos > k - 1) {
            return kthSmallestElem(arr, k, left, pos - 1);
        }
        return kthSmallestElem(arr, k, pos + 1, right);
    }
}
