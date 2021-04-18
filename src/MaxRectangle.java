import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class MaxRectangle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(tokenizer.nextToken());
            int n = Integer.parseInt(tokenizer.nextToken());
            int[][] arr = new int[m][n];
            tokenizer = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }
            System.out.println(maxArea(arr, n, m));
        }
    }

    private static int maxArea(int[][] a, int n, int m) {
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1 && i > 0) {
                    a[i][j] = a[i - 1][j] + 1;
                }
            }
            maxArea = Math.max(maxArea, maxAreaUtil(a[i]));
        }
        return maxArea;
    }

    private static int maxAreaUtil(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        int i = 1;
        while (i < arr.length) {
            if (stack.empty() || arr[stack.peek()] <= arr[i]) {
                stack.push(i++);
            } else {
                int index = stack.pop();
                if (stack.isEmpty()) {
                    maxArea = Math.max(maxArea, arr[index] * i);
                } else {
                    maxArea = Math.max(maxArea, arr[index] * (i - stack.peek() - 1));
                }
            }
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            if (stack.isEmpty()) {
                maxArea = Math.max(maxArea, arr[index] * i);
            } else {
                maxArea = Math.max(maxArea, arr[index] * (i - stack.peek() - 1));
            }
        }
        return maxArea;
    }
}
