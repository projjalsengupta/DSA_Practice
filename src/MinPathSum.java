import java.util.ArrayList;
import java.util.Scanner;

public class MinPathSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(scanner.nextInt());
            }
            mat.add(list);
        }
        System.out.println(minPathSum(mat));
    }

    private static int minPathSum(ArrayList<ArrayList<Integer>> mat) {
        int m = mat.size();
        int n = mat.get(0).size();
        int[][] lookupMat = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cost = mat.get(i).get(j);
                if (i > 0 && j > 0) {
                    cost += Math.min(lookupMat[i][j - 1], lookupMat[i - 1][j]);
                } else if (i > 0) {
                    cost += lookupMat[i - 1][j];
                } else if (j > 0) {
                    cost += lookupMat[i][j - 1];
                }
                lookupMat[i][j] += cost;
            }
        }
        return lookupMat[m - 1][n - 1];
    }
}
