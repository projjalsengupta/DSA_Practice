package amazon.binarysearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RotatedSortedArraySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            A.add(scanner.nextInt());
        }
        int B = scanner.nextInt();
        System.out.println(search(A, B));
    }

    private static int search(final List<Integer> A, int B) {
        int pivot = findPivot(A);
        if (pivot == -1) {
            return binarySearch(A, B, 0, A.size() - 1);
        } else if (A.get(pivot) == B) {
            return pivot;
        } else if (A.get(0) <= B) {
            return binarySearch(A, B, 0, pivot - 1);
        } else {
            return binarySearch(A, B, pivot + 1, A.size() - 1);
        }
    }

    private static int binarySearch(final List<Integer> A, int B, int l, int r) {
        while (l <= r) {
            int m = (l + r) / 2;
            if (A.get(m) == B) {
                return m;
            } else if (A.get(m) < B) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    private static int findPivot(final List<Integer> A) {
        int l = 0;
        int r = A.size() - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (l == r) {
                return m;
            }
            if (m < r && A.get(m) > A.get(m + 1)) {
                return m;
            } else if (m > l && A.get(m) < A.get(m - 1)) {
                return m - 1;
            } else if (A.get(l) >= A.get(m)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}
