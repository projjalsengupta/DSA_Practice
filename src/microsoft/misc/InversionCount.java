package microsoft.misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InversionCount {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(tokenizer.nextToken());
            }
            System.out.println(countInversions(arr));
        }
    }

    static class Count {
        long count;

        Count() {
            this.count = 0;
        }
    }

    private static long countInversions(int[] arr) {
        Count count = new Count();
        mergeSort(arr, 0, arr.length - 1, count);
        return count.count;
    }

    private static void merge(int[] arr, int left, int mid, int right, Count count) {
        int l = mid - left + 1;
        int m = right - mid;
        int[] lArr = new int[l];
        int[] rArr = new int[m];
        for (int i = 0; i < l; i++) {
            lArr[i] = arr[i + left];
        }
        for (int i = 0; i < m; i++) {
            rArr[i] = arr[i + mid + 1];
        }
        int i = 0;
        int j = 0;
        int k = left;
        while (i < l && j < m) {
            if (lArr[i] <= rArr[j]) {
                arr[k++] = lArr[i++];
            } else {
                arr[k++] = rArr[j++];
                count.count += l - i;
            }
        }
        while (i < l) {
            arr[k++] = lArr[i++];
        }
        while (j < m) {
            arr[k++] = rArr[j++];
        }
    }

    private static void mergeSort(int[] arr, int left, int right, Count count) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, count);
            mergeSort(arr, mid + 1, right, count);
            merge(arr, left, mid, right, count);
        }
    }
}
