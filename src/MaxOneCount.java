import java.util.Scanner;

public class MaxOneCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] mat = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = scanner.nextInt();
                }
            }
            System.out.println(maxCount1s(mat));
        }
    }

    private static int first1Index(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == 1) {
                if (mid == 0) {
                    return mid;
                } else if (arr[mid - 1] == 0) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private static int maxCount1s(int[][] mat) {
        int max = 0;
        int maxIndex = -1;
        for (int i = 0; i < mat.length; i++) {
            int index = first1Index(mat[i]);
            if (index != -1 && mat[i].length - index > max) {
                max = mat[i].length - index;
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}

/*      2
        4 7
        0 0 1 1 1 1 1 0 0 0 1 1 1 1 0 0 0 0 0 1 1 0 0 0 1 1 1 1
        10 3
        0 0 1 0 1 1 0 1 1 1 1 1 0 0 1 0 0 1 0 1 1 0 0 1 0 0 0 1 1 1
 */