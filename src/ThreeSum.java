import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ThreeSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> A = new ArrayList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            A.add(scanner.nextInt());
        }
        int M = scanner.nextInt();
        System.out.println(threeSum(A, M));
    }

    private static int threeSum(ArrayList<Integer> A, int M) {
        Collections.sort(A);
        int n = A.size() - 1;
        int cSum = A.get(n) + A.get(n - 1) + A.get(n - 2);
        for (int i = 0; i < A.size() - 2; i++) {
            int j = i + 1;
            int k = A.size() - 1;
            while (j < k) {
                int sum = A.get(i) + A.get(j) + A.get(k);
                if (Math.abs(M - sum) < Math.abs(M - cSum)) {
                    cSum = sum;
                }
                if (cSum > M) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return cSum;
    }
}
