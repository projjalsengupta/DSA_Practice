import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxProductSubArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> A = new ArrayList<>();
        while (n-- > 0) {
            A.add(scanner.nextInt());
        }
        System.out.println(maxProduct(A));
    }

    private static int maxProduct(final List<Integer> A) {
        int maxProduct = 1;
        int maxProductSoFar = 1;
        int minProductSoFar = 1;
        boolean flag = false;

        for (Integer a : A) {
            if (a > 0) {
                maxProductSoFar = maxProductSoFar * a;
                minProductSoFar = Math.min(minProductSoFar * a, 1);
                flag = true;
            } else if (a < 0) {
                int temp = maxProductSoFar;
                maxProductSoFar = Math.max(minProductSoFar * a, 1);
                minProductSoFar = temp * a;
            } else {
                maxProductSoFar = 1;
                minProductSoFar = 1;
            }
            if (maxProductSoFar > maxProduct) {
                maxProduct = maxProductSoFar;
            }
        }

        if (flag || maxProduct > 1) {
            return maxProduct;
        }
        return 0;
    }
}
