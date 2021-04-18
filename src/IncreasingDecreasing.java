import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class IncreasingDecreasing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            System.out.println(increasingDecreasing(line));
        }
    }

    private static String increasingDecreasing(String line) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= line.length(); i++) {
            stack.push(i + 1);
            if (i == line.length() || line.charAt(i) == 'I') {
                while (!stack.isEmpty()) {
                    sb.append(stack.peek());
                    stack.pop();
                }
            }
        }
        return sb.toString();
    }
}
