import java.util.ArrayList;
import java.util.Scanner;

public class JumpGameArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> A = new ArrayList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            A.add(scanner.nextInt());
        }
        System.out.println(jump(A));
    }

    private static int jump(ArrayList<Integer> A) {
        int[] jumps = new int[A.size()];
        if (A.size() == 1) {
            return 1;
        }
        if (A.size() == 0 || A.get(0) == 0) {
            return 0;
        }
        jumps[0] = 0;
        for (int i = 1; i < A.size(); i++) {
            jumps[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (i <= j + A.get(j) && jumps[j] != Integer.MAX_VALUE) {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                    break;
                }
            }
        }
        return jumps[A.size() - 1] == Integer.MAX_VALUE ? 0 : 1;
    }
}
