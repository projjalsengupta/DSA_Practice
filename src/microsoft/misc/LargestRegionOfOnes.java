package microsoft.misc;

import java.util.Scanner;

public class LargestRegionOfOnes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] arr = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }
            System.out.println(largestRegion(arr, m, n));
        }
    }

    private static int largestRegion(int[][] arr, int m, int n) {
        int region = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    Value value = new Value();
                    dfs(arr, visited, value, i, j, m, n);
                    region = Math.max(region, value.region);
                }
            }
        }
        return region;
    }

    private static void dfs(int[][] arr, boolean[][] visited, Value value, int i, int j, int m, int n) {
        if (i >= m || i < 0 || j >= n || j < 0 || arr[i][j] == 0 || visited[i][j]) {
            return;
        }
        value.region++;
        visited[i][j] = true;
        dfs(arr, visited, value, i - 1, j, m, n);
        dfs(arr, visited, value, i + 1, j, m, n);
        dfs(arr, visited, value, i, j - 1, m, n);
        dfs(arr, visited, value, i, j + 1, m, n);
        dfs(arr, visited, value, i - 1, j - 1, m, n);
        dfs(arr, visited, value, i + 1, j + 1, m, n);
        dfs(arr, visited, value, i - 1, j + 1, m, n);
        dfs(arr, visited, value, i + 1, j - 1, m, n);
    }

    static class Value {
        int region;

        Value() {
            region = 0;
        }
    }
}
