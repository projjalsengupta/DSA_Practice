package amazon.binarysearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedianOfArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(scanner.nextInt());
        }
        n = scanner.nextInt();
        List<Integer> b = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            b.add(scanner.nextInt());
        }
        System.out.println(findMedianSortedArrays(a, b));
    }

    private static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        if (a.size() > b.size()) {
            return findMedianSortedArrays(b, a);
        }
        int minIndex = 0;
        int maxIndex = a.size();
        int i = 0;
        int j = 0;
        double median = 0;

        while (minIndex <= maxIndex) {
            i = (minIndex + maxIndex) / 2;
            j = ((a.size() + b.size() + 1) / 2) - i;
            if (i < a.size() && j > 0 && b.get(j - 1) > a.get(i)) {
                minIndex = i + 1;
            } else if (i > 0 && j < b.size() && b.get(j) < a.get(i - 1)) {
                maxIndex = i - 1;
            } else {
                if (i == 0) {
                    median = b.get(j - 1);
                } else if (j == 0) {
                    median = a.get(i - 1);
                } else {
                    median = Math.max(a.get(i - 1),
                            b.get(j - 1));
                }
                break;
            }
        }
        if ((a.size() + b.size()) % 2 == 1) {
            return median;
        }
        if (i == a.size()) {
            return (median + b.get(j)) / 2.0;
        }
        if (j == b.size()) {
            return (median + a.get(i)) / 2.0;
        }
        return (median + Math.min(a.get(i), b.get(j))) / 2.0;
    }
}
