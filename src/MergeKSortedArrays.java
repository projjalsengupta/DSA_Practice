import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MergeKSortedArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int k = scanner.nextInt();
            int[][] arrays = new int[k][k];
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < k; j++) {
                    arrays[i][j] = scanner.nextInt();
                }
            }
            System.out.println(mergeKArrays(arrays, k));
        }
    }

    private static ArrayList<Integer> mergeKArrays(int[][] arrays, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                res.add(arrays[i][j]);
            }
        }
        Collections.sort(res);
        return res;
    }
}
